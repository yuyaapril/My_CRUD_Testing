package a.a.todo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import a.a.todo.models.Todo;
import a.a.todo.repositories.TodoRepo;

@Service

//constructor injection
public class TodoService {
  private final TodoRepo todoRepo;

  public TodoService(TodoRepo todoRepo) {
    this.todoRepo = todoRepo;
  }

  public List<Todo> all() {
    List<Todo> todos = todoRepo.findAll();
    return todos;
  }

  public void add(String title) {
    Todo todo = new Todo();
    todo.setTitle(title);
    todo.setCompleted(false);
    todoRepo.save(todo);
  }

  public Todo get(Long id) {
    Todo todo = todoRepo.findById(id).orElse(null);
    return todo;
  }

  public void modify(Long id, String title) {
    Todo todo = todoRepo.findById(id).orElse(null);
    if (todo != null) {
      todo.setTitle(title);
      todoRepo.save(todo); //already > update , new > new save
    }
  }

  public void toggle(Long id) {
    Todo todo = todoRepo.findById(id).orElse(null);
    if (todo != null) {
      todo.setCompleted(!todo.isCompleted());
      todoRepo.save(todo);
    }
  }
  
  public void drop(Long id) {
    todoRepo.deleteById(id);
  }

}

