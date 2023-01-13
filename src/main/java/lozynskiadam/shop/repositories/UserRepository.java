package lozynskiadam.shop.repositories;

import lozynskiadam.shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findById(int id);

    User findUserByUsername(String username);

}
