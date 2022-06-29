package io.company.service;


import io.company.entity.ToDo;
import io.company.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {
    @Autowired
   private ToDoListRepository TodoListRepository;
    //inyectamos el repositorio al SERVICE PARA USAR LAS ESPECIFICACIONES DEL JPA

    /*public ToDoListService(ToDoListRepository todoListRepository) {
        this.TodoListRepository = todoListRepository;
    }*/

  //add to-do
  /* public int save(ToDo toDo){
    int res=0;
      // this.TodoListRepository.save(toDo);
       ToDo todo = TodoListRepository.save(toDo);
       if(!todo.equals(null)){
           res=1;
       }
       return res;
   }*/
    public void save(ToDo toDo){
        this.TodoListRepository.save(toDo);
    }

    //show all to-do
   public List<ToDo> getAll(){
      return this.TodoListRepository.findAll();
   }

   //show ToDo with id
   public Optional<ToDo> listarId(int id){
        return this.TodoListRepository.findById(id);

   }

   public void deleteTodoById(int id){
       this.TodoListRepository.deleteById(id);
   }

}
