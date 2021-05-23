package com.backendV1.backendV1.api;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendV1.backendV1.business.abstracts.UserService;
import com.backendV1.backendV1.dataAccess.UserCreateDTO;
import com.backendV1.backendV1.dataAccess.UserUpdateDTO;
import com.backendV1.backendV1.dataAccess.UserViewDTO;
import com.backendV1.backendV1.util.GenericResponse;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

	private final UserService userService;

	@GetMapping("v1/user/{id}")
	public ResponseEntity<UserViewDTO> getUserId(@PathVariable("id") Long id) {
		final UserViewDTO user = userService.getUserId(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("v2/user")
	public ResponseEntity<List<UserViewDTO>> getUsers() {
		final List<UserViewDTO> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}

	@PostMapping("v1/user")
	public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO) {

		userService.createUser(userCreateDTO);
		return ResponseEntity.ok(new GenericResponse("User Created"));
	}

	@PutMapping("v1/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
		final UserViewDTO user = userService.updateUser(id, userUpdateDTO);

		return ResponseEntity.ok(user);
	}
	@DeleteMapping("v1/user/{id}")
	public ResponseEntity<?>deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok(new GenericResponse("User Deleted!"));
	}
	// More performance
		@GetMapping("v1/user/slice")
		public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable) {
			final List<UserViewDTO> users = userService.slice(pageable);
			return ResponseEntity.ok(users);
		}
}