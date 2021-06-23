package kafka.broadcast.c;

import kafka.broadcast.c.dao.CDAO;
import kafka.broadcast.c.entity.C;
import kafka.broadcast.c.kafka.Producer;
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
    private CDAO cDAO;

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: KafkaTests.java </p>
     * <p>方法描述: 初始化一条 C 对象数据 </p>
     * <p>创建时间: 2021/6/23 14:44 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @Test
    void initialize() {
        C c = new C();
        c.setId("1");
        c.setName("b最初名字");
        c.setAid("1");
        c.setAName("a最初名字");
        c.setBid("1");
        c.setBName("b最初名字");

        cDAO.save(c);
    }

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: KafkaTests.java </p>
     * <p>方法描述: 模拟 C 更新操作 </p>
     * <p>创建时间: 2021/6/23 14:45 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    @Test
    void edit() {
        Optional<C> cOptional = cDAO.findById("1");
        if (!cOptional.isPresent()) {
            log.warn("未查询到数据");
            return;
        }
        C c = cOptional.get();
        c.setName("c修改名字");
        cDAO.save(c);
        producer.send(c);
    }
}
