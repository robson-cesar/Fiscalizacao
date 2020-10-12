package processor;

import javax.persistence.EntityManager;

import dao.UfDao;
import model.Uf;
import validador.UfValidador;

public class UfProcessadorLinha implements ProcessadorLinha{

	private UfDao ufDao;
	private EntityManager em = null;
	private UfValidador ufValidador = new UfValidador();

	public UfProcessadorLinha(EntityManager em) {
		this.em = em;
		this.ufDao = new UfDao(em);
	}

	public void processa(String linha) {
		try {
			em.getTransaction().begin();
			
			UfTxt txt = new UfTxt(linha);
			Uf ufAux = ufDao.busca(txt.getNome());
			if(ufAux == null) {
				Uf uf = new Uf();
				uf.setSigla(txt.getSigla());
				uf.setNome(txt.getNome());
				if (ufValidador.isNaoValido(uf)) {
					System.out.println(ufValidador.getMensagem());
					return;
				}
				ufDao.inserir(uf);
			}
			
			em.getTransaction().commit();
			
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
	}

	public class UfTxt { 

		private String campos[];

		public UfTxt(String linha) {  
			campos = linha.split(",");
		}

		public String getSigla() {
			return campos[1].trim();
		}

		public String getNome() {
			return campos[0];
		}
	}

}
