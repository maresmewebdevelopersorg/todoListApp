package com.maresmewebdevelopers.todolist.service;

import com.maresmewebdevelopers.todolist.entity.ToDo;
import com.maresmewebdevelopers.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public void add(ToDo toDo){
        this.toDoRepository.save(toDo);
    }

    public List<ToDo> getAll(){
        return this.toDoRepository.findAll();
    }

    public void deleteById(Long toDoId){
        this.toDoRepository.delete(toDoId);
    }
}
