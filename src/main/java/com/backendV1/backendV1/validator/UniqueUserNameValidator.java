package com.backendV1.backendV1.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.backendV1.backendV1.core.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	private final UserRepository userRepository;

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		return !userRepository.existsUserByUsername(userName);
	}

}
