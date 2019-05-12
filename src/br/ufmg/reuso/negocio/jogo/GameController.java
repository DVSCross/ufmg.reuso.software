/*
  * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 28/07/2011
 */
package br.ufmg.reuso.negocio.jogo;


import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.tabuleiro.SetupInteraction;
import br.ufmg.reuso.ui.ScreenInteraction;

/**
 * @author Michael David
 *
 */
public class GameController implements GameInteraction
{
	private static GameController GameController;
	public static final int ARTEFATOS_BONS = 0;
	public static final int ARTEFATOS_RUINS = 1;
	public static final int ARTEFATOS_SELECIONADO = 0;
	public static final int ARTEFATOS_NAO_SELECIONADO = -1;

	private GameController() 
	{
		
	}
	
	public static GameController getGameController()
	{
		if(GameController==null)
			GameController = new GameController();
		return GameController;
	}
	
        /**joga dados do jogadorAtual, no jogoAtual. É retornado as novas carcateristicas do jogadorAtual*/
	 @Override
	public Jogador jogarDados(Jogo jogoAtual,Jogador jogadorAtual) 		
	{
		Jogador auxiliar;
		auxiliar=jogoAtual.jogarDado(jogadorAtual);
                
                /**atualiza que o jogador não pode jogar dados, ou seja, na rodada já jogou dados*/
		jogadorAtual.setDadoJogado(true);				
		return auxiliar;
	} 
	 
        /**Termina jogada do jogadorAtual*/
	 @Override
	public void terminarJogada(Jogador jogadorAtual) 					
	{
                /**atualiza que o jogador pode jogar dados, ou seja, na rodada ainda não jogou dados*/
		jogadorAtual.setDadoJogado(false);     
		for (int i=0;i<jogadorAtual.getTabuleiro().getMesas().length;i++) 
		{
                        /**Se mesa vazia, pula iteração*/
			if(jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa()==null) 
				continue;			
			else
			{
				/**Restaura pontos de habilidade das cartas de engenheiro na mesas do tabuleiro do jogador*/

				jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().setHabilidadeEngenheiroAtual
					(jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().getEngenheiro().getHabilidadeEngenheiro()); 

        /**codigo particionado: Início*/
				jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().setHabilidadeEngenheiroAtual 
        
        /**codigo particionado: Fim*/
					(jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().getEngenheiro().getHabilidadeEngenheiro()); 
			
				/**Atualiza que o engenheiro não trabalhou na rodada para a próxima rodada que virá*/
				jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().setEngenheiroTrabalhouNestaRodada(false);
			}
		}
		
	}
        
        /**Mostra cartao de projeto do jogo*/
	 @Override
	public void verProjeto(Jogo jogoAtual) 		
	{
		jogoAtual.setupController.exibirProjeto(jogoAtual.getProjeto());
	}

	/**retira as cartas do jogadorAtual e o retorna com características novas*/
	 @Override
	public Jogador descartarCartas(Jogo jogoAtual, Jogador jogadorAtual, Carta[] cartasDescartadas)
	{
		Jogador auxiliar;
		auxiliar=jogoAtual.retirarCartas(jogadorAtual, cartasDescartadas);
		
		return auxiliar;
	} 
	
	/**retira carta de engenheiro do tabuleiro do jogador e a transfere para monte do baralho*/
	 @Override
	public Jogador demitirEngenheiro(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroDemitido) 
	{
		Jogador auxiliar;
		auxiliar=jogoAtual.despedirEngenheiro(jogadorAtual,engenheiroDemitido);
		
		
		return auxiliar;
	}

