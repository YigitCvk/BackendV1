package com.backendV1.backendV1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "firt_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	public User(String username, String firstName, String lastName) {

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
