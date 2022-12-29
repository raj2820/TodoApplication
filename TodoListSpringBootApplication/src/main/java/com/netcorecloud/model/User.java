package com.netcorecloud.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	
	private String name;
	
	private String email;
	
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<ToDoLists> todoLists;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public List<ToDoLists> getTodoLists() {
		return todoLists;
	}


	public void setTodoLists(List<ToDoLists> todoLists) {
		this.todoLists = todoLists;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User(Integer userId, String name, String email, String password, List<ToDoLists> todoLists) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.todoLists = todoLists;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", todoLists=" + todoLists + "]";
	}
	
	
	
}
