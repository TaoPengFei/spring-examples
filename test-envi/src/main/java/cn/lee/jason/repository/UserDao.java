package cn.lee.jason.repository;

import cn.lee.jason.entity.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jason on 17-3-8.
 */
public interface UserDao extends CrudRepository<User, Long> {
}
