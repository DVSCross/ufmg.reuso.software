package br.ufmg.reuso.dados.carta;

import br.ufmg.reuso.negocio.questao.Questao;

public interface IRepositorioQuestao {	
    Questao obterQuestao(String nome);
}
