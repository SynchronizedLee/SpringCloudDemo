package pri.liyang.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "cloud")
public interface CloudInterface {

    @GetMapping("/init")
    String init();

    @GetMapping("/time")
    String getTime();

    @GetMapping("/register")
    String register(@RequestParam("name")String name, @RequestParam("age")int age);

    @GetMapping("/greet")
    String greeting(@RequestParam("name")String name, @RequestParam("age")int age);

}
