package validador;

import model.Empresa;

public class EmpresaValidador {

	private String mensagem = null;
	
	public boolean isNaoValido(Empresa empresa) {
		mensagem = null;
		
		if (empresa.getUf() == null) { 
			mensagem = "UF não informada.";
			return true;
		}
		
		if (empresa.getCidade() == null) { 
			mensagem = "Cidade não informada.";
			return true;
		}
		
		if (empresa.getBairro() == null) { 
			mensagem = "Bairro não informado.";
			return true;
		}
		
		if (isEmpty(empresa.getCep())) {
			mensagem = "CEP não informado.";
			return true;
		}
		
		if (empresa.getCep().length() > 10) {
			mensagem = "CEP inválido.";
			return true;
		}
		
		if (isEmpty(empresa.getLogradouro())) {
			mensagem = "Logradouro não informado.";
			return true;
		}
		
		if (empresa.getLogradouro().length() > 70) {
			mensagem = "Logradouro inválido.";
			return true;
		}
		
		if (isEmpty(empresa.getCnpj())) {
			mensagem = "CNPJ não informado.";
			return true;
		}
		
		if (empresa.getCnpj().length() < 14 || empresa.getCnpj().length() > 20) {
			mensagem = "CNPJ inválido.";
			return true;
		}
		
		return false;
	}

	public String getMensagem() {
		return mensagem;
	}

	private boolean isEmpty(String str) { 
		return (str == null) || (str.length() == 0);
	}
	
}
