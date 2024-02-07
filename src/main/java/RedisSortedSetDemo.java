import redis.clients.jedis.Jedis;

public class RedisSortedSetDemo {
    public static void main(String[] args) {
        try (Jedis jedis = RedisClient.getRedisConnection()) {
            var res = jedis.zadd("chess", 2760, "Ding Liren");
            System.out.println(res);
            res = jedis.zadd("chess", 2780, "Fabiano Caruana");
            System.out.println(res);
            res = jedis.zadd("chess", 2720, "Maxime Vachier-Lagrave");
            System.out.println(res);
            res = jedis.zadd("chess", 2800, "Magnus Carlsen");
            System.out.println(res);
            res = jedis.zadd("chess", 2730, "Hikaru Nakamura");
            System.out.println(res);
            var revRange = jedis.zrevrange("chess", 0, -1);
            System.out.println(revRange);
        }
    }
}
