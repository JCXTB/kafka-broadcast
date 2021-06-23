/**
 * Project Name: a
 * File Name: A
 * Package Name: kafka.broadcast.a.entity
 * Date: 2021/6/17 17:04
 * Author: 方瑞冬
 */
package kafka.broadcast.a.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 方瑞冬
 */
@Data
@Entity
@Table(name = "a")
public class A implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String bid;

    private String bName;

    private String cid;

    private String cName;
}
