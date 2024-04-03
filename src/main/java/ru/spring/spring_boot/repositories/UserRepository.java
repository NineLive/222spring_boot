package ru.spring.spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.spring_boot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
