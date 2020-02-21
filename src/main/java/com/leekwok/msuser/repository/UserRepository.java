package com.leekwok.msuser.repository;

import com.leekwok.msuser.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/15 13:55<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
