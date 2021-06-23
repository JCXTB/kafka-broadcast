/**
 * Project Name: a
 * File Name: ADAO
 * Package Name: kafka.broadcast.a.dao
 * Date: 2021/6/17 17:08
 * Author: 方瑞冬
 */
package kafka.broadcast.a.dao;

import kafka.broadcast.a.entity.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 方瑞冬
 */
@Repository
public interface ADAO extends JpaRepository<A, String>, JpaSpecificationExecutor<A> {
    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: ADAO.java </p>
     * <p>方法描述: 通过 B 的 ID 查询 A 集合 </p>
     * <p>创建时间: 2021/6/23 13:28 </p>
     *
     * @param bid B 的 ID
     * @return java.util.List<kafka.broadcast.a.entity.A>
     * @author 方瑞冬
     * @version 1.0
     */
    List<A> findAllByBid(String bid);

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: ADAO.java </p>
     * <p>方法描述: 通过 C 的 ID 查询 A 集合 </p>
     * <p>创建时间: 2021/6/23 13:29 </p>
     *
     * @param cid C 的 ID
     * @return java.util.List<kafka.broadcast.a.entity.A>
     * @author 方瑞冬
     * @version 1.0
     */
    List<A> findAllByCid(String cid);
}
