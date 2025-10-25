package a.a.todo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a.a.todo.models.Todo;
import a.a.todo.services.TodoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/todo")
public class ApiController {

  private final TodoService todoService;

  public ApiController(TodoService todoService) {
    this.todoService = todoService;
  }
  
  @GetMapping()
  public List<Todo> all() {
    List<Todo> todos = todoService.all();
    return todos;
  }
  
  @PostMapping()
  public List<Todo> add(@RequestParam String title) {
    todoService.add(title);
    List<Todo> todos = todoService.all();
    return todos;
  }
  
  @PatchMapping("/{id}")
  public List<Todo> update(@PathVariable Long id, @RequestParam String title) {
    todoService.modify(id, title);
    List<Todo> todos = todoService.all();
    return todos;
  }
  
  @DeleteMapping("/{id}")
  public List<Todo> drop(@PathVariable Long id) {
    todoService.drop(id);
    List<Todo> todos = todoService.all();
    return todos;
  }
  @GetMapping("/toggle/{id}")
  public List<Todo> toggle(@PathVariable Long id) {
    todoService.toggle(id);
    List<Todo> todos = todoService.all();
    return todos;
  }

  @GetMapping("/filter/{completed}")
  public List<Todo> filter(@PathVariable boolean completed) {
    List<Todo> todos = todoService.filter(completed);
    return todos;
  }
  
  
}
