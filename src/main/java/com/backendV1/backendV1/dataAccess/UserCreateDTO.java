package com.backendV1.backendV1.dataAccess;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.backendV1.backendV1.validator.UniqueUserName;

import lombok.Data;

@Data
public class UserCreateDTO {

	@NotNull(message = "{backendV1.constraints.username.NotNull.message}")
	@Size(min = 4, max = 24, message = "{backendV1.constraints.username.Size.message}")
	@UniqueUserName(message = "{backendV1.constraints.UniqueUserName.message}")
	private String userName;

	@NotNull(message = "{backendV1.constraints.firstname.NotNull.message}")
	@Size(min = 2, max = 32, message = "{backendV1.constraints.firstname.Size.message}")
	private String firstName;

	@NotNull(message = "{backendV1.constraints.lastname.NotNull.message}")
	@Size(min = 3, max = 32, message = "{backendV1.constraints.lastname.Size.message}")
	private String lastName;
}
