package by.teachmeskills.lesson40.repository;

import by.teachmeskills.lesson40.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
