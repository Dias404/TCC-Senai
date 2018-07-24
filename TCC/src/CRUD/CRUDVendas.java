package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;

public class CRUDVendas {

	Conexao con = new Conexao();
	public ResultSet dados = null;
	
	public boolean insertVenda(String cliente, String loja, String produto, int quantidade, String preco, String desconto, String data) {
		String sql = "INSERT INTO vendas(cliente,loja_emitente,produto,quantidade,preco_total,desconto,data_venda) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, cliente);
			stmt.setString(2, loja);
			stmt.setString(3, produto);
			stmt.setInt(4, quantidade);
			stmt.setString(5, preco);
			stmt.setString(6, desconto);
			stmt.setString(7, data);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean selectVenda() {
		String sql = "SELECT * FROM vendas";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectVendaEspecifica(int idVenda) {
		String sql = "SELECT * FROM vendas WHERE id_venda=?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setInt(1, idVenda);
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
