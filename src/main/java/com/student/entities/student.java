package com.student.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstName",length = 45,nullable = false)
	private String firstName;
	
	@Column(name = "lastName",length = 45,nullable = false)
	private String lastName;
	
	@Column(name = "email",length = 128,unique = true)
	private String email;
	
	@Column(name = "city",length = 10)
	private String city;
	
}
