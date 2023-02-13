package org.clone.videohosting.repositories;

import org.clone.videohosting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUserName(String userName);

    User findByUserName(String userName);

}
