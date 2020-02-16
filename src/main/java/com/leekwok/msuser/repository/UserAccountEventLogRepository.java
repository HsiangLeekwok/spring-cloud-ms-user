package com.leekwok.msuser.repository;

import com.leekwok.msuser.entity.UserAccountEventLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/15 13:55<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Repository
public interface UserAccountEventLogRepository extends CrudRepository<UserAccountEventLog,Integer> {
}
