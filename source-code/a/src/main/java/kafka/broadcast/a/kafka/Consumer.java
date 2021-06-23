/**
 * Project Name: a
 * File Name: Consumer
 * Package Name: kafka.broadcast.a.kafka
 * Date: 2021/6/18 16:43
 * Author: 方瑞冬
 */
package kafka.broadcast.a.kafka;

import com.alibaba.fastjson.JSONObject;
import kafka.broadcast.a.dao.ADAO;
import kafka.broadcast.a.entity.A;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 方瑞冬
 */
@Slf4j
@Component
public class Consumer {
    @Autowired
    private ADAO aDAO;

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: Consumer.java </p>
     * <p>方法描述: A 监听 B 信息变更 topic </p>
     * <p>创建时间: 2021/6/23 13:30 </p>
     *
     * @param consumerRecord 消息内容
     * @param acknowledgment 确认信号
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @KafkaListener(topics = "#{'${kakfa.topic.consumer.b}'}", groupId = "#{'${kakfa.group}'}")
    private void bEdit(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        JSONObject jsonObject = JSONObject.parseObject(consumerRecord.value());

        List<A> aList = aDAO.findAllByBid(jsonObject.get("id").toString());
        aList.forEach(a -> a.setBName(jsonObject.get("name").toString()));
        aDAO.saveAll(aList);

        log.info("A 消费了 B 生产者发送的消息, 消息内容: {}", jsonObject);
        acknowledgment.acknowledge();
    }

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: Consumer.java </p>
     * <p>方法描述: A 监听 C 信息变更 topic </p>
     * <p>创建时间: 2021/6/23 13:38 </p>
     *
     * @param consumerRecord 消息内容
     * @param acknowledgment 确认信号
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @KafkaListener(topics = "#{'${kakfa.topic.consumer.c}'}", groupId = "#{'${kakfa.group}'}")
    private void cEdit(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        JSONObject jsonObject = JSONObject.parseObject(consumerRecord.value());

        List<A> aList = aDAO.findAllByCid(jsonObject.get("id").toString());
        aList.forEach(a -> a.setCName(jsonObject.get("name").toString()));
        aDAO.saveAll(aList);

        log.info("A 消费了 C 生产者发送的消息, 消息内容: {}", jsonObject);
        acknowledgment.acknowledge();
    }
}
