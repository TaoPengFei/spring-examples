package cn.lee.jason.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by jason on 17-3-8.
 */
@Entity
@Table(name = "sys_user")
public class User implements Serializable {

    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
