package Model;

import DAO.EmprestimoTotalDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmprestimoTotal {

    private String dataEmprestimo;
    private String dataDevolucao;
    private Ferramentas ferramenta;
    private Amigos amigo;
    private int id;
    private final EmprestimoTotalDAO dao;
    private String devolucao;

    public EmprestimoTotal() {
        this.dao = new EmprestimoTotalDAO();
    }

    public EmprestimoTotal(String dataEmprestimo, String dataDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dao = new EmprestimoTotalDAO();
    }

    public EmprestimoTotal(int id, Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao, String devolucao) {
        this.id = id;
        this.ferramenta = ferramenta;
        this.amigo = amigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolucao = devolucao;
        this.dao = new EmprestimoTotalDAO();
    }
        public EmprestimoTotal(int id, Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao) {
        this.id = id;
        this.ferramenta = ferramenta;
        this.amigo = amigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dao = new EmprestimoTotalDAO();
    }

    public EmprestimoTotal(int id, String devolucao) {
        this.id = id;
        this.devolucao = devolucao;
        this.dao = new EmprestimoTotalDAO();
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

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    @Override
    public String toString() {
        return "Emprestimos { nome Amigo: " + amigo.getNome() + ", nome Ferramenta: " + ferramenta.getNome()
                + ", dataEmprestimo = " + dataEmprestimo + ", dataDevolucao = " + dataDevolucao
                + " devolucao Real = " + devolucao;
    }

    public ArrayList getListaEmprestimoTotal() {

        return dao.getListaEmprestimoTotal();
    }

    public boolean InsertEmprestimoTotalDB(Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao) throws SQLException {

        int id = this.maiorID() + 1;
        EmprestimoTotal objetoEmprestimoTotal = new EmprestimoTotal(id, ferramenta, amigo, dataEmprestimo, dataDevolucao);
        dao.InsertEmprestimoTotalDB(objetoEmprestimoTotal);

        return true;
    }

    public boolean DeleteEmprestimoTotalDB(int id) {
        return dao.DeleteEmprestimoTotalDB(id);
    }

    public boolean UpdateEmprestimoTotalDB(int id, Ferramentas ferramenta, Amigos amigo, String dataEmprestimo, String dataDevolucao, String devolucao) {
        EmprestimoTotal objetoEmprestimoTotal = new EmprestimoTotal(id, ferramenta, amigo, dataEmprestimo, dataDevolucao, devolucao);

        dao.UpdateEmprestimoTotalDB(objetoEmprestimoTotal);
        return true;
    }

    public boolean UpdateEmprestimoTotalDDB(int id, String devolucao) {
        EmprestimoTotal objetoEmprestimoTotal = new EmprestimoTotal(id, devolucao);

        dao.UpdateEmprestimoTotalDDB(objetoEmprestimoTotal);
        return true;
    }

    public Amigos CarregaEmprestimoTotal(int id) {
        dao.carregaEmprestimoTotal(id);

        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
