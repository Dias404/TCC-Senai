package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Produtos;

public class CRUDProdutos {

	Conexao con = new Conexao();
	public ResultSet dados = null;
	
	public boolean insertProduto(Produtos produto) {
		String sql = "INSERT INTO produtos(fornecedor,loja_emitente,data_entrada,codigo,descricao,cor,preco,quantidade) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, produto.getFornecedor());
			stmt.setString(2, produto.getLojaEmitente());
			stmt.setString(3, produto.getDataDeEmissao());
			stmt.setString(4, produto.getCodigo());
			stmt.setString(5, produto.getDescricao());
			stmt.setString(6, produto.getCorSelecionada());
			stmt.setString(7, produto.getPreco());
			stmt.setInt(8, produto.getQuantidade());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectProduto() {
		String sql = "SELECT * FROM produtos";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
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
		String sql = "SELECT * FROM produtos WHERE "+variavelSelect+" LIKE ? ORDER BY fornecedor";
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
	
	public ResultSet selectDadosProdutoEspecifico(int idProduto) {
		String sql = "SELECT * FROM produtos WHERE id_produto=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, idProduto);
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
	
	public boolean deleteProduto(int idProduto) {
		String sql = "DELETE FROM produtos WHERE id_produto=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, idProduto);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateProduto(Produtos produto, int idProduto) {
		String sql = "UPDATE produtos SET fornecedor=?,loja_emitente=?,data_entrada=?,codigo=?,descricao=?,cor=?,preco=?,quantidade=? WHERE id_produto=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, produto.getFornecedor());
			stmt.setString(2, produto.getLojaEmitente());
			stmt.setString(3, produto.getDataDeEmissao());
			stmt.setString(4, produto.getCodigo());
			stmt.setString(5, produto.getDescricao());
			stmt.setString(6, produto.getCorSelecionada());
			stmt.setString(7, produto.getPreco());
			stmt.setInt(8, produto.getQuantidade());
			stmt.setInt(9, idProduto);
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
