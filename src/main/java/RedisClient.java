import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {
    private String host;
    private Integer port;

    public RedisClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public Jedis getRedisConnection() {
        JedisPool pool = new JedisPool(host, port);
        return pool.getResource();
    }
}
