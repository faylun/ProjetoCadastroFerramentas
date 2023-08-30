package DAO;

import Model.Amigos;
import Model.Emprestimos;
import Model.Ferramentas;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmprestimosDAO {

    ArrayList<Emprestimos> listaEmprestimos = new ArrayList<>();

    public EmprestimosDAO() {

    }

    public int maiorID() throws SQLException {
        int maiorID = 0;

        Connection conexao = this.getConexao();

        if (conexao != null) {
            try {
                Statement stmt = conexao.createStatement();
                ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM emprestimos");
                if (res.next()) {
                    maiorID = res.getInt("id");
                }

                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("A conexao com o banco de dados é nula.");
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;

        try {

            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "127.0.0.1";
            String database = "projeto";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root12345678";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NAO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    public ArrayList<Emprestimos> getListaEmprestimos() {

        listaEmprestimos.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select e.id, a.nome_amigo, f.nome_ferramenta, f.custo_aquisicao, e.data_inicial, e.data_final "
                    + "from emprestimos as e inner join ferramentas as f on (e.id_ferramenta = f.id) inner join amigos as a"
                    + " on (e.id_amigo = a.id) ORDER BY e.id");

            while (res.next()) {

                Emprestimos objetoEmprestimos = new Emprestimos();
                Amigos amigo = new Amigos();
                Ferramentas ferramenta = new Ferramentas();

                objetoEmprestimos.setId(res.getInt("e.id"));
                amigo.setNome(res.getString("a.nome_amigo"));
                ferramenta.setNome(res.getString("f.nome_ferramenta"));
                ferramenta.setCustoAquisicao(res.getDouble("f.custo_aquisicao"));
                objetoEmprestimos.setAmigo(amigo);
                objetoEmprestimos.setFerramenta(ferramenta);
                objetoEmprestimos.setDataEmprestimo(res.getString("e.data_inicial"));
                objetoEmprestimos.setDataDevolucao(res.getString("e.data_final"));

                listaEmprestimos.add(objetoEmprestimos);
            }
            stmt.close();
        } catch (SQLException ex) {
        }

        return listaEmprestimos;
    }

    public boolean InsertEmprestimoDB(Emprestimos objetoEmprestimos) {
        String sql = "INSERT INTO emprestimos(id, id_ferramenta, id_amigo, data_inicial, data_final) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objetoEmprestimos.getId());
            stmt.setInt(2, objetoEmprestimos.getFerramenta().getId());
            stmt.setInt(3, objetoEmprestimos.getAmigo().getId());
            stmt.setString(4, objetoEmprestimos.getDataEmprestimo());
            stmt.setString(5, objetoEmprestimos.getDataDevolucao());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return true;
    }

    public boolean DeleteEmprestimoDB(int id) {

        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM emprestimos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateEmprestimoDB(Emprestimos objetoEmprestimos) {

        String sql = "UPDATE emprestimos set id_ferramenta = ?, id_amigo = ?, data_inicial = ?, data_final = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objetoEmprestimos.getFerramenta().getId());
            stmt.setInt(2, objetoEmprestimos.getAmigo().getId());
            stmt.setString(3, objetoEmprestimos.getDataEmprestimo());
            stmt.setString(4, objetoEmprestimos.getDataDevolucao());
            stmt.setInt(5, objetoEmprestimos.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public Emprestimos carregaEmprestimo(int id) {

        Emprestimos objetoEmprestimos = new Emprestimos();
        objetoEmprestimos.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select e.id, a.nome_amigo, f.nome_ferramenta, e.data_inicial, e.data_final "
                    + "from emprestimos as e inner join ferramentas as f on (e.id_ferramenta = f.id) inner join amigos as a"
                    + " on (e.id_amigo = a.id) ORDER BY e.id");
            res.next();

            Amigos amigo = new Amigos();
            Ferramentas ferramenta = new Ferramentas();

            amigo.setNome(res.getString("a.nome_amigo"));
            ferramenta.setNome(res.getString("f.nome_ferramenta"));
            objetoEmprestimos.setAmigo(amigo);
            objetoEmprestimos.setFerramenta(ferramenta);
            objetoEmprestimos.setDataEmprestimo(res.getString("e.data_inicial"));
            objetoEmprestimos.setDataDevolucao(res.getString("e.data_final"));

            stmt.close();

        } catch (SQLException erro) {
        }

        return objetoEmprestimos;
    }

}
