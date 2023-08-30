package Model;

import DAO.AmigosDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Amigos {

    private int id;
    private String nome;
    private String telefone;
    private final AmigosDAO dao;

    public Amigos() {
        this.dao = new AmigosDAO();
    }

    public Amigos(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dao = new AmigosDAO();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public ArrayList getListaAmigos() {
        
        return dao.getListaAmigos();
    }

    public boolean InsertAmigoDB(String nome, String telefone) throws SQLException {

        int id = this.maiorID() + 1;
        Amigos objetoAmigos = new Amigos(id, nome, telefone);
        dao.InsertAmigoDB(objetoAmigos);
        
        return true;
    }

    public boolean DeleteAmigoDB(int id) {
        return dao.DeleteAmigoDB(id);
    }

    public boolean UpdateAmigoDB(int id, String nome, String telefone) {
        Amigos objetoAmigo = new Amigos(id, nome, telefone);

        dao.UpdateAmigoDB(objetoAmigo);
        return true;
    }

    public Amigos CarregaAmigo(int id) {
        dao.carregaAmigo(id);

        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
