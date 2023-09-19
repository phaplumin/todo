package com.jhost.template.Template.controller;

import com.jhost.template.Template.model.Task;
import com.jhost.template.Template.model.User;
import com.jhost.template.Template.service.TasksService;
import com.jhost.template.Template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> GetTasksByUserId(@PathVariable long id)
    {
        try {
            var user = userService.GetTasksByUserId(id);

            return ResponseEntity.ok(user);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Long> CreateTask(@RequestBody User user)
    {
        try {
            var taskId = userService.CreateUser(user);

            return ResponseEntity.ok(taskId);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public ResponseEntity<Long> UpdateTaskByUserId(@RequestBody User user)
    {
        try {
            var userId = userService.UpdateUser(user);

            return ResponseEntity.ok(userId);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

}
