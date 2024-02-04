import redis.clients.jedis.Jedis;

public class RedisListDemo {
    public static void main(String[] args) {
        try (Jedis jedis = RedisClient.getRedisConnection()) {
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
            var list = jedis.lrange("messages", 0, -1);
            System.out.println(list);
        }
    }
}
