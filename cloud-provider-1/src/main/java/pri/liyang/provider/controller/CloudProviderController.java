package pri.liyang.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import pri.liyang.api.CloudInterface;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CloudProviderController implements CloudInterface {

    @Value("${server.port}")
    private Integer port;

    @Override
    public String init() {
        return "正在调用服务的端口：" + port;
    }

    @Override
    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String register(String name, int age) {
        return "收到注册信息，姓名：" + name + "，年龄：" + age;
    }

    @Override
    public String greeting(String name, int age) {
        return "Hello, dear " + name + ", you are " + age + " years old";
    }
}
