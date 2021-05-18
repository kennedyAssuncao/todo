package io.github.kassuncao.todo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository repository;

    /**
     * TODO Descrição do Método
     * 
     * @param todo
     * @return
     * @see io.github.kassuncao.todo.service.TodoService#save(io.github.kassuncao.todo.domain.Todo)
     */
    @Override
    public Todo save ( Todo todo ) {
        todo.setCreatedDate( LocalDateTime.now() );
        return repository.save( todo );
    }

    /** 
     * TODO Descrição do Método
     * @return
     * @see io.github.kassuncao.todo.service.TodoService#getAll()
     */
    @Override
    public List < Todo > getAll () {
        return repository.findAll();
    }

    /** 
     * TODO Descrição do Método
     * @param id
     * @return
     * @see io.github.kassuncao.todo.service.TodoService#remove(java.lang.Long)
     */
    @Override
    public void remove ( Long id ) {
        Optional<Todo> findById = repository.findById( id );
        if ( findById.isPresent() ) {
            repository.deleteById( id );
        }
    }

}
