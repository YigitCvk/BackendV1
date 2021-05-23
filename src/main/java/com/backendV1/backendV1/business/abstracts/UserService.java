package com.backendV1.backendV1.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.backendV1.backendV1.dataAccess.UserCreateDTO;
import com.backendV1.backendV1.dataAccess.UserUpdateDTO;
import com.backendV1.backendV1.dataAccess.UserViewDTO;

public interface UserService {

	UserViewDTO getUserId(Long id);

	List<UserViewDTO> getUsers();

	UserViewDTO createUser(UserCreateDTO userCreateDTO);

	UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

	void deleteUser(Long id);

	List<UserViewDTO> slice(Pageable pageable);


}
