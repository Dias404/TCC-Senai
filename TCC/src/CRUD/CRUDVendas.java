package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Vendas;

public class CRUDVendas {

	Conexao con = new Conexao();
	public ResultSet dados = null;
	
	public boolean insertVenda(Vendas venda) {
		String sql = "INSERT INTO vendas(cliente,loja_emitente,produto,quantidade,preco_total,desconto,data_venda) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, venda.getCliente());
			stmt.setString(2, venda.getLoja());
			stmt.setString(3, venda.getProduto());
			stmt.setInt(4, venda.getQuantidade());
			stmt.setString(5, venda.getPreco());
			stmt.setString(6, venda.getDesconto());
			stmt.setString(7, venda.getData());
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
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
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
	
	public ResultSet selectComWhere(String variavelSelect, String valorSelect) {
		String sql = "SELECT * FROM vendas WHERE "+variavelSelect+" LIKE ? ORDER BY cliente";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
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
	
	public ResultSet selectVendaEspecifica(int idVenda) {
		String sql = "SELECT * FROM vendas WHERE id_venda=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
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
	
	public boolean deleteVenda(int idVenda) {
		String sql = "DELETE FROM vendas WHERE id_venda=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, idVenda);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateVenda(Vendas venda, int idVenda) {
		String sql = "UPDATE vendas SET cliente=?,loja_emitente=?,produto=?,quantidade=?,preco_total=?,desconto=?,data_venda=? WHERE id_venda=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, venda.getCliente());
			stmt.setString(2, venda.getLoja());
			stmt.setString(3, venda.getProduto());
			stmt.setInt(4, venda.getQuantidade());
			stmt.setString(5, venda.getPreco());
			stmt.setString(6, venda.getDesconto());
			stmt.setString(7, venda.getData());
			stmt.setInt(8, idVenda);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
