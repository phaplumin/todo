package com.jhost.template.Template.repository;

import com.jhost.template.Template.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user u join task t on t.userid = u.userid where u.userid = ?1", nativeQuery = true)
    User GetById(long id);
}
