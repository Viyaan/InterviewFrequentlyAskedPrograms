package interview.thread.programs;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Let,say you are going to work on productId comparision website, you will get
 * productId of a product from multiple websites, like amazon, ebay etc. we are
 * aggregating those productIds and then returning back to the user.
 *
 */
public class ScatterGatherDemoV2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		System.out.println("Prices from all Enternal Sources are "+getPrices(1245));

	}

	private static Set<Integer> getPrices(int productId) throws InterruptedException, ExecutionException, TimeoutException {
		String amazonURL = "";
		String walmartURL = "";
		String ebayURL = "";
		String flipkartURL = "";

		Set<Integer> prices = new ConcurrentSkipListSet();
		CountDownLatch latch = new CountDownLatch(4);
		CompletableFuture<Void> task1 = CompletableFuture.runAsync(new OnlineVendor(amazonURL, productId,  prices));
		CompletableFuture<Void> task2 = CompletableFuture.runAsync(new OnlineVendor(walmartURL, productId,  prices));
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(new OnlineVendor(ebayURL, productId,  prices));
		CompletableFuture<Void> task4 = CompletableFuture.runAsync(new OnlineVendor(flipkartURL, productId,  prices));
		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3, task4);
		allTasks.get(3, TimeUnit.SECONDS);
		return prices;
	}
}

class OnlineVendor implements Runnable {

	String url = "";
	int productId = 0;
	Set prices;

	public OnlineVendor(String url, int productId,  Set prices) {
		this.url = url;
		this.productId = productId;
		this.prices = prices;
	}

	@Override
	public void run() {
		// Assume you hit some REST Endpoints and get price for each URL.
		int price = 0;
		prices.add(price);
	}
}
