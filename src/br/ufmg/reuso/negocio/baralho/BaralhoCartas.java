/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.baralho;

/**
 * @author Michael David
 *
 */

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

import br.ufmg.reuso.dados.carta.RepositorioCarta;
import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.jogo.ModeGameConstants;

public class BaralhoCartas 
{
	private Carta[] baralho;
	private int numeroTotalCartas;										// contem o n?mero de cartas total do jogo 
	private int numeroTotalEngenheiro;
	private int numeroTotalProblemas;
	//#ifdef ConceptCard
	private int numeroTotalConceito;
	//#endif
	private int numeroCartasBaralhoAtual;								// contem o numero de cartas que o baralho tem no decorrer do jogo
	private int currentCard;											/** ?ndice da pr?xima carta a ser distribu?da durante o jogo.*/

	/**
	 * Reuso de Software 2016 - C?digo Adicionado
	 */
	private RepositorioCarta repositorio = new RepositorioCarta();

	public BaralhoCartas(String facilidade,
			//#ifdef ConceptCard
			int[] cartasConceito,
			//#endif
			int [] cartasProblema) {

		if(facilidade==Jogo.FACIL)
		{

		}

		if(facilidade==Jogo.MODERADO)
		{

		}

		if(facilidade==Jogo.DIFICIL)
		{	
			
			// #ifdef LocalConceptCard
			CartaBonificacao [] cartaConceito;					//vetor que aloja cartas conceito do jogo
			cartaConceito = inicializarCartasConceito(ModeGameConstants.PATH_CARTA_CONCEITO_DIFICIL,cartasConceito);
			// #endif
			
			// #ifdef OnlineConceptCard
//@			CartaBonificacao [] cartaConceito;					//vetor que aloja cartas conceito do jogo
//@			cartaConceito = inicializarCartasConceito(ModeGameConstants.PATH_CARTA_CONCEITO_ONLINE,cartasConceito);
			// #endif		
			
			// #ifdef LocalProblemCard
//@			CartaPenalizacao[] cartaProblema;					//vetor de todas as cartas problema
//@			cartaProblema = inicializarCartasProblemas(ModeGameConstants.PATH_CARTA_PROBLEMA_DIFICIL,cartasProblema);
			// #endif
			
			// #ifdef OnlineProblemCard
			CartaPenalizacao[] cartaProblema;					//vetor de todas as cartas problema
			cartaProblema = inicializarCartasProblemas(ModeGameConstants.PATH_CARTA_PROBLEMA_ONLINE,cartasProblema);
			// #endif			
			
			// #ifdef LocalSoftwareEngineerCard
			CartaEngenheiro[] cartaengenheiro;			//vetor de todas as cartas de engenheiro
			cartaengenheiro = inicializarCartasEngenheiro(ModeGameConstants.PATH_CARTA_ENGENHEIRO_DIFICIL);
			// #endif
			
			// #ifdef OnlineSoftwareEngineerCard
//@			CartaEngenheiro[] cartaEngenheiro;			//vetor de todas as cartas de engenheiro
//@			cartaEngenheiro = inicializarCartasEngenheiro(ModeGameConstants.PATH_CARTA_ENGENHEIRO_ONLINE);
			// #endif

			this.currentCard=0;																				/**configura currentCard como primeira carta retirada do baralho ser na posicao 0*/
			// contem o n?mero de cartas total do jogo = soma de cartas de: conceito, engenheiro e problemas
			setNumeroTotalCartas(getNumeroTotalProblemas()
					//#ifdef ConceptCard
					+ getNumeroTotalConceito() 
					//#endif
					+ getNumeroTotalEngenheiro());
			
			baralho = new Carta[getNumeroTotalCartas()];													//contruindo baralho com n?mero de cartas na pasta correspondente ao tipo de jogo
			setNumeroCartasBaralhoAtual(getNumeroTotalCartas());											//numero de cartas no baralho inicialmente ? igual ao total de cartas no jogo

			for (int i=0,j=0,k=0;i<baralho.length;i++)														//POLIMORFISMO DE CARTAS NUM VETOR
			{

				if (i<getNumeroTotalEngenheiro())
					baralho[i]=cartaengenheiro[i];															//preenchendo as primeiras posi??es com cartas de engenheiro de software 
				else
				{
					//#ifdef ConceptCard
					if(j<getNumeroTotalConceito())
					{
						baralho[i]=cartaConceito[j];													//preenchendo a parte do meio do baralho com cartas conceito
						j++;
					}
					else
					{
					//#endif
						baralho[i]=cartaProblema[k];													//preenchendo a parte final do baralho com cartas de problema
						k++;
					//#ifdef ConceptCard
					}
					//#endif
				}
			}
		}

		//mostrarBaralho(); //-> ok 
	}

