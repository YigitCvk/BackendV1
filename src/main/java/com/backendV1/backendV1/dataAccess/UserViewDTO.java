package com.backendV1.backendV1.dataAccess;

import java.io.Serializable;

import com.backendV1.backendV1.entity.User;

import lombok.Getter;

public final class UserViewDTO implements Serializable {

	@Getter
	private static final long serialVersionUID = 1L;

	private final String firstName;
	private final String lastName;

	private UserViewDTO(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static UserViewDTO of(User user) {
		return new UserViewDTO(user.getFirstName(), user.getLastName());
	}

}
