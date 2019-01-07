package spring.core.boot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.core.boot.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	
	Optional<Users> findByName(String name);

}
