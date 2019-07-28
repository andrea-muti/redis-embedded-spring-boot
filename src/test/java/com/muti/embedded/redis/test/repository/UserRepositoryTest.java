package com.muti.embedded.redis.test.repository;

import com.muti.embedded.redis.test.TestRedisConfiguration;
import com.muti.embedded.redis.test.domain.User;
import com.muti.embedded.redis.test.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class UserRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUser_toRedis() {

        LOG.info("testing UserRepository save...");

        final UUID id = UUID.randomUUID();
        final User user = new User(id, "name");

        final User saved = userRepository.save(user);

        assertNotNull("The Saved user should not be null", saved);
        assertEquals("The ID does not match", id, saved.getId());
        assertEquals("The name does not match", user.getName(), saved.getName());

        LOG.info("The saved user is: {}", saved);
    }
}
