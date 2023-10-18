package xyz.jzab.abapiBackend;

import xyz.jzab.abapiBackend.config.WxOpenConfig;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * 主类测试
 *
 * @author JZAB
 * @from http://www.jzab.xyz/
 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private WxOpenConfig wxOpenConfig;
    @Test
    void contextLoads() {
        System.out.println(wxOpenConfig);
    }

    @Test
    String tests() {
        String s = " 123 456 ";
        new StringBuffer().toString();
        s = s.trim();
        List<String> split = Arrays.asList(s.split("\\s+"));
        Collections.reverse(split);
        return String.join(" ", split);
    }
}