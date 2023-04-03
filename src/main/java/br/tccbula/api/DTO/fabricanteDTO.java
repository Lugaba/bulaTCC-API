package br.tccbula.api.DTO;

public class fabricanteDTO {
    private long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
