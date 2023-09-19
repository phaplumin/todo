package com.jhost.template.Template.repository;

import com.jhost.template.Template.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task,Long> {

    List<Task> findByUserid(long userid);
}
