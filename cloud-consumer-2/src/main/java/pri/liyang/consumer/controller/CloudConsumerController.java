package pri.liyang.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.liyang.consumer.service.CloudConsumerService;

@RestController
@RequestMapping("/consume")
public class CloudConsumerController {

    @Autowired
    @Qualifier("cloudConsumerService")
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

    @GetMapping("/halfError")
    String halfError() {
        return cloudConsumerService.halfError();
    }

    @GetMapping("/quarterError")
    String quarterError() {
        return cloudConsumerService.quarterError();
    }

    @GetMapping("/customError")
    String customError(Double errorProbability) {
        return cloudConsumerService.customError(errorProbability);
    }

}
