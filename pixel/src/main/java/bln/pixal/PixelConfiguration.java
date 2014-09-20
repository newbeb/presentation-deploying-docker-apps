package bln.pixal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Configuration for the Pixel Server
 *
 * Based heavily on the messaging-redis example
 * @see https://spring.io/guides/gs/messaging-redis/
 *
 * @author Brian Lloyd-Newberry @brianln
 */
@Configuration
public class PixelConfiguration {

    private Logger log = LoggerFactory.getLogger("PixelConfiguration");

    // This is configured to read the Redis address and port from environmental variables, which will be set in docker w/ a link of
    // --link targetcontainername:redis
    @Bean
    RedisConnectionFactory connectionFactory(@Value("${REDIS_PORT_6379_TCP_ADDR:localhost}") String hostname,
                                             @Value("${REDIS_PORT_6379_TCP_PORT:6379}") String port) {

        log.info("Configuring Jedis connection: host: {}, port: {}.", hostname, port);
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(hostname);
        factory.setPort(Integer.valueOf(port));

        return factory;
    }

    @Bean
    StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

}
