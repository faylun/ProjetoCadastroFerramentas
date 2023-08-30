package DAO;

import Model.Ferramentas;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FerramentasDAO {

    ArrayList<Ferramentas> listaFerramentas = new ArrayList<>();

    public FerramentasDAO() {

    }

    public int maiorID() throws SQLException {

        int maiorID = 0;

        Connection conexao = this.getConexao();

        if (conexao != null) {
            try {
                Statement stmt = this.getConexao().createStatement();
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM ferramentas");
                res.next();
                maiorID = res.getInt("id");

                stmt.close();

            } catch (SQLException ex) {
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

    public ArrayList<Ferramentas> getListaFerramentas() {

        listaFerramentas.clear();
        Connection conexao = this.getConexao();

        if (conexao != null) {
            try {
                Statement stmt = this.getConexao().createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas order by id");
                while (res.next()) {

                    Ferramentas objetoferramentas = new Ferramentas();

                    objetoferramentas.setId(res.getInt("id"));
                    objetoferramentas.setNome(res.getString("nome_ferramenta"));
                    objetoferramentas.setMarca(res.getString("marca_ferramenta"));
                    objetoferramentas.setCustoAquisicao(res.getDouble("custo_aquisicao"));

                    listaFerramentas.add(objetoferramentas);
                }
                stmt.close();
            } catch (SQLException ex) {
            }
        } else {
            System.out.println("A conexao com o Banco de Dados e nula. ");
        }

        return listaFerramentas;
    }

    public boolean InsertFerramentaDB(Ferramentas objetoFerramentas) {
        String sql = "INSERT INTO ferramentas(id, nome_ferramenta, marca_ferramenta, custo_aquisicao) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objetoFerramentas.getId());
            stmt.setString(2, objetoFerramentas.getNome());
            stmt.setString(3, objetoFerramentas.getMarca());
            stmt.setDouble(4, objetoFerramentas.getCustoAquisicao());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean DeleteFerramentaDB(int id) {

        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM ferramentas WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateFerramentaDB(Ferramentas objetoFerramentas) {

        String sql = "UPDATE ferramentas set nome_ferramenta = ?, marca_ferramenta = ?, custo_aquisicao = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objetoFerramentas.getNome());
            stmt.setString(2, objetoFerramentas.getMarca());
            stmt.setDouble(3, objetoFerramentas.getCustoAquisicao());
            stmt.setInt(4, objetoFerramentas.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
        }

        return true;
    }

    public Ferramentas carregaFerramenta(int id) {

        Ferramentas objetoFerramentas = new Ferramentas();
        objetoFerramentas.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas WHERE id = " + id);
            res.next();

            objetoFerramentas.setNome(res.getString("nome_ferramenta"));
            objetoFerramentas.setMarca(res.getString("marca_ferramenta"));
            objetoFerramentas.setCustoAquisicao(res.getInt("custo_aquisicao"));

            stmt.close();

        } catch (SQLException erro) {
        }

        return objetoFerramentas;
    }
}
