package pri.liyang.consumer.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import pri.liyang.api.CloudInterface;
import pri.liyang.consumer.fallback.CloudConsumerServiceFallback;

@FeignClient(name = "cloud-provider-liyang", fallback = CloudConsumerServiceFallback.class)
@Qualifier("cloudConsumerService")
public interface CloudConsumerService extends CloudInterface {

}
