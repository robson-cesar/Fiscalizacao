package processor;

public class FiscalizacaoCsv {
	
	private String campos[];
	
	public FiscalizacaoCsv(String linha) {
		campos = linha.split(";");
	}
	
	private String tratarCelula(String str) {
		return str.replaceAll("\"", "").trim();
	}
	
	public Integer getAnoFiscalizacao() {
		try {
			return Integer.parseInt(tratarCelula(campos[0]));
		} catch(Exception e) {
			return null;	
		}
	}

	public String getMesFiscalizacao() {
		return tratarCelula(campos[1]);
	}
	
	public String getCNPJ() {
		return tratarCelula(campos[2]);
	}
	
	public String getRazaoSocial() {
		return tratarCelula(campos[3]);
	}
	
	public String getLogradouro() {
		return tratarCelula(campos[4]);
	}
	
	public String getCep() {
		return tratarCelula(campos[5]);
	}
	
	public String getBairro() {
		return tratarCelula(campos[6]);
	}
	
	public String getCidade() {
		return tratarCelula(campos[7]);
	}
	
	public String getSiglaUf() {
		return tratarCelula(campos[8]);
	}
	
	public int getColunasDisponiveis() {
		return campos.length;
	}
	
}
