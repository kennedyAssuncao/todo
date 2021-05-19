package io.github.kassuncao.todo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
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

@Entity
@Table ( name = "todo" )
public class Todo {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;
    private String description;
    private Boolean done;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:SS")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:SS")
    private LocalDateTime doneDate;

    public Todo () {
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Boolean getDone () {
        return done;
    }

    public void setDone ( Boolean done ) {
        this.done = done;
    }

    public LocalDateTime getCreatedDate () {
        return createdDate;
    }

    public void setCreatedDate ( LocalDateTime createdDate ) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getDoneDate () {
        return doneDate;
    }

    public void setDoneDate ( LocalDateTime doneDate ) {
        this.doneDate = doneDate;
    }

    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
        return result;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Todo other = ( Todo ) obj;
        if ( id == null ) {
            if ( other.id != null )
                return false;
        } else if ( ! id.equals( other.id ) )
            return false;
        return true;
    }

    @Override
    public String toString () {
        return "Todo [id=" + id + ", description=" + description + ", done=" + done
                + ", createdDate=" + createdDate + ", doneDate=" + doneDate + "]";
    }

}
