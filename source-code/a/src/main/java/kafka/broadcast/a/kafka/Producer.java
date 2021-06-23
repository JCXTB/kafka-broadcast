/**
 * Project Name: a
 * File Name: Producer
 * Package Name: kafka.broadcast.a.kafka
 * Date: 2021/6/18 10:16
 * Author: 方瑞冬
 */
package kafka.broadcast.a.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author 方瑞冬
 */
@Slf4j
@Component
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kakfa.topic.producer.a}")
    private String topic;

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: Producer.java </p>
     * <p>方法描述: 发送消息 </p>
     * <p>创建时间: 2021/6/23 13:44 </p>
     *
     * @param o 消息内容
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    public void send(Object o) {
        String s = JSONObject.toJSONString(o);
        log.info("准备发送消息, 消息内容: {}", s);
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(this.topic, s);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(@NotNull Throwable throwable) {
                log.error("topic {} 生产者发送消息失败 {}", topic, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("topic {} 生产者发送消息成功 {}", topic, stringStringSendResult);
            }
        });
    }
}
