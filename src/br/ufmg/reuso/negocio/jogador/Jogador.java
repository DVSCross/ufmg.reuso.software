/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */


package br.ufmg.reuso.negocio.jogador;

/**
 * @author Michael David
 *
 */

import br.ufmg.reuso.negocio.carta.Carta;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.dado.Dado;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.tabuleiro.Tabuleiro;

public class Jogador 
{
        //numero maximo de cartas que o jogador pode ter em mÃ£os.
	public static final int NUMERO_MAX_CARTAS_MAO = 5;
        
	//contÃ©m o nome do jogador
        private String nome;	
        
	//contÃ©m o saldo que o jogador tem para utilizar (limite Ã© orcamento do projeto)
        private int saldo;														
	private Tabuleiro tabuleiro;
        
        //se true, jogador jogou dados, senÃ£o nao jogou
	private boolean dadoJogado; 											
	
        //conjunto de cartas na mao do jogador
	private Carta[] cartas = new Carta[NUMERO_MAX_CARTAS_MAO];				 
	
        //numero real de cartas em mÃ£os no decorrer do jogo
        private int numeroCartasMaoAtual;										
	
	
	public Jogador (String nomeJogador, int orcamentoInicial)
	{
                // inserindo nome de jogadores
		setNome(nomeJogador);												
		
                // inserindo saldo inicial do jogador que Ã© igual orcamento do projeto
                setSaldo(orcamentoInicial);
                
		// numero de cartas na mÃ£o inicial Ã© zero
                setNumeroCartasMaoAtual(0);
                
		//jogador ainda nÃ£o jogou dados
                setDadoJogado(false);												
		for (int i=0; i<NUMERO_MAX_CARTAS_MAO; i++)
		{
                        // iniciando como carta inexistente
			cartas[i] = null;												
		}
		
                // criando tabuleiro do jogador
		tabuleiro = new Tabuleiro();						
	}
	
	public void contratarEngenheiro(Carta novato, int posicaoMesa)
	{
                /** Utilizando uma verificaÃ§Ã£o se novato estÃ¡ instanciando uma carta de entenheiro*/
		if(novato instanceof CartaEngenheiro) 											
		{
	
			if(tabuleiro.getMesas()[posicaoMesa].getCartaMesa()!= null)
			{
				Jogo.getJogo().setupController.exibirExcessoPessoal();
			}
			
                        /** Verificando se nÃ£o hÃ¡ engenheiro na mesa, ou seja, se a mesa estÃ¡ vazia*/
			if(tabuleiro.getMesas()[posicaoMesa].getCartaMesa()==null)					
			{	
                            
                                /** se sim, acontece uma coreÃ§Ã£o (downcast)*/
				CartaEngenheiro Contratado = (CartaEngenheiro) novato;					
				
				if (getSaldo() < Contratado.getEngenheiro().getSalarioEngenheiro())
				{
					Jogo.getJogo().setupController.exibirFaltaDinheiro();
				}
                                
				/** Verificando se hÃ¡ saldo suficiente*/
				if (getSaldo() >= Contratado.getEngenheiro().getSalarioEngenheiro())									
				{
                                    
                                        /** atualizando saldo do jogador devido ao salario do engenheiro*/
					setSaldo(this.saldo - Contratado.getEngenheiro().getSalarioEngenheiro());			
					
                                        /** Contrata engenheiro*/
                                       tabuleiro.alocarMesa(Contratado,posicaoMesa);							


					
					for (int i=0;i<getCartas().length;i++)
					{
						if (getCartas()[i]==null)
							continue;
                                                
                                                /**Se a na mao de jogador e a carta de engenheeiro a ser contratado sÃ£o iguais*/
						if (getCartas()[i].getCodigoCarta().compareTo(novato.getCodigoCarta())==0)	
						{
                                                    
                                                        /**Retira-se a carta da mÃ£o do jogador, pois ela agora estÃ¡ no tabuleiro*/
							getCartas()[i]=null;											
							
                                                        /**Atualiza o nÃºmero de cartas na mao do jogador*/
                                                        setNumeroCartasMaoAtual(getNumeroCartasMaoAtual() -1);			
						}
							
					}
										
				}
				
			}
			
		}
	}
	
