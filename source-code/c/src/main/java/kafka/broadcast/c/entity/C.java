/**
 * Project Name: a
 * File Name: C
 * Package Name: kafka.broadcast.a.entity
 * Date: 2021/6/17 17:04
 * Author: 方瑞冬
 */
package kafka.broadcast.c.entity;

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
@Table(name = "c")
public class C implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String aid;

    private String aName;

    private String bid;

    private String bName;
}