	public BaralhoCartas(BaralhoCartas baralhoInicial)					/**constroi o baralho tendo como parametro outro baralho*/
	{
		setNumeroTotalCartas(baralhoInicial.getNumeroTotalCartas());	/**o baralho constru?do tem o mesmo n?mero de cartas do baralhoInicial*/
		setNumeroTotalEngenheiro(0);
		setNumeroTotalProblemas(0);
		//#ifdef ConceptCard
		setNumeroTotalConceito(0);
		//#endif
		setNumeroCartasBaralhoAtual(0);									/**o baralho n?o cont?m nenhuma carta quando constru?do*/
		this.currentCard = 0;
		this.baralho = new Carta [getNumeroTotalCartas()];
		for (int i=0; i<baralho.length; i++)
			baralho[i]=null;											/**logo, n?o existe cartas no baralho */
	}

	//#ifdef ConceptCard
	public CartaBonificacao[] inicializarCartasConceito(String dificuldade, int[] cartasConceitoSelecionadas)
	{
		/**
		 * Reuso de Software 2016 - C?digo Modificado
		 */
		String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(dificuldade);	
                
		/**preenhendo um vetor de string com nome dos arquivos do diretorio*/
		ArrayList <String> somenteArquivosProperties = new ArrayList <String>();;
		for (int i=0;i<arquivosDiretorio.length;i++)
		{       
                        /**testando se arquivo do diret?rio ? .properties e se carta foi selecionada*/
			if((arquivosDiretorio[i].endsWith(".properties"))&&(selecionarCartaConceito(cartasConceitoSelecionadas,arquivosDiretorio[i])==true))
				
                            /**adciona arquivo ? lista de array de arquivos properties conforme cartas selecionadas para o jogo*/
                            somenteArquivosProperties.add(arquivosDiretorio[i]);			
		}

                /**numero de cartas conceito total que o baralho ter?*/
		setNumeroTotalConceito(somenteArquivosProperties.size());		
                
                /**vetor que aloja cartas conceito do jogo*/
		CartaBonificacao [] cartaconceito = new CartaBonificacao[getNumeroTotalConceito()];	

                /**ir? abrir todos os arquivos e extrair dados deles*/
		for(int i=0;i<somenteArquivosProperties.size();i++)								
		{

			try
			{
				/**construindo a carta com dados do arquivo cujo nome est? na posicao i do vetor de arquivos do diretorio*/
				/**
				 * Reuso de Software 2016 - C?digo Modificado
				 */
				cartaconceito[i] = repositorio.obterCartaConceito(dificuldade + File.separator + somenteArquivosProperties.get(i));; 	


			}
                        
                        /**se os dados estiverem fora do formato ou se n?o haver mais dados para sa?da, h? problema*/
                        /**jogo termina sem ?xito devido ao problema*/
			catch (NoSuchElementException noSuchElementException){		
				System.exit(1);											
			}
		}
		return cartaconceito;
	}
	//#endif

