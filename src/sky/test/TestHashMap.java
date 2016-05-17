package sky.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TestHashMap {

	/**
	 * 遍历HashMap
	 */
	public static void main(String[] args) {
		System.out.println("---------------------遍历HashMap------------------------------------------");
		Map<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("1", "hello");
		tempMap.put("2", "11111");
		tempMap.put("3", "22222");
		tempMap.forEach((aaa,value)->System.out.println(aaa+value));
		
		/*
		 * System.out.println(tempMap.keySet());
		 * System.out.println(tempMap.entrySet());
		 */
		StringBuffer sb = new StringBuffer();
		Iterator<Map.Entry<String, String>> it = tempMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
//			System.out.print("Key值为：" + entry.getKey() + "    ");
//			System.out.println("Value值为：" + entry.getValue());
			sb.append("Key值为：" + entry.getKey() + "    ");
			sb.append("Value值为：" + entry.getValue() + "\n");
		}
		System.out.println(sb.toString());
		System.out.println("---------------------遍历HashSet------------------------------------------");
		/**
		 * 遍历HashSet
		 */
		Set<String> set = new HashSet<String>();
		set.add("hello");
		set.add("world");
		set.add("bye");
		set.add("hello");
		set.add("Hello");
		System.out.println("set大小为："+set.size());
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String str = ite.next();
			System.out.println(str);
		}
		set.forEach(str -> System.out.println("Lambda遍历---"+str));
		System.out.println("---------------------遍历ArrayList-------------------------------------");
		/**
		 * 遍历ArrayList
		 */
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		Iterator<String> itList = list.iterator();
		while (itList.hasNext()) {
			String str = itList.next();
			System.out.println(str);
		}
		System.out.println("---------------------forearch遍历ArrayList----------------------------");
		/**
		 * forearch遍历list
		 */
		for (String string : list) {
			System.out.println(string);
		}
		//*********************************************************************************************************************
		Map<Object,Object> objectMap = new HashMap<Object, Object>();
		objectMap.put("oSet", set);
		objectMap.put("Olist", list);	
		//*********************************************************************************************************************
	}
}
