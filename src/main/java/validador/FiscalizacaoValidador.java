package validador;

import model.Fiscalizacao;

public class FiscalizacaoValidador {

	private String mensagem = null;

	public boolean isNaoValido(Fiscalizacao fiscalizacao) {
		mensagem = null;

		if (isEmpty(fiscalizacao.getMesFiscalizacao())) {
			mensagem = "Mês não informado.";
			return true;
		}

		if (fiscalizacao.getMesFiscalizacao().length() > 7 || fiscalizacao.getMesFiscalizacao().length() < 6) {
			mensagem = "Mês inválido.";
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
