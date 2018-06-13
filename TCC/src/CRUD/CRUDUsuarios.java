package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Usuarios;

public class CRUDUsuarios {

	static Conexao con = new Conexao();
	public static ResultSet dadosSelect = null;
	
	public boolean insertUsuario(Usuarios usuario) {
		try {
			String sql = "INSERT INTO usuarios (nome, senha, email, fone, cel) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getFone());
			stmt.setString(5, usuario.getCel());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectUsuarios() {
		String sql = "SELECT * FROM usuarios ORDER BY nome ASC";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public static ResultSet selectUsuarioLogado() {
		String sql = "SELECT * FROM usuarios WHERE logged = 1";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public static ResultSet selectCondicao1(String user, String senha) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
		ResultSet rs = null;
		try {
			java.sql.PreparedStatement s = con.getConexao().prepareStatement(sql);
			s.setString(1, user);
			s.setString(2, senha);
			rs = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet selectCondicao2(String nome, String email) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? AND email = ?";
		ResultSet rs = null;
		try {
			java.sql.PreparedStatement s = con.getConexao().prepareStatement(sql);
			s.setString(1, nome);
			s.setString(2, email);
			rs = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}
	
	public static boolean login(String user, String senha) {
		String sql = "UPDATE usuarios SET logged = 1 WHERE nome = ? AND senha = ?";
		try {
			java.sql.PreparedStatement s = con.getConexao().prepareStatement(sql);
			s.setString(1, user);
			s.setString(2, senha);
			s.execute();
			s.close();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean logoff() {
		String sql = "UPDATE usuarios SET logged = 0 WHERE logged = 1";
		java.sql.PreparedStatement stmt;
		try {
			stmt = con.getConexao().prepareStatement(sql);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateNome() {
		String sql = "UPDATE usuarios SET nome WHERE ";
		java.sql.PreparedStatement stmt;
		try {
			stmt = con.getConexao().prepareStatement(sql);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {e1.printStackTrace();
			return false;
		}
	}
	
}
