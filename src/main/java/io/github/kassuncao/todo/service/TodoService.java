package io.github.kassuncao.todo.service;

import java.util.List;

import io.github.kassuncao.todo.domain.Todo;

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

public interface TodoService {

    public Todo save ( Todo todo );

    /** 
     * TODO Descrição do Método
     * @return
     */
    public List < Todo > getAll ();

    /** 
     * TODO Descrição do Método
     * @param id
     */
    public void remove ( Long id );

}
