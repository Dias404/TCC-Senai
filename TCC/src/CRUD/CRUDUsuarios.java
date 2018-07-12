package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.Conexao;
import DAO.Usuarios;

public class CRUDUsuarios {

	static Conexao con = new Conexao();
	public static ResultSet dadosLogin = null;
	public static ResultSet dadosSelect = null;
	
	public boolean insertUsuario(Usuarios usuario) {
		try {
			String sql = "INSERT INTO usuarios (nome, senha, email, fone, cel, nivel) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt =Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getFone());
			stmt.setString(5, usuario.getCel());
			stmt.setString(6, usuario.getNivel());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static ResultSet selectUsuarios() {
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
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	/*
	public static ResultSet selectCondicao0(String user, String email, String senha) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? OR email = ? AND senha = ?";
		ResultSet rs = null;
		try {
			java.sql.PreparedStatement s = con.getConexao().prepareStatement(sql);
			s.setString(1, user);
			s.setString(2, email);
			s.setString(3, senha);
			rs = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}
	*/
	
	public static ResultSet selectCondicao1(String user, String senha) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, senha);
			dadosLogin = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosLogin;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return dadosLogin = null;
		}
	}
	
	public static ResultSet selectCondicao2(String nome, String email) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? AND email = ?";
		ResultSet rs = null;
		try {
			java.sql.PreparedStatement s = Conexao.conexao.prepareStatement(sql);
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
			java.sql.PreparedStatement s = Conexao.conexao.prepareStatement(sql);
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
	
	public static boolean logoff(String user, String senha) {
		String sql = "UPDATE usuarios SET logged = 0 WHERE nome = ? AND senha = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, senha);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateNome(String nome, String email) {
		String sql = "UPDATE usuarios SET nome = ? WHERE email = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql); 
			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "O nome deste usuário foi alterado com sucesso.");
			return true;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o nome deste usuário.", null, JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateSenha(String senha, String email) {
		String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql); 
			stmt.setString(1, senha);
			stmt.setString(2, email);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "A senha deste usuário foi alterado com sucesso.");
			return true;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar a senha deste usuário.", null, JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateEmail(String email, String senha, String nome) {
		String sql = "UPDATE usuarios SET email = ? WHERE senha = ? AND nome = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql); 
			stmt.setString(1, email);
			stmt.setString(2, senha);
			stmt.setString(3, nome);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "O e-mail deste usuário foi alterado com sucesso.");
			return true;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o e-mail deste usuário.", null, JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateFone(String fone, String email) {
		String sql = "UPDATE usuarios SET fone = ? WHERE email = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql); 
			stmt.setString(1, fone);
			stmt.setString(2, email);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "O número de telefone deste usuário foi alterado com sucesso.");
			return true;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o número de telefone deste usuário.", null, JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateCel(String cel, String email) {
		String sql = "UPDATE usuarios SET cel = ? WHERE email = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql); 
			stmt.setString(1, cel);
			stmt.setString(2, email);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "O número de celular deste usuário foi alterado com sucesso.");
			return true;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o número de celular deste usuário.", null, JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean selectComWhere(String variavelSelect, String like) {
		String sql = "SELECT * FROM usuarios WHERE "+variavelSelect+" LIKE ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, "%"+like+"%");
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
