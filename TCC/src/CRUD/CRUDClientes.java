package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Clientes;

public class CRUDClientes {
	
	Conexao con = new Conexao();
	public ResultSet dadosSelect = null;
	public ResultSet dadosEspecificos = null;
	public ResultSet dadosEstados = null;
	public ResultSet idEstadoSelecionado = null;
	public ResultSet dadosCidades = null;
	public ResultSet idCidadeSelecionado = null;
	public ResultSet dadosBairros = null;
	
	public boolean insertCliente(Clientes cliente) {
		String sql = "INSERT INTO clientes (tipo_de_pessoa,nome_razao,sexo,email,uf,cidade,bairro,rua,numero,cpf_cnpj,rg_ie,mae,pai,data_de_nascimento,estado_civil,tel1,tel2,cel1,cel2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, cliente.getTipoDePessoa());
			stmt.setString(2, cliente.getNomeRazao());
			stmt.setString(3, cliente.getSexo());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getUF());
			stmt.setString(6, cliente.getCidade());
			stmt.setString(7, cliente.getBairro());
			stmt.setString(8, cliente.getRua());
			stmt.setString(9, cliente.getNumero());
			stmt.setString(10, cliente.getCPF_CNPJ());
			stmt.setString(11, cliente.getRG_IE());
			stmt.setString(12, cliente.getMae());
			stmt.setString(13, cliente.getPai());
			stmt.setString(14, cliente.getDataDeNascimento());
			stmt.setString(15, cliente.getEstadoCivil());
			stmt.setString(16, cliente.getTel1());
			stmt.setString(17, cliente.getTel2());
			stmt.setString(18, cliente.getCel1());
			stmt.setString(19, cliente.getCel2());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectClientes() {
		String sql = "SELECT * FROM clientes ORDER BY nome_razao";
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
	
	public ResultSet selectClientesByEmail() {
		String sql = "SELECT * FROM clientes ORDER BY nome";
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
	
	public ResultSet selectDadosClienteEspecifico(String ClienteSelecionado) {
		String sql = "SELECT * FROM clientes WHERE cpf_cnpj=?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, ClienteSelecionado);
			dadosEspecificos = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosEspecificos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dadosEspecificos = null;
		}
	}

	public ResultSet selectCidadeId(String nomeCidade) {
		String sql = "SELECT (id_cidade) FROM cidades WHERE nome_cidade=?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, nomeCidade);
			idCidadeSelecionado = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return idCidadeSelecionado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return idCidadeSelecionado = null;
		}
	}
	
	public ResultSet selectBairro(int idCidade) { 
		String sql = "SELECT (nome_bairro) FROM bairros WHERE id_cidade=?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setInt(1, idCidade);
			dadosBairros = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosBairros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dadosBairros = null;
		}
	}
	
	public boolean insertCidade(String nomeCidade, int idEstado) {
		String sql = "INSERT INTO cidades (nome_cidade,id_estado) VALUES (?,?)";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, nomeCidade);
			stmt.setInt(2, idEstado);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertBairro(String nomeBairro, int idCidade) {
		String sql = "INSERT INTO bairros (nome_bairro,id_cidade) VALUES (?,?)";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, nomeBairro);
			stmt.setInt(2, idCidade);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCliente(int idCliente) {
		String sql = "DELETE FROM clientes WHERE id_cliente=?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setInt(1, idCliente);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean updateCliente(Clientes cliente, int idCliente) {
		String sql = "UPDATE clientes SET tipo_de_pessoa=?,nome_razao=?,sexo=?,email=?,uf=?,cidade=?,bairro=?,rua=?,numero=?,cpf_cnpj=?,rg_ie=?,mae=?,pai=?,data_de_nascimento=?,estado_civil=?,tel1=?,tel2=?,cel1=?,cel2=? WHERE id_cliente=?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, cliente.getTipoDePessoa());
			stmt.setString(2, cliente.getNomeRazao());
			stmt.setString(3, cliente.getSexo());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getUF());
			stmt.setString(6, cliente.getCidade());
			stmt.setString(7, cliente.getBairro());
			stmt.setString(8, cliente.getRua());
			stmt.setString(9, cliente.getNumero());
			stmt.setString(10, cliente.getCPF_CNPJ());
			stmt.setString(11, cliente.getRG_IE());
			stmt.setString(12, cliente.getMae());
			stmt.setString(13, cliente.getPai());
			stmt.setString(14, cliente.getDataDeNascimento());
			stmt.setString(15, cliente.getEstadoCivil());
			stmt.setString(16, cliente.getTel1());
			stmt.setString(17, cliente.getTel2());
			stmt.setString(18, cliente.getCel1());
			stmt.setString(19, cliente.getCel2());
			stmt.setInt(20, idCliente);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean selectComWhere(String variavelSelect, String valorSelect) {
		String sql = "SELECT * FROM clientes WHERE "+variavelSelect+" LIKE ? ORDER BY nome_razao";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, valorSelect+"%");
			dadosSelect = stmt.executeQuery();
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
