package entity;

public class Endereco {

	private Integer idEndereco;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	private Cliente cliente;

	public Endereco() {
	}

	public Endereco(Integer idEndereco, String logradouro, String bairro, String cidade, String estado, String cep,
			Cliente cliente) {
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return logradouro + ", " + bairro + ", " + cidade + ", " + estado + ", " + cep;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
