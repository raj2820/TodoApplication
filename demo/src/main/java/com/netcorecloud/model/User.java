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
	private List<Todo> todoList;
	
	
	public User() {
		// TODO Auto-generated constructor stub
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


	public User(Integer userId, String name, String email, String password, List<Todo> todoList) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.todoList = todoList;
	}


	public List<Todo> getTodoList() {
		return todoList;
	}





	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", todoLists=" + todoList + "]";
	}
	
	
}
