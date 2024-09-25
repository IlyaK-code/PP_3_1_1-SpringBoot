package SpringBoot3_1_1.web.dao;

import SpringBoot3_1_1.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public User getByIdUser(Long id);

    public void save(User user);

    public void update(Long id, User updateUser);

    public void delete(Long id);
}
