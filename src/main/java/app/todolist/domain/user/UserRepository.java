package app.todolist.domain.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserRepository extends JpaRepository<User, UUID>{
    UserDetails findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
