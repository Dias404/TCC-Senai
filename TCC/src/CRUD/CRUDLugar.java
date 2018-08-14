package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Banco.Conexao;
import DAO.Lugar;

public class CRUDLugar {

	static Conexao con = new Conexao();
	public ResultSet dadosSelect = null;
	public ResultSet dados = null;
	public ResultSet idEstadoSelecionado = null;
	
	/*   CRUD Lugar Ordem (Insert, Select, Upate, Delete)   */
	
	// CRUD Estado
	public ResultSet selectEstados() {
		String sql = "SELECT * FROM estados";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);;
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dados;
		} catch (SQLException e) {
			e.printStackTrace();
			return dados = null;
		}
	}
	
	public ResultSet selectUFId(String nomeEstado) {
		String sql = "SELECT (id_estado) FROM estados WHERE nome_estado=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, nomeEstado);
			idEstadoSelecionado = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return idEstadoSelecionado;
		} catch (SQLException e) {
			e.printStackTrace();
			return idEstadoSelecionado = null;
		}
	}
	
	// CRUD Cidade
	public static boolean insertCidade(Lugar cidade, int idEstado) {
		try {
			String sql = "INSERT INTO cidades (nome_cidade, id_estado) VALUES (?,?)";
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getNomeCidade());
			stmt.setInt(2, idEstado);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cidade.");
			return false;
		}
	}
	
	public ResultSet selectCidade() {
		String sql = "SELECT * FROM cidades";
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
	
	public ResultSet selectCidadeCondicao1(String nomeCidade, int idEstado) {
		String sql = "SELECT * FROM cidades WHERE nome_cidade = ? AND id_estado = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, nomeCidade);
			stmt.setInt(2, idEstado);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public ResultSet selectCidadeCondicao2(int idEstado) {
		String sql = "SELECT * FROM cidades WHERE id_estado = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, idEstado);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public static int selectIdEstado(String nomeEstado) {
		ResultSet estados;
		int resposta = 0;
		String sql = "SELECT * FROM estados WHERE nome_estado = ?";
		PreparedStatement stmt;
		try {
			stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, nomeEstado);
			estados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			
			if(estados.next()) {
				resposta = estados.getInt("id_estado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
	
	
	//CRUD Bairro
	public static boolean insertBairro(String bairro, int idCidade) {
		try {
			String sql = "INSERT INTO bairros (nome_bairro, id_cidade) VALUES (?,?)";
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, bairro);
			stmt.setInt(2, idCidade);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Bairro cadastrado com sucesso.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o bairro.");
			return false;
		}
	}
	
	public ResultSet selectBairro(int id_cidade) {
		String sql = "SELECT * FROM bairros WHERE id_cidade = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, id_cidade);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public ResultSet selectBairroCondicao1(String nomeBairro, int idCidade) {
		String sql = "SELECT * FROM bairros WHERE nome_bairro = ? AND id_cidade = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, nomeBairro);
			stmt.setInt(2, idCidade);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public ResultSet selectBairroCondicao2(int idCidade, int idEstado) {
		String sql = "SELECT * FROM bairros WHERE id_cidade = ? AND id_estado = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, idCidade);
			stmt.setInt(2, idEstado);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public ResultSet selectIdCidade() {
		String sql = "SELECT * FROM bairros";
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
	
	
	//CRUD Rua
	public ResultSet selectRua(int id_bairro) {
		String sql = "SELECT * FROM ruas WHERE id_bairro = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, id_bairro);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
}
