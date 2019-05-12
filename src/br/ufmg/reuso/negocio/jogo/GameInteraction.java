/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.jogo;

import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogador.Jogador;

/**
 * @author Michael David
 *
 */
public interface GameInteraction  
{
	
	/*************************************************************************************************************/
	/*************************************************************************************************************/
	/*************************************************************************************************************/
	/****   BOM, DESTE PONTO PRA BAIXO, ENTÃO, FAZ PARTE DA CAMADA DE NEGÓCIOS -> J�? NÃO É MAIS TESTE[MD]       **/
	/*************************************************************************************************************/
	/*************************************************************************************************************/
	/*************************************************************************************************************/
        
    
        /**joga dados do jogadorAtual, no jogoAtual. É retornado as novas carcateristicas do jogadorAtual*/
	public Jogador jogarDados(Jogo jogoAtual,Jogador jogador); 			
	  
	//vet tabuleiro oponente será de uso excluivo da GUI:troca a tela, habilita algumas funcionalidade e desabilita outras (não altera camada de negócios)
	/**public vodi verTabuleiro();*/
	/********************************************************************************************/
	
	
	/**Termina jogada do jogadorAtual*/
	public void terminarJogada(Jogador jogadorAtual);					
	
        
        /**Mostra cartao de projeto do jogo*/
	public void verProjeto(Jogo jogoAtual); 		
	
	
	
	/**retira as cartas do jogadorAtual e o retorna com características novas*/
	public Jogador descartarCartas(Jogo jogoAtual, Jogador jogadorAtual, Carta[] cartasDescartadas);
	 
	//metodo selecionar Carta será de uso excluivo da GUI, habilita algumas funcionalidade e desabilita outras (não altera camada de negócios) 
	/**public void selecionarCarta();*/ 
	/***************************************************************************/
	 
	/**retira carta de engenhero do tabuleiro do jogador*/
	public Jogador demitirEngenheiro(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroDemitido); 
	  
	
	//metodo selecionar engenheiro será de uso excluivo da GUI, habilita algumas funcionalidade e desabilita outras (não altera camada de negócios) 
	/**public void selecionarEng();*/ 
	/***************************************************************************/
	
        /**retira cartas de engenheiro da mão do jogador e as insere no tabuleiro*/
	public Jogador contratarEngenheiroI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroContratado);	
	
        /**Engenheiro produz artefato*/
	public Jogador produzirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroProduzindo);		
	  
        /**Engenheiro inspeciona artefato*/
	public Jogador inspecionarArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroInspecionando);	 
	
        /**Engenheiro corrige artefato com bug*/
	public Jogador corrigirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroCorrigindo); 
	
	/** Integra um conjunto de artefatos em módulo, conforme cartão de projeto.*/
	public Jogador integrarModuloI(Jogo jogoAtual, Jogador jogadorAtual,CartaEngenheiro engenheiroIntegrador, int mesaTrabalho); 
	
        /**transfere modulo integrado de uma mesa para outra mesa sem módulo integrado*/
	public Jogador tranferirModuloIntegrado(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroTransferindo);	
  	  
	/**public void escolherModulo();   método exclusivo da GUI*/
	 
	/**public void selecionarCarta2();	método exclusivo da GUI*/ 
	
	/**public void selecionarOponente();	método exclusivo da GUI*/

	
	//#ifdef ConceptCard
	/**Utiliza carta conceito da mão do jogador e insere efeito oriundo da respectiva carta no tabuleiro do jogador*/
	public Jogador inserirBeneficio(Jogo jogoAtual, Jogador jogadorAtual, CartaBonificacao cartaUtilizada);
	//#endif
	
	  
	/**Utiliza carta problema da mão do jogadorAtual e insere efeito oriundo da respectiva carta no tabuleiro do jogadorAlvo*/
	public Jogador inserirProblema(Jogo jogoAtual, Jogador jogadorAtual, Jogador jogadorAlvo, CartaPenalizacao cartaUtilizada); 
	  
	
}
