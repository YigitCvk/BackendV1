package com.backendV1.backendV1.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backendV1.backendV1.business.abstracts.UserService;
import com.backendV1.backendV1.core.UserRepository;
import com.backendV1.backendV1.dataAccess.UserCreateDTO;
import com.backendV1.backendV1.dataAccess.UserUpdateDTO;
import com.backendV1.backendV1.dataAccess.UserViewDTO;
import com.backendV1.backendV1.entity.User;
import com.backendV1.backendV1.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

/**
 * @author Yigit Cevik
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

	private final UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)//
	public UserViewDTO getUserId(Long id) {
		final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return UserViewDTO.of(user);
	}

	@Override
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)//
	public List<UserViewDTO> getUsers() {

		return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
		final User user = userRepository.save(new User(userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
		return UserViewDTO.of(user);
	}

	@Override
	@Transactional
	public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
		final User user=userRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
		user.setFirstName(userUpdateDTO.getFirstName());
		user.setLastName(userUpdateDTO.getLastName());
		
		final User updatedUser=userRepository.save(user);
		return UserViewDTO.of(updatedUser);
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		final User user=userRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
		userRepository.deleteById(user.getId());

	}
	


	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserViewDTO> slice(Pageable pageable) {
		return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
	}

	
}
