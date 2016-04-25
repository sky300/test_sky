package sky.db.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisKeyJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// 获取数据并输出
//		List<String> list = jedis.keys("*");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("List of stored keys:: " + list.get(i));
//		}
	}

}
