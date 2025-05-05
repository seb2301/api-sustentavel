package com.sebastiao.api_sustentavel.response;

public class AcaoSustentavelResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private String local;


    public AcaoSustentavelResponse() {
    }


    public AcaoSustentavelResponse(Long id, String titulo, String descricao, String categoria, String local) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.local = local;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
