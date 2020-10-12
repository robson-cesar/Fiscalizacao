package processor;

import javax.persistence.EntityManager;

import dao.EmpresaDao;
import dao.FiscalizacaoDao;
import model.Empresa;
import model.Fiscalizacao;
import validador.FiscalizacaoValidador;

public class FiscalizacaoProcessadorLinha implements ProcessadorLinha{
	
	private FiscalizacaoDao fiscalizacaoDao;
	private EmpresaDao empresaDao;
	private FiscalizacaoValidador fiscalizacaoValidador = new FiscalizacaoValidador();
	
	public FiscalizacaoProcessadorLinha(EntityManager em) {
		this.fiscalizacaoDao = new FiscalizacaoDao(em);
		this.empresaDao = new EmpresaDao(em);
	}
	
	public void processa(String linha) {
		FiscalizacaoCsv csv = new FiscalizacaoCsv(linha);
	
		Empresa empresa = empresaDao.busca(csv.getCNPJ());
		if(empresa == null) {
			return;
		}

		Fiscalizacao fiscAux = fiscalizacaoDao.busca(empresa, csv.getMesFiscalizacao());
		if(fiscAux == null) {
			Fiscalizacao fiscalizacao = new Fiscalizacao();
			fiscalizacao.setAnoFiscalizacao(csv.getAnoFiscalizacao());
			fiscalizacao.setMesFiscalizacao(csv.getMesFiscalizacao());
			fiscalizacao.setEmpresa(empresa);
			if (fiscalizacaoValidador.isNaoValido(fiscalizacao)) {
				System.out.println(fiscalizacaoValidador.getMensagem());
				return;
			}
			fiscalizacaoDao.inserir(fiscalizacao);
		}
	}
}
