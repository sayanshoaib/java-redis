import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {
    private static final String HOST = "localhost";
    private static final Integer PORT = 6379;

    private RedisClient() {
    }

    public static Jedis getRedisConnection() {
        JedisPool pool = new JedisPool(HOST, PORT);
        return pool.getResource();
    }
}
