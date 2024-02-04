import redis.clients.jedis.Jedis;

public class RedisListDemo {
    public static void main(String[] args) {
        RedisClient client = new RedisClient("localhost", 6379);
        try (Jedis jedis = client.getRedisConnection()) {
            jedis.lpush("messages", "tesla");
            jedis.lpush("messages", "audi");
            jedis.lpush("messages", "bmw");
            jedis.lpop("messages");
            jedis.lpop("messages");
            jedis.lpop("messages");
            jedis.rpop("messages");
            jedis.rpop("messages");
            var length = jedis.llen("messages");
            System.out.println(length);
        }
    }
}
