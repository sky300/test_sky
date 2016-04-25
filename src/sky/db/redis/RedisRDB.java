package sky.db.redis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import redis.clients.jedis.Jedis;

public class RedisRDB {
	
	public static void main(String[] args) {
		 //连接本地的 Redis 服务
	    Jedis jedis = new Jedis("localhost");
//	    jedis.set("a", "hello world");
//	    jedis.set("b", "hello world");
//	    jedis.set("c", "hello world");
//	    jedis.set("d", "hello world");
//	    jedis.bgsave();
//	    long a = jedis.lastsave();
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    System.out.println(sdf.format(new Date(a)));
	    Iterator<String> it = jedis.keys("*").iterator();
	    while (it.hasNext()) {
	    	String str = it.next();
	    	System.out.println(str);
		}
	}
	
}
