package Models;

public class Armazenamento {
    private Integer id;
    private String endereco;
    private String categoria;
    private String volume;
    private float custo;

    public Armazenamento() {
    }

    public Armazenamento(Integer id, String endereco, String categoria, String volume, float custo) {
        this.id = id;
        this.endereco = endereco;
        this.categoria = categoria;
        this.volume = volume;
        this.custo = custo;
    }

    public Armazenamento(String endereco, String categoria, String volume, float custo) {
        this.endereco = endereco;
        this.categoria = categoria;
        this.volume = volume;
        this.custo = custo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }
}