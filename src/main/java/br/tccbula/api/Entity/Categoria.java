package br.tccbula.api.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "categoria_bula", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "bula_id"))
    private List<Bula> bulas;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Bula> getBulas() {
        return bulas;
    }

    public void setBulas(List<Bula> bulas) {
        this.bulas = bulas;
    }

    public void addBula(Bula bula) {
        bulas.add(bula);
        bula.getCategorias().add(this);
    }

    public void removeBula(Bula bula) {
        bulas.remove(bula);
        bula.getCategorias().remove(this);
    }
}