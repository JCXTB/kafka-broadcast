package kafka.broadcast.a;

import kafka.broadcast.a.dao.ADAO;
import kafka.broadcast.a.entity.A;
import kafka.broadcast.a.kafka.Producer;
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
    private ADAO aDAO;

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: KafkaTests.java </p>
     * <p>方法描述: 初始化一条 A 对象数据 </p>
     * <p>创建时间: 2021/6/23 13:39 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @Test
    void initialize() {
        A a = new A();
        a.setId("1");
        a.setName("a最初名字");
        a.setBid("1");
        a.setBName("b最初名字");
        a.setCid("1");
        a.setCName("c最初名字");

        aDAO.save(a);
    }

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: KafkaTests.java </p>
     * <p>方法描述: 模拟 A 更新操作 </p>
     * <p>创建时间: 2021/6/23 13:39 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @Test
    void edit() {
        Optional<A> aOptional = aDAO.findById("1");
        if (!aOptional.isPresent()) {
            log.warn("未查询到数据");
            return;
        }
        A a = aOptional.get();
        a.setName("a修改名字");
        aDAO.save(a);
        producer.send(a);
    }
}
