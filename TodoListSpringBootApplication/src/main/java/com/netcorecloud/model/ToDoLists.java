package com.netcorecloud.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ToDoLists {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer todoId;
	
	private String image;
	
	private String taskName;
	
	private String todo;
	
	private boolean status;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	public ToDoLists() {
		// TODO Auto-generated constructor stub
	}
	public Integer getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ToDoLists(Integer todoId, String image, String taskName, String todo, boolean status, LocalDate createdDate,
			LocalDate updatedDate, User user) {
		super();
		this.todoId = todoId;
		this.image = image;
		this.taskName = taskName;
		this.todo = todo;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.user = user;
	}
	@Override
	public String toString() {
		return "TodoList [todoId=" + todoId + ", image=" + image + ", taskName=" + taskName + ", todo=" + todo
				+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", user="
				+ user + "]";
	}
	
	
	
}
