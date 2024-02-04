import redis.clients.jedis.Jedis;

public class RedisSetDemo {
    public static void main(String[] args) {
        try (Jedis jedis = RedisClient.getRedisConnection()) {
            var res = jedis.sadd("ip", "192.168.0.0");
            System.out.println(res);
            res = jedis.sadd("ip", "192.168.0.1");
            System.out.println(res);
            res = jedis.sadd("ip", "192.168.0.2");
            System.out.println(res);
            res = jedis.sadd("ip", "192.168.0.3");
            System.out.println(res);
            var removeElem = jedis.srem("ip", "192.168.0.3");
            System.out.println(removeElem);
            var isMember = jedis.sismember("ip", "192.168.0.2");
            System.out.println(isMember);
        }
    }
}
