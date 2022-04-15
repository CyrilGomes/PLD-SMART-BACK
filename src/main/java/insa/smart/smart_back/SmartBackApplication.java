package insa.smart.smart_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SmartBackApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/env")
    public @ResponseBody
    Map<String, String> env() {
        return System.getenv();
    }
    public static void main(String[] args) {
        SpringApplication.run(SmartBackApplication.class, args);
    }

}
