import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.params.XAddParams;
import redis.clients.jedis.params.XPendingParams;
import redis.clients.jedis.params.XReadParams;
import redis.clients.jedis.resps.StreamEntry;
import redis.clients.jedis.resps.StreamPendingEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisStreamsDemo {
    public static void main(String[] args) {
        try (Jedis jedis = RedisClient.getRedisConnection()) {
            StreamEntryID res1 = jedis.xadd(
                    "race:france",
                    new HashMap<String, String>(){{
                        put("rider","Beckham");
                        put("speed","32.4");
                        put("position","1");
                        put("location_id","1");
                    }},
                    XAddParams.xAddParams());

            System.out.println(res1);

            List<Map.Entry<String, List<StreamEntry>>> streams = jedis.xread(
                    XReadParams.xReadParams().block(300).count(100),
                    new HashMap<String, StreamEntryID>(){{put("race:france",new StreamEntryID());}}
            );

            for (var stream: streams) {
                System.out.println(stream.getKey() + ": ");
                for (var res: stream.getValue()) {
                    System.out.println("    " + res);
                }
            }

            List<Map.Entry<String, List<StreamEntry>>> res18= jedis.xread(
                    XReadParams.xReadParams().count(5),
                    new HashMap<String,StreamEntryID>(){{put("race:france",new StreamEntryID());}});
            System.out.println(res18);
        }
    }
}
