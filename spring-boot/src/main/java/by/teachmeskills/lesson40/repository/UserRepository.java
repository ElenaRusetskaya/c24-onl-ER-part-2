package by.teachmeskills.lesson40.repository;

import by.teachmeskills.lesson40.entity.UserJwt;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJwt, Long> {
    @Query("select user from User user")
    List<UserJwt> findContent(Pageable page);
    @EntityGraph(value = "User.role")
    Optional<UserJwt> findByLogin(String login);
}
