package br.ufmg.reuso.negocio.jogo;

import java.util.Random;

import br.ufmg.reuso.negocio.carta.CartaBonificacao;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.tabuleiro.SetupInteraction;

public class ConceptsInteraction {
	
	public ConceptsInteraction() { }
	
	public void choseReceiveMaturityPointsNow(Jogador jogador, 
			                                  CartaBonificacao cartaUtilizada,
			                                  SetupInteraction setupController)
	{
		String[] engenheiro = setupController.escolherEngenheiro(jogador, 1);
		if (engenheiro[0] == null)
			return;
		
		for (int i = 0; i < jogador.getTabuleiro()
				.getMesas().length; i++) /**
											 * 
											 * 
											 * percorrendo mesas do
											 * tabuleiro
											 */
		{
			if (jogador.getTabuleiro().getMesas()[i].getCartaMesa() == null)
				continue;
			if (jogador.getTabuleiro().getMesas()[i].getCartaMesa().getEngenheiro().getNomeEngenheiro()
					.equals(engenheiro[0])) /**
											 * encontra engenheiro que
											 * recebera efeito
											 */
			{
				jogador.getTabuleiro().getMesas()[i]
						.setEfeitoAumentarMaturidadeEngenheiro(cartaUtilizada.getQuantidadePrimeiroEfeito());
			}
		}
				
	}			
	
	public void choseReceiveSkillPointsLater(Jogador jogador, 
                                             CartaBonificacao cartaUtilizada,
                                             SetupInteraction setupController)
	{
		String[] engenheiro = setupController.escolherEngenheiro(jogador, 1);
		for (int j = 0; j < engenheiro.length; j++) {
			if (engenheiro[j] == null)
				continue;
			
			// percorrendo mesas do tabuleiro
			for (int i = 0; i < jogador.getTabuleiro().getMesas().length; i++) 
			{
				if (jogador.getTabuleiro().getMesas()[i].getCartaMesa() == null)
					continue;
				
				// encontra engenheiro que receberá efeito
				if (jogador.getTabuleiro().getMesas()[i].getCartaMesa().getEngenheiro().getNomeEngenheiro().equals(engenheiro[j])) 
				{
					String[] auxiliar = new String[2];
					auxiliar[0] = engenheiro[j];
					auxiliar[1] = Integer.toString(cartaUtilizada.getQuantidadePrimeiroEfeito());
					jogador.getTabuleiro().getEfeitoAumentarHabilidadeEngenheiroLater().add(auxiliar);
				}
			}
		}
	}

	public void choseReceiveSkillPointsNow(Jogador jogador, 
                                           CartaBonificacao cartaUtilizada,
                                           SetupInteraction setupController)
	{
		String[] engenheiro = setupController.escolherEngenheiro(jogador, 1);
		if (engenheiro[0] == null)
			return;
		
		// percorrendo mesas do tabuleiro
		for (int i = 0; i < jogador.getTabuleiro().getMesas().length; i++) 
		{
			if (jogador.getTabuleiro().getMesas()[i].getCartaMesa() == null)
				continue;
			// encontra engenheiro que recebera efeito
			if (jogador.getTabuleiro().getMesas()[i].getCartaMesa().getEngenheiro().getNomeEngenheiro()
					.equals(engenheiro[0])) 
			{
				jogador.getTabuleiro().getMesas()[i]
						.setEfeitoAumentarMaturidadeEngenheiro(cartaUtilizada.getQuantidadePrimeiroEfeito());
			}
		}
	}
}
