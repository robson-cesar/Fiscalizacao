package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_empresa")
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String cnpj;
	@Column(length = 70)
	private String razaoSocial;
	@Column(length = 70)
	private String logradouro;
	@Column(length = 10)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "id_uf")
	private Uf uf;
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	@ManyToOne
	@JoinColumn(name = "id_bairro")
	private Bairro bairro;
	@OneToMany (mappedBy = "empresa")
	private List<Fiscalizacao> fiscalizacoes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public List<Fiscalizacao> getFiscalizacoes() {
		return fiscalizacoes;
	}
	
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", logradouro=" + logradouro
				+ ", cep=" + cep + ", uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro + ", fiscalizacoes="
				+ fiscalizacoes + "]";
	}
}
