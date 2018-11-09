package br.ufmg.reuso.negocio.questao.factory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.ufmg.reuso.dados.carta.RepositorioQuestao;
import br.ufmg.reuso.negocio.questao.Questao;

// FactoryMethod para criação do banco de questões com diferentes padrões
public class BancoQuestoes {	
	
	private RepositorioQuestao repositorio;
	private List<Questao> questoes;
	
	public BancoQuestoes() {
		this.repositorio = new RepositorioQuestao();	
		this.questoes = new ArrayList<Questao>();
	}
		
	public List<Questao> criarBanco(TipoConstrucao tipo, int quantidade, String topico) {
		this.recuperarQuestoes();
		switch(tipo) {
			case TODAS:
				return this.criarBancoCompleto();
			case ALEATORIO:
				return this.criarBancoAleatorio(quantidade);
			case TOPICO:
				return this.criarBancoPorTopico(topico);
			default:
				return null;
		}		
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
	
	private List<Questao> criarBancoCompleto() {
		return this.questoes;
	}
	
	private List<Questao> criarBancoAleatorio(int quantidade) {
		Collections.shuffle(this.questoes);
		List<Questao> questoesSelecionadas = new ArrayList<Questao>();
		
		for (int i = 0; i < quantidade; i++) {
			questoesSelecionadas.add(this.questoes.get(i));
		}		
		return questoesSelecionadas;
	}
	
	private List<Questao> criarBancoPorTopico(String topico) {
		return this.questoes
				   .stream()
				   .filter(q -> q.getTopico().equalsIgnoreCase(topico))				                                
				   .collect(Collectors.toList());
	}
}
