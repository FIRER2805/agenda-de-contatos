package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	/** modeulo de conexao **/
	// parâmetros de conexxão
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/db_agenda_contatos?useTimezone=true&serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "Lasanha2805g";
	private String insert_query = "insert into contatos(nome,fone,email) values(?,?,?)";
	final private String QUERY_CONTATOS = "select * from contatos";
	
	// método de conexão
	private Connection connectar()
	{
		try 
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			return con;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public void inserirContato(Contatos_JB contato)
	{
		try 
		{
			Connection con = connectar();
			PreparedStatement preStmt = con.prepareStatement(insert_query);
			preStmt.setString(1,contato.getNome());
			preStmt.setString(2,contato.getFone());
			preStmt.setString(3,contato.getEmail());
			preStmt.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<Contatos_JB> contatos()
	{
		try
		{
			ArrayList<Contatos_JB> lista = new ArrayList();
			Connection con = connectar();
			PreparedStatement query = con.prepareStatement(QUERY_CONTATOS);
			ResultSet resultado = query.executeQuery();
			while(resultado.next())
			{
				int id = resultado.getInt(1);
				String nome = resultado.getString(2);
				String fone = resultado.getString(3);
				String email = resultado.getString(4);
				Contatos_JB contato = new Contatos_JB(id,nome,fone,email);
				lista.add(contato);
			}
			return lista;
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	public void atualizarContato(Contatos_JB contato)
	{
		Connection conn = this.connectar();
		String update = "update contatos set nome = ?, fone = ?, email = ? where id_contatos = ?";
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getFone());
			pstmt.setString(3, contato.getEmail());
			pstmt.setInt(4, contato.getIdcontato());
			pstmt.executeUpdate();
		}
		catch(SQLException erro)
		{
			System.out.println("Erro no método atualizarContato na classe DAO");
			System.out.println(erro.getMessage());
		}
	}
	
	public void deletarContato(int id)
	{
		String delete = "delete from contatos where id_contatos = ?";
		Connection conn = this.connectar();
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException erro)
		{
			System.out.println("erro no método deletarContato na classe DAO");
			System.out.println(erro.getMessage());
		}
	}
}
