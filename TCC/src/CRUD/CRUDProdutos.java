package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;

public class CRUDProdutos {

	Conexao con = new Conexao();
	public ResultSet dados = null;
	
	public boolean insertProduto(String fornecedor, String lojaEmitente, String dataDeEmissao, String codigo, String descricao, String corSelecionada) {
		String sql = "INSERT INTO produtos(fornecedor,loja_emitente,data_entrada,codigo,descricao,cor) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, fornecedor);
			stmt.setString(2, lojaEmitente);
			stmt.setString(3, dataDeEmissao);
			stmt.setString(4, codigo);
			stmt.setString(5, descricao);
			stmt.setString(6, corSelecionada);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectProdutos() {
		String sql = "SELECT * FROM produtos";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dados = null;
		}
	}
	
	public ResultSet selectComWhere(String variavelSelect, String valorSelect) {
		String sql = "SELECT * FROM produtos WHERE"+variavelSelect+"LIKE ? ORDER BY fornecedor";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, valorSelect+"%");
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dados = null;
		}
	}
}
