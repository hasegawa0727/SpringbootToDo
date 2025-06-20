package com.example.demo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final SpringbootToDoApplication springbootToDoApplication;
	private List<ToDo> list = new ArrayList<>();
	
	public ToDoController(SpringbootToDoApplication springbootToDoApplication) {
		list.add(new ToDo("買い物に行く", "夕飯用の食材を買いに行く"));
		list.add(new ToDo("本を読む", "溜まっている本を消化する"));
		this.springbootToDoApplication = springbootToDoApplication;
	}
	
	@GetMapping
	public List<ToDo> getTodos() {
		return list;
	}
	
	@GetMapping("/{id}")
	public ToDo getTodo(@PathVariable long id) {
		int index = (int)(id -1);
		
		if(index < 0 || index >= list.size()) {
			throw new WrongIdException(id);
		}
		return list.get(index);
	}
	
	@GetMapping("/search")
	public List<ToDo> searchTodo(@RequestParam String body) {
		return list.stream()
				.filter(todo -> todo.getTitle().contains(body) || 
						todo.getStatus().contains(body) ||
						todo.getDescription().contains(body))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/sort")
	public List<ToDo> sortTodo() {
		return list.stream()
				.sorted(Comparator.comparing((ToDo todo) -> "完了".equals(todo.getStatus()) ? 1: 0)
				.thenComparing((ToDo todo) -> todo.getId()))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public ToDo postTodo(@RequestBody ToDo newtodo) {
		newtodo.setCreatedAt(LocalDateTime.now());
		newtodo.setUpdatedAt(LocalDateTime.now());
		list.add(newtodo);
		return newtodo;
	}
	
	@DeleteMapping("/{id}")
	public String deleteTodo(@PathVariable long id) {
		int index = (int)(id - 1);
		
		if(index < 0 || index > list.size()) {
			throw new WrongIdException(id);
		}
		list.remove(index);
		return "ID" + id + "のToDOを削除しました";
	}
	
	@PatchMapping("/{id}")
	public ToDo patchTodo(@PathVariable long id, @RequestBody ToDo patchTodo) {
		int index = (int)(id - 1);
		
		if(index < 0 || index > list.size()) {
			throw new WrongIdException(id);
		}
		
		ToDo existing = list.get(index);
		
		if(patchTodo.getTitle() != null) {
			existing.setTitle(patchTodo.getTitle() );
		}
		if(patchTodo.getDescription() != null) {
			existing.setDescription(patchTodo.getDescription() );
		}
		if(patchTodo.getStatus() != null) {
			existing.setStatus(patchTodo.getStatus() );
		}
		
		existing.setUpdatedAt(LocalDateTime.now());
		return existing;
	}

}
