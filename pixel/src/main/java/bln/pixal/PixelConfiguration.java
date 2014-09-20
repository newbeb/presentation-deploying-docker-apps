package bln.pixal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
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
@EnableAutoConfiguration
public class PixelConfiguration {

    // Note, there is no RedisConnectionFactory here as it will use the default, which defaults to Redis on Localhost
    // Feel free to create your own if necessary
    // This configuration will by default bind to localhost and port 6379

    @Bean
    StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

}
