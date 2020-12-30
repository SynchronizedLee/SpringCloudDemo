package pri.liyang.api;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/halfError")
    String halfError();

    @PutMapping("/quarterError")
    String quarterError();

    @DeleteMapping("/customError")
    String customError(@RequestParam("errorProbability") Double errorProbability);

}
