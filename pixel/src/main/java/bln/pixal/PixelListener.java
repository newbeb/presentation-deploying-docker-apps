package bln.pixal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple Pixel listener
 * Created by ddcbrianln on 9/18/14.
 */
@Controller
@EnableAutoConfiguration
public class PixelListener {

    private Logger log = LoggerFactory.getLogger("PixalLog");

    @RequestMapping("/*")
    @ResponseBody
    String ping(HttpServletRequest request, HttpServletResponse response)
    {

        final String referer = request.getHeader("referer");

        log.info("Handled request for: {} by {}", request.getRequestURL(), request.getRemoteAddr() + " via " + referer);

        return "Hello " + request.getRemoteAddr() + " at " + System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PixelListener.class, args);
    }
}
