import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisMapDemo {
    public static void main(String[] args) {
        Map<String, String> bike6 = new HashMap<>();
        bike6.put("model", "Deimos");
        bike6.put("brand", "Ergonom");
        bike6.put("type", "Enduro bikes");
        bike6.put("price", "4972");
        try (Jedis jedis = RedisClient.getRedisConnection()) {
            var res = jedis.hset("bike:6", bike6);
            System.out.println(res);
            var bikeResponse = jedis.hgetAll("bike:6");
            System.out.println(bikeResponse);
        }
    }
}
