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
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer todoId;
	private String taskName;
	private String todoDesc;
	private boolean status;
	private String image;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	public Integer getTodoId() {
		return todoId;
	}
	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	public String getTodoDesc() {
		return todoDesc;
	}
	public void setTodoDesc(String todoDesc) {
		this.todoDesc = todoDesc;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	public Todo(Integer todoId, String image, String taskName, String todo, boolean status, LocalDate createdDate,
			LocalDate updatedDate, User user) {
		super();
		this.todoId = todoId;
		this.image = image;
		this.taskName = taskName;
		this.todoDesc = todo;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", image=" + image + ", taskName=" + taskName + ", todo=" + todoDesc + ", status="
				+ status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", user=" + user + "]";
	}
	
	
}
