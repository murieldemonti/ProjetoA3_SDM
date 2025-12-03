package Model;

public abstract class Produto {

    private int id;
    private String nome;
    private String descricao;
    private int quant_estoque;
    private double preco;
    private String data_cadastro;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, int quant_estoque, double preco, String data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quant_estoque = quant_estoque;
        this.preco = preco;
        this.data_cadastro = data_cadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuant_estoque() {
        return quant_estoque;
    }

    public void setQuant_estoque(int quant_estoque) {
        this.quant_estoque = quant_estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}