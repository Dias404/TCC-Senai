package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Banco.Conexao;
import DAO.Lojas;
import DAO.Usuarios;

public class CRUDLojas {

	static Conexao con = new Conexao();
	public static ResultSet dadosSelect = null;
	
	public boolean insertLoja(Lojas loja, JButton btn) {
		try {
			String sql = "INSERT INTO lojas (razao, estado, cidade, bairro, rua, numero, cnpj, ie, tel1, tel2, cel1, cel2) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, loja.getRazao());
			stmt.setString(2, loja.getEstado());
			stmt.setString(3, loja.getCidade());
			stmt.setString(4, loja.getBairro());
			stmt.setString(5, loja.getRua());
			stmt.setInt(6, loja.getNumero());
			stmt.setString(7, loja.getCnpj());
			stmt.setString(8, loja.getIe());
			stmt.setString(9, loja.getTel1());
			stmt.setString(10, loja.getTel2());
			stmt.setString(11, loja.getCel1());
			stmt.setString(12, loja.getCel2());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "A Loja foi cadastrada!");
			btn.doClick();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Verifique se todos\nos campos estão preenchidos.");
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectLoja() {
		String sql = "SELECT * FROM lojas ORDER BY razao";
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
