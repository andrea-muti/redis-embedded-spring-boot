package com.muti.embedded.redis.test.service;

import com.muti.embedded.redis.test.domain.User;
import com.muti.embedded.redis.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
public interface UserService {

    User getUser(UUID id);

    User updateUser(UUID id, User user);

    User createUser(UUID id, User user);

    User deleteUser(UUID id);
}