	/**retira cartas de engenheiro da mão do jogador e as insere no tabuleiro*/
	 @Override
	public Jogador contratarEngenheiroI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroContratado) 
	{
		int posicao = jogoAtual.setupController.escolherMesa();
		posicao--;
		Jogador auxiliar;
		auxiliar=jogoAtual.admitirEngenheiro(jogadorAtual,engenheiroContratado,posicao);
		
		return auxiliar;
	}
	
	/**Engenheiro produz artefato*/
	 @Override
	public Jogador produzirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroProduzindo) 
	{
		Jogador auxiliar;
		int mesaTrabalho = jogoAtual.setupController.escolherMesadeTrabalho();
		if (mesaTrabalho ==-1)													
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de produzir artefato cancelada pelo jogador",""); 
                        //NÃO FAZ NADA COM JOGADOR
			return jogadorAtual;												
		}
		mesaTrabalho--;
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null)
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de produzir artefato cancelada: Mesa vazia","");
                        
                        //NÃO FAZ NADA COM JOGADOR
			return jogadorAtual;												
		}	
		auxiliar=jogoAtual.inserirArtefato(jogadorAtual,engenheiroProduzindo, mesaTrabalho);
		
		return auxiliar;
		
	}

        /**Engenheiro inspeciona artefato*/
	 @Override
	 public Jogador inspecionarArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroInspecionando) 
	{
		Jogador auxiliar;
		int mesaTrabalho = jogoAtual.setupController.escolherMesadeTrabalho();
		if (mesaTrabalho ==-1)													
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada pelo jogadoR",""); 		
			return jogadorAtual;												
		}
		mesaTrabalho--;
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null)
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada: Mesa vazia, sem engenheiro","");
			return jogadorAtual;
		}
		
		auxiliar=jogoAtual.conferirArtefato(jogadorAtual,engenheiroInspecionando, mesaTrabalho);

		return auxiliar;

	}
	
         /**Engenheiro corrige artefato com bug*/
	 @Override
	public Jogador corrigirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroCorrigindo) 
	{
		Jogador auxiliar;
		int mesaTrabalho = jogoAtual.setupController.escolherMesadeTrabalho();
		if (mesaTrabalho ==-1)
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada pelo jogador.",""); 
			return jogadorAtual;
		}
		mesaTrabalho--;
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null)
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada: Mesa vazia","");
			return jogadorAtual;												
		}
		
		auxiliar=jogoAtual.repararArtefato(jogadorAtual,engenheiroCorrigindo, mesaTrabalho);

		return auxiliar;
	}
	
	/** Integra um conjunto de artefatos em módulo, conforme cartão de projeto.*/ //TODO [ARS] // COMPLETAMENTE ALTERADA
	 @Override
	public Jogador integrarModuloI(Jogo jogoAtual, Jogador jogadorAtual,CartaEngenheiro engenheiroIntegrador, int mesa) 
	{
		Jogador auxiliar;
		
		if (mesa ==-1)													
		{
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de integrar modulo cancelada pelo jogador.","");
			return jogadorAtual;												
		}		
		int mesaTrabalho = mesa;
		
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null)
		{
			jogoAtual.setupController.exibirMensagem("Operação de integrar módulo cancelada: Mesa vazia, sem engenheiro", "Integração.");
			return jogadorAtual;										
		}
		
		int moduloEscolhido = jogoAtual.setupController.escolherModuloProjeto(jogoAtual.getProjeto().getModulos(), mesaTrabalho);
		int [][]artefatosEscolhidos = jogoAtual.setupController.artefatosEscolhidos();
		
		auxiliar=jogoAtual.integrarModuloJ(jogadorAtual, engenheiroIntegrador, mesaTrabalho,moduloEscolhido,artefatosEscolhidos);
                
                 /**habilita o engenheiro situado na mesaTrabalho a trocar modulo integrado de mesa*/
		jogoAtual.setupController.habilitarTrocarModuloIntegrado(mesaTrabalho);
		
		
		if (jogoAtual.getProjeto().validarProjeto(jogoAtual, jogadorAtual) ==SetupInteraction.PROJETO_CONCLUIDO)
		{
			jogoAtual.setupController.exibirVencedor(jogadorAtual);
			jogoAtual.setGameStatus(Jogo.Status.WINNER_END);
		}		
		
		return auxiliar;
	}
	 

	 @Override
        
         /**transfere modulo integrado de uma mesa para outra mesa sem módulo integrado*/
	public Jogador tranferirModuloIntegrado(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroTransferindo)	
	{
		ScreenInteraction.getScreenInteraction().exibirMensagem("tranferir módulo requerido","");
                
                /**contém mesa para transferir módulo integrado*/
		int mesaEscolhida = jogoAtual.setupController.escolherMesaTransferencia();		 
		mesaEscolhida--;
		if(jogadorAtual.getTabuleiro().getMesas()[mesaEscolhida].getModuloJaIntegrado()==true)
		{
			jogoAtual.setupController.exibirMesaModulo();
			return jogadorAtual;
		}
		else
		{
			return jogoAtual.trocarModuloMesa(jogadorAtual,engenheiroTransferindo, mesaEscolhida);
		}
	}
		
	
	//#ifdef ConceptCard
	/**Utiliza carta conceito da m�o do jogador e insere efeito oriundo da respectiva carta no tabuleiro do jogador*/
	 @Override
	public Jogador inserirBeneficio(Jogo jogoAtual, Jogador jogadorAtual, CartaBonificacao cartaUtilizada) 
	{
		Jogador auxiliar = jogoAtual.usarConceito(jogadorAtual, cartaUtilizada);
		return auxiliar;
	}
	 //#endif
	
	/**Utiliza carta problema da m�o do jogadorAtual e insere efeito oriundo da respectiva carta no tabuleiro do jogadorAlvo*/
	 @Override
	public Jogador inserirProblema(Jogo jogoAtual, Jogador jogadorAtual, Jogador jogadorAlvo, CartaPenalizacao cartaUtilizada) 
	{
		Jogador auxiliar = jogoAtual.usarProblema(jogadorAtual, jogadorAlvo,cartaUtilizada);
		return auxiliar;
	}
	

}
