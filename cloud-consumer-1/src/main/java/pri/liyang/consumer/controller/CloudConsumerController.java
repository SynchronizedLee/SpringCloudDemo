package pri.liyang.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.liyang.consumer.service.CloudConsumerService;

@RestController
@RequestMapping("/consume")
public class CloudConsumerController {

    @Autowired
    CloudConsumerService cloudConsumerService;

    @GetMapping("/init")
    public String init() {
        return cloudConsumerService.init();
    }

    @GetMapping("/time")
    public String getTime() {
        return cloudConsumerService.getTime();
    }

    @GetMapping("/register")
    public String register(String name, int age) {
        return cloudConsumerService.register(name, age);
    }

    @GetMapping("/greet")
    public String greeting(String name, int age) {
        return cloudConsumerService.greeting(name, age);
    }

}
