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
import java.util.stream.Collectors;

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
		
		list.sort(new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
		/**************************** Java 8 **************************************/
		Map<String, Integer> sortedByValue = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(sortedByValue);
	}

}
