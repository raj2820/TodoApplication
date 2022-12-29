package com.netcorecloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcorecloud.model.Todo;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer>{

}
