package co.yedam.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainExe {

	public static void main(String[] args) {

//		MysqlDao dao = new MysqlDao();
//		OracleDao dao = new OracleDao();
		Dao dao = new OracleDao();

//		dao.add();
//		
//		dao.modify();
//		
//		dao.find();
//		
//		dao.del();

		dao.insert();

		dao.modify();

		dao.search();

		dao.remove();

		Map<String, String> map = new HashMap<>();
		map.put("001", "kim");
		map.put("002", "shin");

		Set<String> set = map.keySet();
		for (String str : set) {
			System.out.println("Key :" + str);
		}
		Set<Map.Entry<String, String>> ent = map.entrySet();

		System.out.println(map.get("001"));

	}

}
