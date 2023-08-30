package Model;

import DAO.EmprestimosDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Emprestimos {

    private String dataEmprestimo;
    private String dataDevolucao;
    private Ferramentas ferramenta;
    private Amigos amigo;
    private int id;
    private final EmprestimosDAO dao;

    public Emprestimos() {
        this.dao = new EmprestimosDAO();
    }

    public Emprestimos(String dataEmprestimo, String dataDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dao = new EmprestimosDAO();
    }

    public Emprestimos(int id, Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao) {
        this.id = id;
        this.ferramenta = ferramenta;
        this.amigo = amigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dao = new EmprestimosDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Amigos getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigos amigo) {
        this.amigo = amigo;
    }

    public Ferramentas getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramentas ferramenta) {
        this.ferramenta = ferramenta;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimos { nome Amigo: " + amigo.getNome() + ", nome Ferramenta: " + ferramenta.getNome()
                + ", dataEmprestimo = " + dataEmprestimo + ", dataDevolucao = " + dataDevolucao
                + " }";
    }

    public ArrayList getListaEmprestimos() {

        return dao.getListaEmprestimos();
    }

    public boolean InsertEmprestimoDB(Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao) throws SQLException {

        int id = this.maiorID() + 1;
        Emprestimos objetoEmprestimos = new Emprestimos(id, ferramenta, amigo, dataEmprestimo, dataDevolucao);
        dao.InsertEmprestimoDB(objetoEmprestimos);

        return true;
    }

    public boolean DeleteEmprestimoDB(int id) {
        return dao.DeleteEmprestimoDB(id);
    }

    public boolean UpdateEmprestimoDB(int id, Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao) {
        Emprestimos objetoEmprestimo = new Emprestimos(id, ferramenta, amigo, dataEmprestimo, dataDevolucao);

        dao.UpdateEmprestimoDB(objetoEmprestimo);
        return true;
    }

    public Amigos CarregaEmprestimo(int id) {
        dao.carregaEmprestimo(id);

        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
