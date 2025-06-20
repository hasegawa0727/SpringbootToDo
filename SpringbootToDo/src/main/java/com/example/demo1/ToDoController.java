package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class ToDoController {
	private List<ToDo> list = new ArrayList<>();
	
	public ToDoController() {
		list.add(new ToDo("買い物に行く"));
		list.add(new ToDo("本を読む"));
	}
	
	@GetMapping
	public List<ToDo> getToDos() {
		return list;
	}
	
	@GetMapping("/{id}")
	public ToDo getToDo(@PathVariable int id) {
		int index = id -1;
		
		if(index < 0 || index >= list.size()) {
			throw new RuntimeException("指定されたIDのToDoは存在しません" + id);
		}
		return list.get(index);
	}
	
	@PostMapping
	public ToDo postToDo(@RequestBody ToDo newtodo) {
		list.add(newtodo);
		return newtodo;
	}
	

}
