package com.muti.embedded.redis.test.service.impl;

import com.muti.embedded.redis.test.domain.User;
import com.muti.embedded.redis.test.repository.UserRepository;
import com.muti.embedded.redis.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    public UserServiceImpl() {
    }

    @Override
    public User getUser(UUID id) {

        LOG.info("Retrieving User id: {}", id);

        return repository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(UUID id, User user) {

        LOG.info("Updating User id: {} - User: {}", id, user);

        User existingUser = repository.findById(id).orElse(null);

        if (existingUser != null) {

            existingUser.setName(user.getName());
            existingUser = repository.save(existingUser);
        }

        return existingUser;
    }

    @Override
    public User createUser(UUID id, User user) {

        LOG.info("Creating User id: {} - User: {}", id, user);

        User existingUser = repository.findById(id).orElse(null);

        if (existingUser == null) {

            return repository.save(user);
        }
        else {
            return null;
        }
    }

    @Override
    public User deleteUser(UUID id) {

        LOG.info("Deleting User id: {} - User: {}", id);

        User user = repository.findById(id).orElse(null);

        if (user != null) { repository.deleteById(id); }

        return user;
    }
}