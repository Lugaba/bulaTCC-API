package br.tccbula.api.DTO;

import java.util.ArrayList;

public class BulaDTO {
    private long id;
    private String nome;
    private String indicacao;
    private String posologia;
    private String contraindicacao;
    private String efeitosColaterais;
    private ArrayList<String> imagesURL;
    private String bulaCompletaURL;
    private fabricanteDTO fabricante;
    private ArrayList<CategoriaDTO> categorias;

    public String getBulaCompletaURL() {
        return bulaCompletaURL;
    }

    public ArrayList<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public String getContraindicacao() {
        return contraindicacao;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public fabricanteDTO getFabricante() {
        return fabricante;
    }

    public long getId() {
        return id;
    }

    public ArrayList<String> getImagesURL() {
        return imagesURL;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public String getNome() {
        return nome;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setBulaCompletaURL(String bulaCompletaURL) {
        this.bulaCompletaURL = bulaCompletaURL;
    }

    public void setCategorias(ArrayList<CategoriaDTO> categorias) {
        this.categorias = categorias;
    }

    public void setContraindicacao(String contraindicacao) {
        this.contraindicacao = contraindicacao;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    public void setFabricante(fabricanteDTO fabricante) {
        this.fabricante = fabricante;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImagesURL(ArrayList<String> imagesURL) {
        this.imagesURL = imagesURL;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }
}
