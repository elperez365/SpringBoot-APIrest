package com.example.rubrica.rubrica.controller;

import com.example.rubrica.rubrica.entity.ToDoList;
import com.example.rubrica.rubrica.service.ToDoListService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/todolist")

public class ToDoListController {

	@Autowired
	ToDoListService toDoListService;

	@GetMapping("/todolist")
	List<ToDoList> getToDoList() {
		return toDoListService.getAll();
	}

	@GetMapping("/todolist/{id}")
	ToDoList getTask(@PathVariable Long id){
		return toDoListService.getTask(id);
	}

	@PostMapping("/todolist")
	ToDoList addTask(@RequestBody ToDoList task){
		return toDoListService.addTask(task);
	}

	@PutMapping("/todolist/{id}")
	ToDoList editTask(@PathVariable Long id, @RequestBody ToDoList task){
		return toDoListService.editTask(task);
	}

	@DeleteMapping("/todolist/{id}")
	void deleteTask(@PathVariable Long id){
		ToDoList opt = toDoListService.getTask(id);
		if (opt != null)
			toDoListService.deleteTask(id);
	}

	@GetMapping("/search")
	List<ToDoList> search(
			@RequestParam(required = false) String nameToDo,
			@RequestParam(required = false) String creationDate,
			@RequestParam(required = false) String expiredDate
	) {
		return toDoListService.genericSearch(nameToDo, creationDate, expiredDate);
	}

	@GetMapping("/search2")
	List<ToDoList> search2(@RequestBody ToDoList toDoList) {
		return toDoListService.search(toDoList.getNameToDo(), toDoList.getCreationDate(), toDoList.getExpiredDate());
	}

	@GetMapping("/search3")
	List<ToDoList> search3(@RequestBody Map<String, String> body) {
		String nameToDo = body.get("nameToDo");
		String creationDate = body.get("creationDate");
		String expiredDate = body.get("expiredDate");
		return toDoListService.genericSearch(nameToDo, creationDate, expiredDate);
	}

}
