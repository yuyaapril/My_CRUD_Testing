package a.a.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import a.a.todo.models.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long>{

  
}


  

