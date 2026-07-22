package com.incidentops.incidentops.user.mapper;

import com.incidentops.incidentops.user.dto.request.CreateUserRequest;
import com.incidentops.incidentops.user.dto.request.UpdateUserRequest;
import com.incidentops.incidentops.user.dto.response.UserResponse;
import com.incidentops.incidentops.user.entity.User;
import com.incidentops.incidentops.user.enums.UserStatus;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public User toEntity(CreateUserRequest request) {
		return User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.password(request.getPassword())
				.role(request.getRole())
				.status(UserStatus.ACTIVE)
				.build();
	}

	public void updateEntity(User user, UpdateUserRequest request) {
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setRole(request.getRole());
	}

	public UserResponse toResponse(User user) {
		return UserResponse.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.role(user.getRole())
				.status(user.getStatus())
				.createdAt(user.getCreatedAt())
				.updatedAt(user.getUpdatedAt())
				.build();
	}
}
