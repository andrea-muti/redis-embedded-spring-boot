package com.muti.embedded.redis.test.repository;

/**
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
import com.muti.embedded.redis.test.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Andrea Muti <muti.andrea@gmail.com>
 * @since 28/07/2019
 */
public interface UserRepository extends CrudRepository<User, UUID> {

}