	public int analisarPontuacao()
	{
		int numberCards;
		numberCards = Dado.contarPontos();
		
		/**exibe a Gui mostrando pontos obtidos pelo jogador no lançamento de dados*/
		Jogo.getJogo().setupController.mostrarPontosObtidosInicial(numberCards);		
		
		if ((getNumeroCartasMaoAtual() + numberCards) <= NUMERO_MAX_CARTAS_MAO) {
			return numberCards;
		}
		else {		
                    
			/**exibe a GUI mostrando o numero de cartas recebidas respeito o limite de cartas na mao*/
		    Jogo.getJogo().setupController.mostrarNumberCardasDelivered(NUMERO_MAX_CARTAS_MAO - getNumeroCartasMaoAtual());
			return (NUMERO_MAX_CARTAS_MAO - getNumeroCartasMaoAtual());
		}
		
	}
	
	public void receberCarta(Carta cartaRecebida)
	{
		int i = 0;
		
                /**verificando se jÃ¡ existe carta na posiÃ§Ã£o i*/
		while (cartas[i]!= null)										
			i++;
		
                /**Se a posiÃ§Ã£o no vetor de cartas ultrapassar o nÃºmero de cartas limite, hÃ¡ erro*/
                if (i > NUMERO_MAX_CARTAS_MAO)									
		{
			System.exit(1);
		}
                
                /**jogador recebe a carta*/
		cartas[i]=cartaRecebida;										
		
                /**atualizando o nÃºmero de carta na mÃ£o do jogador*/
                setNumeroCartasMaoAtual(getNumeroCartasMaoAtual() +1);			
	}
	
	public void retirarCarta(Carta cartaRetirada)
	{
            
                /**percorrendo cartas na mao do jogador*/
		for(int i=0; i<cartas.length;i++)						
		{
			if (cartas[i]==null)
				continue;
                        
                        /**comparando a variÃ¡vel cÃ³digo das cartas, caso elas sejam iguais, retira-se a carta do jogador*/
			if(cartas[i].getCodigoCarta().compareTo(cartaRetirada.getCodigoCarta())==0)  
			{	
                            
                                /**carta do jogador retirada*/
				cartas[i]=null;			
				setNumeroCartasMaoAtual(getNumeroCartasMaoAtual() -1);
			
			}
		}
	}
	
	public boolean removerCarta(CartaEngenheiro engenheiroDemitido)
	{
            
                /**se true, significa que engenheiro foi demitido (ele nÃ£o trabalhou na rodada)*/ 
		if (tabuleiro.despedirEngenheiro(engenheiroDemitido) == true)			
		{	
			setSaldo(getSaldo()+engenheiroDemitido.getEngenheiro().getSalarioEngenheiro());
                        
                        /**se retorna true, significa que o jogo pode remover a carta para baralho auxiliar*/
			return true;														

		}
		
		return false;
	}
	
        //TODO usado sÃ³ pra teste
	public void mostrarCartaMao() 			
	{
             // printa cartas
	}
	
	public int contarModuloJaIntegrado()
	{
		int moduloJaIntegrado =0;
		for (int i=0;i<tabuleiro.getMesas().length;i++)
		{
			if(tabuleiro.getMesas()[i].getModuloJaIntegrado()==true)
				moduloJaIntegrado++;
		}
		
		return moduloJaIntegrado;
	}
	
	public Tabuleiro getTabuleiro() 
	{
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) 
	{
		this.tabuleiro = tabuleiro;
	}

	public int getNumeroCartasMaoAtual() 
	{
		return numeroCartasMaoAtual;
	}
	
	public void setNumeroCartasMaoAtual(int numeroCartasMao) 
	{
		this.numeroCartasMaoAtual = numeroCartasMao;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getSaldo() 
	{
		return saldo;
	}
	
	public void setSaldo(int saldo) 
	{
		this.saldo = saldo;
	}

	public Carta[] getCartas() 
	{
		return cartas;
	}

	public void setCartas(Carta[] cartas) 
	{
		this.cartas = cartas;
	}
	
	public boolean isDadoJogado() 
	{
		return dadoJogado;
	}

	public void setDadoJogado(boolean dadoJogado) 
	{
		this.dadoJogado = dadoJogado;
	}
	
}
