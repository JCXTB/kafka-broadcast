/**
 * Project Name: a
 * File Name: CDAO
 * Package Name: kafka.broadcast.a.dao
 * Date: 2021/6/17 17:08
 * Author: 方瑞冬
 */
package kafka.broadcast.c.dao;

import kafka.broadcast.c.entity.C;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 方瑞冬
 */
public interface CDAO extends JpaRepository<C, String>, JpaSpecificationExecutor<C> {
    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: CDAO.java </p>
     * <p>方法描述: 通过 A 的 ID 查询 C 集合 </p>
     * <p>创建时间: 2021/6/23 14:00 </p>
     *
     * @param aid A 的 ID
     * @return java.util.List<kafka.broadcast.c.entity.C>
     * @author 方瑞冬
     * @version 1.0
     */
    List<C> findAllByAid(String aid);

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: CDAO.java </p>
     * <p>方法描述: 通过 B 的 ID 查询 C 集合 </p>
     * <p>创建时间: 2021/6/23 14:01 </p>
     *
     * @param bid B 的 ID
     * @return java.util.List<kafka.broadcast.c.entity.C>
     * @author 方瑞冬
     * @version 1.0
     */
    List<C> findAllByBid(String bid);
}
