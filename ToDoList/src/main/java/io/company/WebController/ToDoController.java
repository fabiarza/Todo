package io.company.WebController;

import javax.validation.Valid;
import io.company.entity.ToDo;
import io.company.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Optional;


@Controller
@RequestMapping
public class ToDoController {

    @Autowired
    private ToDoListService toDoListService;
    private int id;

    //@GetMapping("todolist")
   @GetMapping("/todolist")
  public String todolist(Principal principal,Model model){
        model.addAttribute("toDo" ,new ToDo());
        model.addAttribute("toDoList",toDoListService.getAll());
        return "todo";
    }


    @RequestMapping("/new")
    public String agregar(Model model){
        model.addAttribute("toDo" ,new ToDo());
                   return "form";

    }
    @RequestMapping("/save")
    public String save(@Valid ToDo todo,Model model){
        this.toDoListService.save(todo);
        return "redirect:/todolist";
    }
    @RequestMapping(value = "/deleteToDo/{id}")
    public String deleteToDo(@PathVariable int id  , Model model){

        this.toDoListService.deleteTodoById(id);
        return "redirect:/todolist";

    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modify(@PathVariable int id,Model model){
       Optional<ToDo> todo = toDoListService.listarId(id);
       model.addAttribute("toDo",todo);
       return "form";
    }





}
