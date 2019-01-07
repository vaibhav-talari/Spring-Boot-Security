package spring.core.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.core.boot.model.CustomUserDetails;
import spring.core.boot.model.Users;
import spring.core.boot.repo.UserRepo;

@Service
public class UserDetailsSeriveImpl implements UserDetailsService {
	@Autowired
	private UserRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUser=userrepo.findByName(username);
		
		optionalUser
			.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUser
                .map(CustomUserDetails::new).get();
		}

}
