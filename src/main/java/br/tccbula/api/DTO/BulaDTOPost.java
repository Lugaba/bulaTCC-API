package br.tccbula.api.DTO;

import java.util.ArrayList;

public class BulaDTOPost {
    private long id;
    private String nome;
    private String indicacao;
    private String posologia;
    private String contraindicacao;
    private String efeitosColaterais;
    private ArrayList<String> imagesURL;
    private String bulaCompletaURL;
    private ArrayList<Long> categoriasID;

    public String getBulaCompletaURL() {
        return bulaCompletaURL;
    }

    public String getContraindicacao() {
        return contraindicacao;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
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

    public void setContraindicacao(String contraindicacao) {
        this.contraindicacao = contraindicacao;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
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

    public ArrayList<Long> getCategoriasID() {
        return categoriasID;
    }

    public void setCategoriasID(ArrayList<Long> categoriasID) {
        this.categoriasID = categoriasID;
    }
}
