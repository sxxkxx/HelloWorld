package co.yedam.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExe {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("son", 07);
		map.put("lee", 19);
		map.put("kim", 03);
		map.put("kim", 01);

		map.remove("kim");

		if (map.containsKey("son")) {
			Integer result = map.get("son");
			System.out.println("등번호 " + result);
		}
		System.out.println("종료");

		// 반복된 요소 출력.

		Set<String> keys = map.keySet(); // 키값만 set 컬렉션에 저장.
		for (String key : keys) {
			Integer val = map.get(key);
			System.out.printf("%s의 등번호는 %d\n", key, val);
		}
		System.out.println();
		
		Set<Entry<String, Integer>> entrySet = map.entrySet(); // k, v => {K, V}
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.printf("%s의 등번호는 %d\n", key, val);
		}
	}

}
