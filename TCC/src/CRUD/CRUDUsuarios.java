package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Usuarios;

public class CRUDUsuarios {

	Conexao con = new Conexao();
	public ResultSet dadosSelect = null;
	
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
	
}
