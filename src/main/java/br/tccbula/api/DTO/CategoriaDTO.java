package br.tccbula.api.DTO;

public class CategoriaDTO {
    private long id;
    private String nome;

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
