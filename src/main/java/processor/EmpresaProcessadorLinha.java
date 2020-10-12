package processor;

import javax.persistence.EntityManager;

import dao.BairroDao;
import dao.CidadeDao;
import dao.EmpresaDao;
import dao.UfDao;
import model.Bairro;
import model.Cidade;
import model.Empresa;
import model.Uf;
import validador.EmpresaValidador;

public class EmpresaProcessadorLinha implements ProcessadorLinha{
	
	private UfDao ufDao;
	private CidadeDao cidadeDao;
	private BairroDao bairroDao;
	private EmpresaDao empresaDao;
	private EmpresaValidador empresaValidador = new EmpresaValidador();
	
	public EmpresaProcessadorLinha(EntityManager em) {
		this.ufDao = new UfDao(em);
		this.cidadeDao = new CidadeDao(em);
		this.bairroDao = new BairroDao(em);
		this.empresaDao = new EmpresaDao(em);
	}
	
	public void processa(String linha) {
		FiscalizacaoCsv csv = new FiscalizacaoCsv(linha);
			
		Uf uf = ufDao.busca(csv.getSiglaUf());
		if(uf == null) {
			return;
		}

		Cidade cidade = cidadeDao.busca(uf, csv.getCidade());
		if(cidade == null) {
			return;
		}

		Bairro bairro = bairroDao.busca(cidade, csv.getBairro());
		if(bairro == null) {
			return;
		}
		
		Empresa EmpresaAux = empresaDao.busca(csv.getCNPJ());
		if(EmpresaAux == null) {
			Empresa empresa = new Empresa();
			empresa.setUf(uf);
			empresa.setCidade(cidade);
			empresa.setBairro(bairro);
			empresa.setCep(csv.getCep());
			empresa.setLogradouro(csv.getLogradouro());
			empresa.setRazaoSocial(csv.getRazaoSocial());
			empresa.setCnpj(csv.getCNPJ());
			if (empresaValidador.isNaoValido(empresa)) {
				System.out.println(empresaValidador.getMensagem());
				return;
			}
			empresaDao.inserir(empresa);
		}
	}
}
