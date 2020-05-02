package interview.thread.programs;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Let,say you are going to work on productId comparision website, you will get
 * productId of a product from multiple websites, like amazon, ebay etc. we are
 * aggregating those productIds and then returning back to the user.
 *
 */
public class ScatterGatherDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Prices from all Enternal Sources are "+getPrices(1245));

	}

	private static Set<Integer> getPrices(int productId) throws InterruptedException {
		String amazonURL = "";
		String walmartURL = "";
		String ebayURL = "";
		String flipkartURL = "";

		Set<Integer> prices = new ConcurrentSkipListSet();
		CountDownLatch latch = new CountDownLatch(4);
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.submit(new OnlineMegaMart(amazonURL, productId, latch, prices));
		executorService.submit(new OnlineMegaMart(walmartURL, productId, latch, prices));
		executorService.submit(new OnlineMegaMart(ebayURL, productId, latch, prices));
		executorService.submit(new OnlineMegaMart(flipkartURL, productId, latch, prices));
		latch.await(3, TimeUnit.SECONDS);
		return prices;
	}
}

class OnlineMegaMart implements Runnable {

	String url = "";
	int productId = 0;
	CountDownLatch latch;
	Set prices;

	public OnlineMegaMart(String url, int productId, CountDownLatch latch, Set prices) {
		this.url = url;
		this.productId = productId;
		this.latch = latch;
		this.prices = prices;
	}

	@Override
	public void run() {
		// Assume you hit some REST Endpoints and get price for each URL.
		int price = 0;
		prices.add(price);
		latch.countDown();
	}
}
