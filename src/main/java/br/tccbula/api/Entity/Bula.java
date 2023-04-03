package br.tccbula.api.Entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "bula")
public class Bula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String indicacao;

    @Column(nullable = false)
    private String posologia;

    @Column(nullable = false)
    private String contraindicacao;

    @Column(nullable = false)
    private String efeitosColaterais;

    @Column(nullable = false)
    private ArrayList<String> imagesURL;

    @Column(nullable = false)
    private String bulaCompletaURL;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public String getPosologia() {
        return posologia;
    }

    public String getContraindicacao() {
        return contraindicacao;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public String getBulaCompletaURL() {
        return bulaCompletaURL;
    }

    public ArrayList<String> getImagesURL() {
        return imagesURL;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public void setContraindicacao(String contraindicacao) {
        this.contraindicacao = contraindicacao;
    }

    public void setBulaCompletaURL(String bulaCompletaURL) {
        this.bulaCompletaURL = bulaCompletaURL;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    public void setImagesURL(ArrayList<String> imagesURL) {
        this.imagesURL = imagesURL;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}