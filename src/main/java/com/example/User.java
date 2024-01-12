package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	 public String name;
	 public String email;
	 public int experience;
	 public String domain;
}

