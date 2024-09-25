package SpringBoot3_1_1.web.repository;

import SpringBoot3_1_1.web.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
