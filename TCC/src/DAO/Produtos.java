package DAO;

public class Produtos {
	
	public int idProduto;
	public String fornecedor;
	public String lojaEmitente;
	public String dataDeEmissao;
	public String codigo;
	public String descricao;
	public String corSelecionada;
	public String preco;
	public int quantidade;
	
	public int getIdProdutos() {
		return idProduto;
	}
	public void setIdProdutos(int idProdutos) {
		this.idProduto = idProdutos;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getLojaEmitente() {
		return lojaEmitente;
	}
	public void setLojaEmitente(String lojaEmitente) {
		this.lojaEmitente = lojaEmitente;
	}
	public String getDataDeEmissao() {
		return dataDeEmissao;
	}
	public void setDataDeEmissao(String dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCorSelecionada() {
		return corSelecionada;
	}
	public void setCorSelecionada(String corSelecionada) {
		this.corSelecionada = corSelecionada;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
