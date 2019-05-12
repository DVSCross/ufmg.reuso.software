package br.ufmg.reuso.negocio.questao.factory;

import java.util.List;
import java.util.stream.Collectors;

import br.ufmg.reuso.negocio.questao.Questao;

public class BancoQuestoesTopicos extends BancoQuestoes {
	
	private String topico;
	
	public BancoQuestoesTopicos(String topico) {
		this.topico = topico;
	}
	
	@Override
	public List<Questao> criarBanco() {
		return this.questoes
				   .stream()
				   .filter(q -> q.getTopico().equalsIgnoreCase(this.topico))				                                
				   .collect(Collectors.toList());
	}
}
