/**
 * Project Name: a
 * File Name: Consumer
 * Package Name: kafka.broadcast.a.kafka
 * Date: 2021/6/18 16:43
 * Author: 方瑞冬
 */
package kafka.broadcast.c.kafka;

import com.alibaba.fastjson.JSONObject;
import kafka.broadcast.c.dao.CDAO;
import kafka.broadcast.c.entity.C;
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
    private CDAO cDAO;

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: Consumer.java </p>
     * <p>方法描述: C 监听 A 信息变更 topic </p>
     * <p>创建时间: 2021/6/23 14:33 </p>
     *
     * @param consumerRecord 消息内容
     * @param acknowledgment 确认信号
     * @return voidl
     * @author 方瑞冬
     * @version 1.0
     */
    @KafkaListener(topics = "#{'${kakfa.topic.consumer.a}'}", groupId = "#{'${kakfa.group}'}")
    private void aEdit(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        JSONObject jsonObject = JSONObject.parseObject(consumerRecord.value());

        List<C> cList = cDAO.findAllByAid(jsonObject.get("id").toString());
        cList.forEach(c -> c.setAName(jsonObject.get("name").toString()));
        cDAO.saveAll(cList);

        log.info("C 消费了 A 生产者发送的消息, 消息内容: {}", jsonObject);
        acknowledgment.acknowledge();
    }

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: Consumer.java </p>
     * <p>方法描述: C 监听 B 信息变更 topic </p>
     * <p>创建时间: 2021/6/23 14:35 </p>
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

        List<C> cList = cDAO.findAllByBid(jsonObject.get("id").toString());
        cList.forEach(c -> c.setBName(jsonObject.get("name").toString()));
        cDAO.saveAll(cList);

        log.info("C 消费了 B 生产者发送的消息, 消息内容: {}", jsonObject);
        acknowledgment.acknowledge();
    }
}
