package com.muti.embedded.redis.test.controller;

import com.muti.embedded.redis.test.domain.User;
import com.muti.embedded.redis.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {

        try {

            LOG.info("Received GET User request - id: {}", id);

            User user = service.getUser(UUID.fromString(id));

            LOG.error("Completed GET User request - id: {} - User: {}", id, user);

            return new ResponseEntity<User>(user, user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {

            LOG.error("Error during serving GET User request - id: {} - {}", id, e.getMessage());

            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> createUser(@PathVariable String id, @RequestBody User user) {

        try {

            LOG.info("Received POST User request - id: {} - user: {}", id, user);

            User createdUser = service.createUser(UUID.fromString(id), user);

            LOG.info("Completed POST User request - id: {} - user: {}", id, createdUser);

            return new ResponseEntity<User>(createdUser, createdUser!=null?HttpStatus.CREATED:HttpStatus.CONFLICT);
        }
        catch (Exception e) {

            LOG.error("Error during serving POST User request - id: {} - {}", id, e.getMessage());

            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {

        try {

            LOG.info("Received PUT User request - id: {} - user: {}", id, user);

            User updatedUser = service.updateUser(UUID.fromString(id), user);

            LOG.info("Completed PUT User request - id: {} - user: {}", id, updatedUser);

            return new ResponseEntity<User>(updatedUser, updatedUser!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {

            LOG.error("Error during serving PUT User request - id: {} - {}", id, e.getMessage());

            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {

        try {

            LOG.info("Received DELETE User request - id: {}", id);

            User deletedUser = service.deleteUser(UUID.fromString(id));

            LOG.info("Completed DELETE User request - id: {} - user: {}", id, deletedUser);

            return new ResponseEntity<User>(deletedUser, deletedUser!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {

            LOG.error("Error during serving DELETE User request - id: {} - {}", id, e.getMessage());

            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}