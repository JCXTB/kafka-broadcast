package kafka.broadcast.b;

import kafka.broadcast.b.dao.BDAO;
import kafka.broadcast.b.entity.B;
import kafka.broadcast.b.kafka.Producer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class KafkaTests {
    @Autowired
    private Producer producer;

    @Autowired
    private BDAO bDAO;

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: KafkaTests.java </p>
     * <p>方法描述: 初始化一条 B 对象数据 </p>
     * <p>创建时间: 2021/6/23 13:54 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @Test
    void initialize() {
        B b = new B();
        b.setId("1");
        b.setName("b最初名字");
        b.setAid("1");
        b.setAName("a最初名字");
        b.setCid("1");
        b.setCName("c最初名字");

        bDAO.save(b);
    }

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: KafkaTests.java </p>
     * <p>方法描述: 模拟 B 更新操作 </p>
     * <p>创建时间: 2021/6/23 13:54 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @Test
    void edit() {
        Optional<B> bOptional = bDAO.findById("1");
        if (!bOptional.isPresent()) {
            log.warn("未查询到数据");
            return;
        }
        B b = bOptional.get();
        b.setName("b修改名字");
        bDAO.save(b);
        producer.send(b);
    }
}
