package com.example.demo.service.Imp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImp implements UserService {

	private final UserRepository userRepository;
	
	
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public User save(User user) {
		if(user.getEmail()==null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public User getById(Long id) { return userRepository.getOne(id); }

	@Override
	public Page<User> getAllPageable(Pageable pageable) { return userRepository.findAll(pageable); }

	@Override
	public User getByUsername(String username) { return userRepository.findByUsername(username ) ;
	}

}
