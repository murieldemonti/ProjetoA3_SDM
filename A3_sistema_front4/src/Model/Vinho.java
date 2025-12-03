package Model;

import java.util.*;
import DAO.BancoDAO;
import java.sql.SQLException;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Vinho extends Produto {

    private String tipo;
    private String regiao;
    private String marca;
    private final BancoDAO dao;

    public Vinho() {
        this.dao = new BancoDAO();
    }

    public Vinho(String tipo, String regiao, String marca) {
        this.tipo = tipo;
        this.regiao = regiao;
        this.marca = marca;
        this.dao = new BancoDAO();
    }

    public Vinho(String tipo, String regiao, String marca, int id, String nome, String descricao, int quant_estoque, double preco, String data_cadastro) {
        super(id, nome, descricao, quant_estoque, preco, data_cadastro);
        this.tipo = tipo;
        this.regiao = regiao;
        this.marca = marca;
        this.dao = new BancoDAO();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Descrição: " + this.getDescricao()
                + "\n Quantidade:" + this.getQuant_estoque()
                + "\n Preço:" + this.getPreco()
                + "\n Data de Cadastro: " + this.getData_cadastro()
                + "\n Tipo: " + this.getTipo()
                + "\n Região: " + this.getRegiao()
                + "\n Marca: " + this.getMarca()
                + "\n -----------";
    }

    public ArrayList getMinhaLista() {

        return dao.getMinhaLista();
    }

    public boolean InsertVinhoBD(String tipo, String regiao, String marca, String nome, String descricao, int quant_produto, double preco, String data_cadastro) throws SQLException {
        int id = this.maiorID() + 1;
        Vinho objeto = new Vinho(tipo, regiao, marca, id, nome, descricao, quant_produto, preco, data_cadastro);

        dao.InsertVinhoBD(objeto);
        return true;

    }

    public boolean DeleteVinhoBD(int id) {

        dao.DeleteVinhoBD(id);
        return true;
    }

    public boolean UpdateVinhoBD(String tipo, String regiao, String marca, int id, String nome, String descricao, int quant_produto, double preco, String data_cadastro) {
        Vinho objeto = new Vinho(tipo, regiao, marca, id, nome, descricao, quant_produto, preco, data_cadastro);

        dao.UpdateVinhoBD(objeto);
        return true;
    }

    public Produto carregaVinho(int id) {

        dao.carregaVinho(id);
        return null;
    }

    public int maiorID() throws SQLException {

        return dao.maiorID();
    }


}