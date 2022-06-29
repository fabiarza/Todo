package io.company.repository;

import io.company.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDo, Integer> {
    //ToDo findByName(String name);
}
