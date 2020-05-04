package interview.collections.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Viyaan
 * 
 *         Our task is to sort the hashmap according to values.
 * 
 *         Expected output :
 * 
 *         {Java2Novice=2, java=20, MAC=26, C++=45, Unix=67, Why this
 *         kolavari=93}
 *
 * 
 */
public class SortMapOnValue {

	public static void main(String[] args) {
		Map<String, Integer> unsortMap = new HashMap<String, Integer>();
		unsortMap.put("java", 20);
		unsortMap.put("C++", 45);
		unsortMap.put("Java2Novice", 2);
		unsortMap.put("Unix", 67);
		unsortMap.put("MAC", 26);
		unsortMap.put("Why this kolavari", 93);
		Set<Entry<String, Integer>> set = unsortMap.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		HashMap<String, Integer> sortedByValueJava5 = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedByValueJava5.put(entry.getKey(), entry.getValue());
		}
		System.out.println(sortedByValueJava5);
		/**************************** Streams **************************************/
		Map<String, Integer> sortedByValueStreams = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(sortedByValueStreams);

		/**************************** Or More Readable **************************************/
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();

		unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(map -> linkedHashMap.put(map.getKey(), map.getValue()));
		
		System.out.println(linkedHashMap);

	}

}
