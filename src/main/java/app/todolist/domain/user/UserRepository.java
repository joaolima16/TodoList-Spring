package app.todolist.domain.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserRepository extends JpaRepository<User, UUID>{
    UserDetails findByEmail(String email);
    List<User> findByName(String name);

    @Query("from user u where u.password = :password")
    List<UserDetails> findByPassword(@Param("password") String password);
}
