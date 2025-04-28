package com.sebastiao.api_sustentavel.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private CategoriaAcao categoria;

    private LocalDate dataRealizacao;
    private String responsavel;


    public AcaoSustentavel() { }

    public AcaoSustentavel(String titulo,
                           String descricao,
                           CategoriaAcao categoria,
                           LocalDate dataRealizacao,
                           String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataRealizacao = dataRealizacao;
        this.responsavel = responsavel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public CategoriaAcao getCategoria() { return categoria; }
    public void setCategoria(CategoriaAcao categoria) { this.categoria = categoria; }
    public LocalDate getDataRealizacao() { return dataRealizacao; }
    public void setDataRealizacao(LocalDate dataRealizacao) { this.dataRealizacao = dataRealizacao; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
