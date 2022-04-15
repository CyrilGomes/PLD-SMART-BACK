package insa.smart.smart_back;

import insa.smart.smart_back.models.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SmartBackApplication {

    @RequestMapping("/login")
    @ResponseBody
    Login home() {
        return new Login("lala","lolo");
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
