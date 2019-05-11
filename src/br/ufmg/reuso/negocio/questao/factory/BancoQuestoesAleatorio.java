package br.ufmg.reuso.negocio.questao.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufmg.reuso.negocio.questao.Questao;

public class BancoQuestoesAleatorio extends BancoQuestoes
{
	private int quantidade;
	
	public BancoQuestoesAleatorio(int quantidade){
		this.quantidade = quantidade;
	}
	
	@Override
	public List<Questao> criarBanco() {
		Collections.shuffle(this.questoes);
		List<Questao> questoesSelecionadas = new ArrayList<Questao>();
		
		for (int i = 0; i < this.quantidade; i++) {
			questoesSelecionadas.add(this.questoes.get(i));
		}	
		
		return questoesSelecionadas;
	}
}
