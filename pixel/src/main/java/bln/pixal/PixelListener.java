package bln.pixal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple Pixel listener
 *
 * @author Brian Lloyd-Newberry @brianln
 */
@Controller
@EnableAutoConfiguration
public class PixelListener {

    private Logger log = LoggerFactory.getLogger("PixalLog");

    @Resource
    RedisTemplate redisTemplate;

    @RequestMapping("/")
    @ResponseBody
    String ping(HttpServletRequest request, HttpServletResponse response)
    {
        publishPixelEvent(request);

        log.info("Handled request for: {} by {}", request.getServerName(), request.getHeader("referer"));

        return "Hello " + request.getRemoteAddr();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PixelListener.class, args);
    }


    private void publishPixelEvent(HttpServletRequest request) {
        final String[] payload = new String[] {
                request.getServerName(),
                request.getContextPath(),
                request.getHeader("referer")
        };

        redisTemplate.convertAndSend("pixel",
                StringUtils.arrayToDelimitedString(payload, "\n"));
    }
}
