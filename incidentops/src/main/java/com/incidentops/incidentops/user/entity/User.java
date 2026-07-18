package com.incidentops.incidentops.user.entity;

import com.incidentops.incidentops.common.entity.BaseEntity;
import com.incidentops.incidentops.user.enums.UserRole;
import com.incidentops.incidentops.user.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, length = 100)
	private String firstName;

	@Column(nullable = false, length = 100)
	private String lastName;

	@Column(nullable = false, unique = true, length = 255)
	private String email;

	@Column(nullable = false, length = 255)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private UserRole role;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private UserStatus status;
}
