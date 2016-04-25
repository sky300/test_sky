package sky.db.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTranscationsJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//连接本地的 Redis 服务
	      Jedis jedis = new Jedis("localhost");
	      System.out.println("Connection to server sucessfully");
//	      System.out.println(jedis.watch("w3ckey"));
	      //开启事务
	      Transaction tx = jedis.multi();
	      //设置 redis 字符串数据
	      tx.set("db", "Redis tutorial");
	      tx.append("db", " sky~~~");
	      tx.append("db", " 123455");
	      //提交事务
	      List<Object> results = tx.exec();
	     // 获取存储的数据并输出
	     System.out.println("Stored string in redis:: "+ jedis.get("db"));
	     for (Object object : results) {
			System.out.println(object.toString());
		}
	     jedis.disconnect();

	}

}
