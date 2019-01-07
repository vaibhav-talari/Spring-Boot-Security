package spring.core.boot.service;


import java.util.Optional;

import spring.core.boot.model.Users;

public interface UserService {

	void save(Users user);
	Optional<Users> findByName(String name);
}
