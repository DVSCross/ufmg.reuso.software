package br.ufmg.reuso.dados.carta;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import br.ufmg.reuso.dados.RepositorioArquivo;
import br.ufmg.reuso.negocio.questao.Questao;

public class RepositorioQuestao extends RepositorioArquivo implements IRepositorioQuestao{

	@Override
	public Questao obterQuestao(String nome) {
		Properties a = getArquivoProperties(nome);
		
		Questao questao = new Questao();
		
		questao.setEnunciado(a.getProperty("enunciado"));
		questao.setResposta(a.getProperty("resposta"));	
		
		List<String> alternativas = Arrays.asList(a.getProperty("alternativas").split(";"));
		questao.setAlternativas(alternativas);
		
		return questao;
	}
}
