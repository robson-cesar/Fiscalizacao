package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import processor.ProcessadorLinha;

public class Reader {
	
	public void executa(String arq, ProcessadorLinha processadorLinha) {	
		executa(arq, processadorLinha, false);
	}
	
	public void executa(String arq, ProcessadorLinha processadorLinha, boolean pulaPrimeiraLinha) {	
		
		BufferedReader conteudoCsv = null;
		try {
//			conteudoCsv = new BufferedReader (new FileReader(arq));
			conteudoCsv = new BufferedReader (new InputStreamReader(new FileInputStream(arq),"UTF-8"));
			String linha = conteudoCsv.readLine();
			if (pulaPrimeiraLinha) { 
				linha = conteudoCsv.readLine();
			}
			while (linha != null) {
				processadorLinha.processa(linha);
				linha = conteudoCsv.readLine();
			}
			conteudoCsv.close();
			
		} catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
	}
}
