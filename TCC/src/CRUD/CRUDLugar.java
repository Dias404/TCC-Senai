package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.Conexao;
import DAO.Lojas;
import DAO.Lugar;

public class CRUDLugar {

	static Conexao con = new Conexao();
	public static ResultSet dadosSelect = null;
	
	public boolean insertCidade(Lugar cidade, int idEstado) {
		try {
			String sql = "INSERT INTO cidades (nome_cidade, id_estado) VALUES (?,?)";
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, cidade.getNomeCidade());
			stmt.setInt(2, idEstado);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro.");
			return false;
		}
	}
	
}