	//#ifdef ConceptCard
	public boolean selecionarCartaConceito  (int [] cartasConceitoSelecionadas, String cartaAtual)
	{
		for (int i=0;i<cartasConceitoSelecionadas.length;i++)
		{
			if(cartasConceitoSelecionadas[i]==ModeGameConstants.ALL_CARDS_CONCEITO)
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_CODIGO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_CODIGO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_COMUNICACAO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_COMUNICACAO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_DESENHO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_DESENHO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_GERENCIA)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_GERENCIA)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_RECURSOS_HUMANOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_RELACIONAMENTO_HUMANO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_REQUISITOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_REQUISITOS)))
				return true;
		}
		return false;
	}
	//#endif

	public CartaPenalizacao[] inicializarCartasProblemas(String dificuldade,int [] cartasProblemaSelecionadas)
	{
		/**
		 * Reuso de Software 2016 - C?digo Modificado
		 */
		String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(dificuldade);							
                
                //preenhendo um vetor de string com nome dos arquivos do diretorio
		ArrayList <String> somenteArquivosProperties = new ArrayList <String>();;
		for (int i=0;i<arquivosDiretorio.length;i++)
		{
                        /**testando se arquivo do diret?rio ? .properties e se carta foi selecionada*/
			if((arquivosDiretorio[i].endsWith(".properties"))&&(selecionarCartaProblema(cartasProblemaSelecionadas,arquivosDiretorio[i])==true))
                                
                                /**adciona arquivo ? lista de array de arquivos properties conforme cartas selecionadas para o jogo*/
				somenteArquivosProperties.add(arquivosDiretorio[i]);			
		}

                 /**numero de cartas problema total que o baralho ter?*/
		setNumeroTotalProblemas(somenteArquivosProperties.size());				
                
                /**vetor que aloja cartas problema do jogo*/
		CartaPenalizacao [] cartaproblema = new CartaPenalizacao[getNumeroTotalProblemas()];	

                /**ir? abrir todos os arquivos e extrair dados deles*/
		for(int i=0;i<somenteArquivosProperties.size();i++)								
		{
			try
			{
				/**
				 * Reuso de Software 2016 - C?digo Modificado
				 */
				/**construindo a carta com dados do arquivo cujo nome est? na posicao i do vetor de arquivos do diretorio*/	
				cartaproblema[i] = repositorio.obterCartaPenalizacao(dificuldade + File.separator + somenteArquivosProperties.get(i));
			}
                        
                        /**se os dados estiverem fora do formato ou se n?o haver mais dados para sa?da, h? problema*/
                        /**jogo termina sem ?xito devido ao problema*/
			catch (NoSuchElementException noSuchElementException)		
			{
				System.exit(1);											
			}
		}
		return cartaproblema;
	}

	public boolean selecionarCartaProblema  (int [] cartasProblemaSelecionadas, String cartaAtual)
	{
		for (int i=0;i<cartasProblemaSelecionadas.length;i++)
		{
			if(cartasProblemaSelecionadas[i]==ModeGameConstants.ALL_CARDS_PROBLEMA)
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_CODIGO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_CODIGO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_COMUNICACAO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_COMUNICACAO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_DESENHO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_DESENHO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_GERENCIA)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_GERENCIA)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_RECURSOS_HUMANOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_RELACIONAMENTO_HUMANO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_REQUISITOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_REQUISITOS)))
				return true;
		}
		return false;
	}

	public CartaEngenheiro[] inicializarCartasEngenheiro(String dificuldade)
	{
		/**
		 * Reuso de Software 2016 - C?digo Modificado
		 */
		String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(dificuldade);	

		ArrayList <String> somenteArquivosProperties = new ArrayList <String>();;
		for (int i=0;i<arquivosDiretorio.length;i++)
		{
                    
                        /**testando se arquivo do diret?rio ? .properties*/
			if(arquivosDiretorio[i].endsWith(".properties"))
                            
                                /**adciona arquivo ? lista de array de arquivos properties*/
				somenteArquivosProperties.add(arquivosDiretorio[i]);			
		}
                
                /**numero de cartas de engenheiros total que o baralho ter?*/
		setNumeroTotalEngenheiro(somenteArquivosProperties.size());
                
                /**vetor de todas as cartas de engenheiro*/
		CartaEngenheiro[] cartaengenheiro = new CartaEngenheiro[getNumeroTotalEngenheiro()];			
                
                /**ir? abrir todos os arquivos e extrair dados deles*/
		for(int i=0;i<somenteArquivosProperties.size();i++)								
		{
			/**
			 * Reuso de Software 2016 - C?digo Modificado
			 */
			try
			{
                            
                                /**construindo a carta com dados do arquivo cujo nome est? na posicao i do vetor de arquivos do diretorio*/
				cartaengenheiro[i]= repositorio.obterCartaEngenheiro(dificuldade + File.separator + somenteArquivosProperties.get(i)); 	
			}
                        
                        /**se os dados estiverem fora do formato ou se n?o haver mais dados para sa?da, h? problema*/
                        /**jogo termina sem ?xito devido ao problema*/
			catch (NoSuchElementException noSuchElementException)		
			{
				System.exit(1);											
			}
		}										
		return cartaengenheiro;
	}
        
        //vai deixar as cartas de engenheiro retiradas do baralho nas ultimas posi??es e embaralhar o baralho restante.
	public void embaralharInicial()	
	{       
                //ser? a posicao da ultima carta do baralho n?o null
		int ultimaCartaValida = getNumeroTotalCartas()-1;
                
                //for precisa ser rodado at? o fim das cartas de engenheiro no baralho
		for (int i=0;i<getNumeroTotalEngenheiro(); i++)					
		{
                        //caso a carta seja nula
			if (baralho[i]==null)										
			{
                            
                                //a ultima carta (existente) do baralho ocupa a posicao desta nula
				baralho[i]=baralho[ultimaCartaValida];
                                
                                //a carta nula vai ocupar o lugar da ?ltima carta existente
				baralho[ultimaCartaValida]=null;
                                
                                //a utima carta v?lida tem posicao decrescida de 1
				ultimaCartaValida--;									
			}
                        
                //neste ponto todas as cartas null est?o no final do baralho
		}																

		embaralhar();

	}

	public void embaralhar()
	{
		Random sorteio = new Random();
		for (int primeiro=0;primeiro<getNumeroCartasBaralhoAtual();primeiro++)						//embaralha cartas restantes, excluindo as cartas inexistentes
		{
			int segundo = sorteio.nextInt(getNumeroCartasBaralhoAtual());
			Carta temporaria = baralho[primeiro];
			baralho[primeiro]=baralho[segundo];
			baralho[segundo]=temporaria;
		}
	}

        //TODO METODO DE TESTE -> EXCUIR DEPOIS
	public void mostrarBaralho()					
	{		
		for (int i=0;i<getNumeroCartasBaralhoAtual();i++)
		{
			//System.out.printf("Carta %d:",i+1); //->ok
			baralho[i].mostrarCarta();
		}	
	}

	public Carta darCartaInicial(int posicaoCarta)
	{
		if (baralho[posicaoCarta]!=null)
		{
			setNumeroCartasBaralhoAtual(getNumeroCartasBaralhoAtual()-1);
			Carta temporaria = baralho[posicaoCarta];
			baralho[posicaoCarta]=null;

			return temporaria;
		}
		else
			return null;
	}
        
        /**Distribui uma carta*/
	public Carta darCarta()															
	{
            
                /**Determina se ainda h? carta a ser distribu?da*/
		if (baralho[currentCard]!=null)												
		{
                    
                        /**Diminui o n?mero de cartas que o baralho cont?m*/
			setNumeroCartasBaralhoAtual(getNumeroCartasBaralhoAtual()-1);			
			Carta temporaria = baralho[currentCard];
			baralho[currentCard]=null;
                        
                        /**Incrementa ?ndice da pr?xima carta a ser distribu?da*/
			this.currentCard++;														
			return temporaria;
		}
		else
                        
                        /**Retorna nulo para indicar que baralho est? vazio*/
			return null;															
	}

	public void recolherCarta(Carta cartaDevolvida)
	{
                
                /**colocando carta no baralho*/
		baralho[getNumeroCartasBaralhoAtual()]=cartaDevolvida;
                
                /**adicionando carta ao baralho que recolhe carta*/
		setNumeroCartasBaralhoAtual(getNumeroCartasBaralhoAtual() + 1);				
	}






	public int getNumeroTotalCartas() 
	{
		return numeroTotalCartas;
	}


	public void setNumeroTotalCartas(int numeroTotalCartas) 
	{
		this.numeroTotalCartas = numeroTotalCartas;
	}


	public int getNumeroTotalEngenheiro() 
	{
		return numeroTotalEngenheiro;
	}


	public void setNumeroTotalEngenheiro(int numeroTotalEngenheiro) 
	{
		this.numeroTotalEngenheiro = numeroTotalEngenheiro;
	}


	public int getNumeroTotalProblemas() 
	{
		return numeroTotalProblemas;
	}


	public void setNumeroTotalProblemas(int numeroTotalProblemas) 
	{
		this.numeroTotalProblemas = numeroTotalProblemas;
	}


	//#ifdef ConceptCard
	public int getNumeroTotalConceito()
	{
		return numeroTotalConceito;
	}
	//#endif


	//#ifdef ConceptCard
	public void setNumeroTotalConceito(int numeroTotalConceito)
	{
		this.numeroTotalConceito = numeroTotalConceito;
	}
	//#endif


	public int getNumeroCartasBaralhoAtual() 
	{
		return numeroCartasBaralhoAtual;
	}

	public void setNumeroCartasBaralhoAtual(int numeroCartasBaralho) 
	{
		this.numeroCartasBaralhoAtual = numeroCartasBaralho;
	}

	public int getCurrentCard() 
	{
		return currentCard;
	}

	public void setCurrentCard(int currentCard) 
	{
		this.currentCard = currentCard;
	}







}