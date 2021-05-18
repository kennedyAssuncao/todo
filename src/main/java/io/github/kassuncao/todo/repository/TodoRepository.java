package io.github.kassuncao.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

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

public interface TodoRepository extends JpaRepository < Todo , Long > {

}
