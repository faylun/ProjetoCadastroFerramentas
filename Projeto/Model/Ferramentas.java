package Model;

import DAO.FerramentasDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ferramentas {

    private int id;
    private String nome;
    private String marca;
    private double custoAquisicao;
    private final FerramentasDAO dao;

    public Ferramentas() {
        this.dao = new FerramentasDAO();

    }

    public Ferramentas(int id, String nome, String marca, int custoAquisicao) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custoAquisicao = custoAquisicao;
        this.dao = new FerramentasDAO();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCustoAquisicao() {
        return custoAquisicao;
    }

    public void setCustoAquisicao(double custoAquisicao) {
        this.custoAquisicao = custoAquisicao;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public ArrayList getListaFerramentas() {

        return dao.getListaFerramentas();
    }

    public boolean InsertFerramentaDB(String nome, String marca, int custoAquisicao) throws SQLException {

        int id = this.maiorID() + 1;
        Ferramentas objetoFerramentas = new Ferramentas(id, nome, marca, custoAquisicao);
        dao.InsertFerramentaDB(objetoFerramentas);

        return true;
    }

    public boolean DeleteFerramentaDB(int id) {
        return dao.DeleteFerramentaDB(id);
    }

    public boolean UpdateFerramentaDB(int id, String nome, String marca, int custoAquisicao) {
        Ferramentas objetoFerramentas = new Ferramentas(id, nome, marca, custoAquisicao);

        dao.UpdateFerramentaDB(objetoFerramentas);
        return true;
    }

    public Amigos CarregaFerramenta(int id) {
        dao.carregaFerramenta(id);

        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
