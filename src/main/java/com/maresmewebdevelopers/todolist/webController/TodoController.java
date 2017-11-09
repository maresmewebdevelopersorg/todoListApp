package com.maresmewebdevelopers.todolist.webController;

import com.maresmewebdevelopers.todolist.entity.ToDo;
import com.maresmewebdevelopers.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public String todo(Principal principal, Model model){
        model.addAttribute("toDo", new ToDo());
        model.addAttribute("toDoList", toDoService.getAll());

        return "todo";
    }

    @PostMapping
    public String addTodo(@Valid ToDo toDo, Errors errors, Model model) {
        model.addAttribute("toDoList", toDoService.getAll());

        if (errors.hasErrors())
            return "todo";

        this.toDoService.add(toDo);

        return "redirect:/todo";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam Long toDoId, Model model) {

        this.toDoService.deleteById(toDoId);

        return "redirect:/todo";
    }
}
