package com.maresmewebdevelopers.todolist.repository;

import com.maresmewebdevelopers.todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    ToDo findByName(String name);
}
