package spring.core.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.core.boot.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
