package br.ufmg.reuso.negocio.questao.factory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.ufmg.reuso.dados.carta.RepositorioQuestao;
import br.ufmg.reuso.negocio.questao.Questao;

// Criação do banco de questões com diferentes padrões
public class BancoQuestoes {	
	
	private RepositorioQuestao repositorio;
	protected List<Questao> questoes;
	
	public BancoQuestoes() {
		this.repositorio = new RepositorioQuestao();	
		this.questoes = new ArrayList<Questao>();
		this.recuperarQuestoes();
	}		
	
	private void recuperarQuestoes() {
		String[] arquivosDiretorio = this.repositorio.getNomeArquivosPasta(Questao.DIRETORIO);			
		
		for (int i = 0;i < arquivosDiretorio.length;i++) {
			if(arquivosDiretorio[i].endsWith(".properties")) {				
				try {
					this.questoes.add(this.repositorio.obterQuestao(Questao.DIRETORIO + File.separator + arquivosDiretorio[i]));
				} catch(Exception e) {
					// printa exceção
				} 
			}			
		}		
	}
	
	public List<Questao> criarBanco() {		
		return this.questoes;
	}	
}
