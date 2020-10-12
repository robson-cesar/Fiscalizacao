package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_fiscalizacao")
public class Fiscalizacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer anoFiscalizacao;
	@Column(length = 10)
	private String mesFiscalizacao;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoFiscalizacao() {
		return anoFiscalizacao;
	}

	public void setAnoFiscalizacao(Integer anoFiscalizacao) {
		this.anoFiscalizacao = anoFiscalizacao;
	}

	public String getMesFiscalizacao() {
		return mesFiscalizacao;
	}

	public void setMesFiscalizacao(String mesFiscalizacao) {
		this.mesFiscalizacao = mesFiscalizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		Fiscalizacao other = (Fiscalizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fiscalizacao [id=" + id + ", anoFiscalizacao=" + anoFiscalizacao + ", mesFiscalizacao="
				+ mesFiscalizacao + ", empresa=" + empresa + "]";
	}
}
