/**
 * Project Name: a
 * File Name: BDAO
 * Package Name: kafka.broadcast.a.dao
 * Date: 2021/6/17 17:08
 * Author: 方瑞冬
 */
package kafka.broadcast.b.dao;

import kafka.broadcast.b.entity.B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 方瑞冬
 */
public interface BDAO extends JpaRepository<B, String>, JpaSpecificationExecutor<B> {
    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: BDAO.java </p>
     * <p>方法描述: 通过 A 的 ID 查询 B 集合 </p>
     * <p>创建时间: 2021/6/23 13:45 </p>
     *
     * @param aid A 的 ID
     * @return java.util.List<kafka.broadcast.b.entity.B>
     * @author 方瑞冬
     * @version 1.0
     */
    List<B> findAllByAid(String aid);

    /**
     * <p>项目名称: kafka-broadcast </p>
     * <p>文件名称: BDAO.java </p>
     * <p>方法描述: 通过 C 的 ID 查询 B 集合 </p>
     * <p>创建时间: 2021/6/23 13:46 </p>
     *
     * @param cid C 的 ID
     * @return java.util.List<kafka.broadcast.b.entity.B>
     * @author 方瑞冬
     * @version 1.0
     */
    List<B> findAllByCid(String cid);
}
