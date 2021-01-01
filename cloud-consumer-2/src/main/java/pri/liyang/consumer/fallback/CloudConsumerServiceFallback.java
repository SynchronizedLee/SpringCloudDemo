package pri.liyang.consumer.fallback;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import pri.liyang.consumer.service.CloudConsumerService;

@Component
@Qualifier("cloudConsumerServiceFallback")
@RequestMapping("/hystrix")
public class CloudConsumerServiceFallback implements CloudConsumerService {

    @Override
    public String init() {
        return "init()方法调用出错，这是服务降级的处理方法";
    }

    @Override
    public String getTime() {
        return "getTime()方法调用出错，这是服务降级的处理方法";
    }

    @Override
    public String register(String name, int age) {
        String params = "name = " + name + ", age = " + age;
        return "getTime()方法调用出错，参数：" + params + "，这是服务降级的处理方法";
    }

    @Override
    public String greeting(String name, int age) {
        String params = "name = " + name + ", age = " + age;
        return "greeting()方法调用出错，参数：" + params + "，这是服务降级的处理方法";
    }

    @Override
    public String halfError() {
        return "你碰到那一半的出错概率了，这是服务降级的处理方法";
    }

    @Override
    public String quarterError() {
        return "你碰到那四分之一的出错概率了，这是服务降级的处理方法";
    }

    @Override
    public String customError(Double errorProbability) {
        return "你碰到那" + (errorProbability * 100) + "%的出错概率了，这是服务降级的处理方法";
    }

}
