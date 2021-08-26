package org.generation.blogPessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity //essa classe vai ser uma entidade do jpa rebernate
@Table(name = "postagem") // nomeia a tabela no banco de dados
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 5, max = 100)
    private String titulo;

    @NotBlank
    @Size(min = 10, max = 500)
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis());
    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;

    public Tema getTema() {
        return tema;
    }
    public void setTema(Tema tema) {
        this.tema = tema;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
