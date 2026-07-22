package com.incidentops.incidentops.user.dto.request;

import com.incidentops.incidentops.user.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

	@NotBlank
	@Size(max = 100)
	private String firstName;

	@NotBlank
	@Size(max = 100)
	private String lastName;

	@NotBlank
	@Email
	@Size(max = 255)
	private String email;

	@NotBlank
	@Size(min = 8, max = 255)
	private String password;

	@NotNull
	private UserRole role;
}
