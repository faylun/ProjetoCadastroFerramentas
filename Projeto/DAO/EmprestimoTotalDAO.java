package DAO;

import Model.Amigos;
import Model.EmprestimoTotal;
import Model.Ferramentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class EmprestimoTotalDAO {

    ArrayList<EmprestimoTotal> listaEmprestimoTotal = new ArrayList<>();

    public EmprestimoTotalDAO() {

    }

    public int maiorID() throws SQLException {
        int maiorID = 0;

        Connection conexao = this.getConexao();

        if (conexao != null) {
            try {
                Statement stmt = conexao.createStatement();
                ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM emprestimototal");
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

    public ArrayList<EmprestimoTotal> getListaEmprestimoTotal() {

        listaEmprestimoTotal.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select e.id, a.nome_amigo, f.nome_ferramenta, e.data_inicial, e.data_final, e.data_devolucao"
                    + " from emprestimototal as e inner join ferramentas as f on (e.id_ferramentas = f.id) inner join amigos as a"
                    + " on (e.id_amigos = a.id) ORDER BY e.id");

            while (res.next()) {

                EmprestimoTotal objetoEmprestimoTotal = new EmprestimoTotal();
                Amigos amigo = new Amigos();
                Ferramentas ferramenta = new Ferramentas();

                objetoEmprestimoTotal.setId(res.getInt("e.id"));
                amigo.setNome(res.getString("a.nome_amigo"));
                ferramenta.setNome(res.getString("f.nome_ferramenta"));
                objetoEmprestimoTotal.setAmigo(amigo);
                objetoEmprestimoTotal.setFerramenta(ferramenta);
                objetoEmprestimoTotal.setDataEmprestimo(res.getString("e.data_inicial"));
                objetoEmprestimoTotal.setDataDevolucao(res.getString("e.data_final"));
                objetoEmprestimoTotal.setDevolucao(res.getString("e.data_devolucao"));

                listaEmprestimoTotal.add(objetoEmprestimoTotal);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaEmprestimoTotal;
    }

    public void getListaEmprestimoTotalMV() {
        String query = "select a.nome_amigo, count(*) as contagem from emprestimototal as e  inner join amigos as a"
                + " on (e.id_amigos = a.id) group by a.nome_amigo ORDER BY contagem DESC LIMIT 1";

        try (Statement stmt = this.getConexao().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                String amigoMaisRepetido = rs.getString("a.nome_amigo");
                int contagem = rs.getInt("contagem");
                JOptionPane.showMessageDialog(null, "O amigo que fez mais Empréstimos é: " + amigoMaisRepetido + "\n"
                        + "Quantidade de ocorrências: " + contagem, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("A tabela está vazia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getListaDevolucaoNull() {
        String query = "select e.id, a.nome_amigo, f.nome_ferramenta from emprestimototal as e  inner join amigos as a"
                + " on (e.id_amigos = a.id)  inner join ferramentas as f on (e.id_ferramentas = f.id) "
                + "where data_devolucao IS NULL";

        try (PreparedStatement stmt = this.getConexao().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            Set<String> amigosNaoDevolvidos = new HashSet<>();

            while (rs.next()) {
                String amigo = rs.getString("a.nome_amigo");
                amigosNaoDevolvidos.add(amigo);
            }
            for (String amigos : amigosNaoDevolvidos) {
                JOptionPane.showMessageDialog(null, "Amigos que não devolveram a ferramenta: " + amigos + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getListaAmigoNaoDevolveu() {
        String query = "select e.id, a.nome_amigo, f.nome_ferramenta from emprestimototal as e  inner join amigos as a"
                + " on (e.id_amigos = a.id)  inner join ferramentas as f on (e.id_ferramentas = f.id) "
                + "where data_devolucao IS NULL";

        try (PreparedStatement stmt = this.getConexao().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            String amigosNaoDevolveram;
            Set<String> amigosNaoDevolvidos = new HashSet<>();
            Set<String> FerramentasNaoDevolvidas = new HashSet<>();

            while (rs.next()) {
                String amigo = rs.getString("a.nome_amigo");
                amigosNaoDevolvidos.add(amigo);
                String ferramenta = rs.getString("f.nome_ferramenta");
                FerramentasNaoDevolvidas.add(ferramenta);
            }
            for (String amigos : amigosNaoDevolvidos) {
                amigosNaoDevolveram = amigos;
                for (String ferramentas : FerramentasNaoDevolvidas) {
                    JOptionPane.showMessageDialog(null, amigosNaoDevolveram + " precisa devolver a ferramenta " + ferramentas);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean InsertEmprestimoTotalDB(EmprestimoTotal objetoEmprestimoTotal) {
        String sql = "INSERT INTO emprestimototal(id, id_ferramentas, id_amigos, data_inicial, data_final, data_devolucao) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objetoEmprestimoTotal.getId());
            stmt.setInt(2, objetoEmprestimoTotal.getFerramenta().getId());
            stmt.setInt(3, objetoEmprestimoTotal.getAmigo().getId());
            stmt.setString(4, objetoEmprestimoTotal.getDataEmprestimo());
            stmt.setString(5, objetoEmprestimoTotal.getDataDevolucao());
            stmt.setString(6, objetoEmprestimoTotal.getDevolucao());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return true;
    }

    public boolean DeleteEmprestimoTotalDB(int id) {

        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM emprestimototal WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return true;
    }

    public boolean UpdateEmprestimoTotalDB(EmprestimoTotal objetoEmprestimoTotal) {

        String sql = "UPDATE emprestimototal set id_ferramentas = ?, id_amigos = ?, data_inicial = ?, data_final = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objetoEmprestimoTotal.getFerramenta().getId());
            stmt.setInt(2, objetoEmprestimoTotal.getAmigo().getId());
            stmt.setString(3, objetoEmprestimoTotal.getDataEmprestimo());
            stmt.setString(4, objetoEmprestimoTotal.getDataDevolucao());
            stmt.setInt(5, objetoEmprestimoTotal.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public boolean UpdateEmprestimoTotalDDB(EmprestimoTotal objetoEmprestimoTotal) {

        String sql = "UPDATE emprestimototal set data_devolucao = ? where id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objetoEmprestimoTotal.getDevolucao());
            stmt.setInt(2, objetoEmprestimoTotal.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public EmprestimoTotal carregaEmprestimoTotal(int id) {

        EmprestimoTotal objetoEmprestimoTotal = new EmprestimoTotal();
        objetoEmprestimoTotal.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select e.id, a.nome_amigo, f.nome_ferramenta, e.data_inicial, e.data_final "
                    + "from emprestimototal as e inner join ferramentas as f on (e.id_ferramentas = f.id) inner join amigos as a"
                    + " on (e.id_amigos = a.id) ORDER BY e.id");
            res.next();

            Amigos amigo = new Amigos();
            Ferramentas ferramenta = new Ferramentas();

            amigo.setNome(res.getString("a.nome_amigo"));
            ferramenta.setNome(res.getString("f.nome_ferramenta"));
            objetoEmprestimoTotal.setAmigo(amigo);
            objetoEmprestimoTotal.setFerramenta(ferramenta);
            objetoEmprestimoTotal.setDataEmprestimo(res.getString("e.data_inicial"));
            objetoEmprestimoTotal.setDataDevolucao(res.getString("e.data_final"));

            stmt.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return objetoEmprestimoTotal;
    }

}
