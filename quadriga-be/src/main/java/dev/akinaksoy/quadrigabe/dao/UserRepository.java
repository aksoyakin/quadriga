package dev.akinaksoy.quadrigabe.dao;

import dev.akinaksoy.quadrigabe.entities.concretes.User;
import dev.akinaksoy.quadrigabe.entities.concretes.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByEmail(String email);
    User findByUserRole(UserRole role);
}
