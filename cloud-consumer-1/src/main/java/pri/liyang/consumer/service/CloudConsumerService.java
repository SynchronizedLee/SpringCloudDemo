package pri.liyang.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import pri.liyang.api.CloudInterface;

@FeignClient(name = "cloud-provider-liyang")
public interface CloudConsumerService extends CloudInterface {

}
