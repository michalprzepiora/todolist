package pl.com.przepiora.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.przepiora.todolist.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
