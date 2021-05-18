package io.github.kassuncao.todo.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.kassuncao.todo.domain.Todo;
import io.github.kassuncao.todo.repository.TodoRepository;
import io.github.kassuncao.todo.service.TodoService;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 24 de abr de 2021 - @author Kennedy Assunção - Primeira versão da classe.
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@RestController
@RequestMapping ( "/api" )
public class TodoController {

    @Autowired
    TodoRepository repository;

    @Autowired
    TodoService service;

    @PostMapping ( "/todos" )
    public Todo save ( @RequestBody Todo todo ) {
        return service.save( todo );
    }
    
    @DeleteMapping ( "/todos/{id}" )
    public void remove (@PathVariable Long id ) {
        service.remove(id);
    }

    @GetMapping ( "/todos" )
    public List < Todo > listar () {
        List < Todo > all = service.getAll();
        return all;
    }

    @GetMapping ( "/todos/{id}" )
    public Todo getById ( @PathVariable Long id ) {
        return repository.findById( id )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }
    
    @PatchMapping ( "/todos/{id}/done" )
    public Todo done ( @PathVariable Long id ) {
        return repository.findById( id ).map( todo -> {
            todo.setDone( Boolean.TRUE );
            todo.setDoneDate( LocalDateTime.now() );
            repository.save( todo );
            return todo;
        } ).orElse( null );
    }
}
