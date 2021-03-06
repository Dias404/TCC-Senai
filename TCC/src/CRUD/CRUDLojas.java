package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Lojas;

public class CRUDLojas {

	static Conexao con = new Conexao();
	public static ResultSet dadosSelect = null;
	
	public boolean insertLoja(Lojas loja) {
		try {
			String sql = "INSERT INTO lojas (razao, estado, cidade, bairro, rua, numero, cnpj, ie, tel1, tel2, cel1, cel2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, loja.getRazao());
			stmt.setString(2, loja.getEstado());
			stmt.setString(3, loja.getCidade());
			stmt.setString(4, loja.getBairro());
			stmt.setString(5, loja.getRua());
			stmt.setString(6, loja.getNumero());
			stmt.setString(7, loja.getCnpj());
			stmt.setString(8, loja.getIe());
			stmt.setString(9, loja.getTel1());
			stmt.setString(10, loja.getTel2());
			stmt.setString(11, loja.getCel1());
			stmt.setString(12, loja.getCel2());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectLoja() {
		String sql = "SELECT * FROM lojas ORDER BY razao";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
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
