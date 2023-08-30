package DAO;

import Model.Amigos;
import java.util.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AmigosDAO {

    public static ArrayList<Amigos> listaAmigos = new ArrayList<>();

    public AmigosDAO() {

    }

    public int maiorID() throws SQLException {
        int maiorID = 0;

        Connection conexao = this.getConexao();

        if (conexao != null) {
            try {
                Statement stmt = conexao.createStatement();
                ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM amigos");
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

        Connection connection;

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

    public ArrayList<Amigos> getListaAmigos() {

        listaAmigos.clear();
        Connection conexao = this.getConexao();

        if (conexao != null) {
            try {
                Statement stmt = getConexao().createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM amigos order by id");
                while (res.next()) {
                    Amigos objetoamigos = new Amigos();

                    objetoamigos.setId(res.getInt("id"));
                    objetoamigos.setNome(res.getString("nome_amigo"));
                    objetoamigos.setTelefone(res.getString("telefone"));

                    listaAmigos.add(objetoamigos);
                }
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("A conexao com o Banco de Dados e nula. ");
        }

        return listaAmigos;
    }

    public boolean InsertAmigoDB(Amigos objetoAmigos) {
        String sql = "INSERT INTO amigos(id, nome_amigo, telefone) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objetoAmigos.getId());
            stmt.setString(2, objetoAmigos.getNome());
            stmt.setString(3, objetoAmigos.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean DeleteAmigoDB(int id) {

        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM amigos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return true;
    }

    public boolean UpdateAmigoDB(Amigos objetoAmigos) {

        String sql = "UPDATE amigos set nome_amigo = ?, telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objetoAmigos.getNome());
            stmt.setString(2, objetoAmigos.getTelefone());
            stmt.setInt(3, objetoAmigos.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public Amigos carregaAmigo(int id) {

        Amigos objetoAmigos = new Amigos();
        objetoAmigos.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM amigos WHERE id = " + id);
            res.next();

            objetoAmigos.setNome(res.getString("nome_amigo"));
            objetoAmigos.setTelefone(res.getString("telefone"));

            stmt.close();

        } catch (SQLException erro) {
        }

        return objetoAmigos;
    }
}
