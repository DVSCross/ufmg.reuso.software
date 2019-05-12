/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.mesa;

/**
 * @author Michael David
 *
 */

import java.util.ArrayList;

import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosBons;
import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosRuins;
import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.jogo.Jogo;

public class Mesa 
{
	public static final int ARTEFATOS_BONS = 0;
	public static final int ARTEFATOS_RUINS = 1;	
	
	public static final int QUANTIDADE_TIPOS_DE_ARTEFATOS = 5;
	public static final int ARTEFATOS_AJUDA = 0;
	public static final int ARTEFATOS_CODIGO = 1;
	public static final int ARTEFATOS_DESENHO = 2;
	public static final int ARTEFATOS_RASTROS = 3;
	public static final int ARTEFATOS_REQUISITOS = 4;

	private CartaEngenheiro cartaMesa;
        
        /** variavel que mostra se ha modulo integrado na mesa ou nao*/
	private boolean moduloJaIntegrado;	
        
        /** especifica qual modulo integrado do projeto a mesa contem (de 0 ate (tamanho do projeto-1)*/
	private int especificacaoModuloIntegrado;
        
        /** vetor de ArrayList contendo o modulo da integracao*/
	private ArrayList <Artefato>[] moduloIntegrado;	
	private ArrayList <Artefato> ajudas;
	private ArrayList <Artefato> codigos;
	private ArrayList <Artefato> desenhos;
	private ArrayList <Artefato> rastros;
	private ArrayList <Artefato> requisitos;

	/*----------------------EFEITOS DA CARTA CONCEITO PERMANENTES---------------------------------*/
	
        /**contem um inteiro com efeito na maturidade do engenheiro que ocupa a mesa*/
        private int efeitoAumentarMaturidadeEngenheiro; 
        
        /**contem um inteiro com efeito na habilidade do engenheiro que ocupa a mesa*/
	private int efeitoAumentarHabilidadeEngenheiro; 
        
         /**contem o efeito de ter o modulo desta mesa neutralizado na fase de validacao*/
	private boolean efeitoModuloIntegradoNeutralizado;
	
	/*--------------------EFEITOS DA CARTA PROBLEMA PERMANENTES-----------------------------------*/
        
        /**contem o efeito de aumentar pontos de habilidade necessarios dos engenheiros para dar ou receber ajuda*/
	private int efeitoPenalizarAjuda;				
	
	
	
	/*--------------------EFEITOS TEMPORARIOS DA CARTA PROBLEMA-----------------------------------*/
	/**contem o efeito temporario de deixar todos engenheiros sem produzir artefatos*/
	private int duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts; //TODO efeito Temporario
	
	/**contem o efeito temporario de deixar todos engenheiros sem inspecionar artefatos*/
	private int duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts; //TODO efeito Temporario
	
	/**contem o efeito temporario de deixar todos engenheiros sem corrigir artefatos*/
	private int duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts; //TODO efeito Temporario
	
	/**contem o efeito temporario de o engenheiro produzir somente artefatos cinzas*/
	private int duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts;
	
	/**contem o efeito temporario de o engenheiro produzir somente artefatos brancos*/
	private int duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts;
	
	/*---------------------------------------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public Mesa ()
	{
                /**nao ha efeito algum no inicio do jogo*/
		efeitoAumentarMaturidadeEngenheiro = 0;     		
		efeitoAumentarHabilidadeEngenheiro = 0;				
		efeitoModuloIntegradoNeutralizado = false;			
				
		duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts = 0;
		duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts = 0;
		duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts = 0;
		efeitoPenalizarAjuda=0;
		duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts = 0;
		duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts = 0;
		
		
		cartaMesa = null;
		ajudas = new ArrayList <Artefato>();
		codigos = new ArrayList <Artefato>();
		desenhos = new ArrayList <Artefato>();
		rastros = new ArrayList <Artefato>();
		requisitos = new ArrayList <Artefato>();
		moduloJaIntegrado = false;
                
                /** mesa ainda nao contem modulo integrado*/
		especificacaoModuloIntegrado=-1;				
		
		moduloIntegrado= new ArrayList[5]; 				
	}
	
	
	public CartaEngenheiro getCartaMesa()
	{
		return cartaMesa;
	}

	public void setCartaMesa(CartaEngenheiro cartaMesa) 
	{
		this.cartaMesa = cartaMesa;
	}

	public boolean getModuloJaIntegrado() 
	{
		return moduloJaIntegrado;
	}

	public void setModuloJaIntegrado(boolean moduloJaIntegrado) 
	{
		this.moduloJaIntegrado = moduloJaIntegrado;
	}

	public ArrayList<Artefato> getAjudas() 
	{
		return ajudas;
	}

	public void setAjudas(ArrayList<Artefato> ajudas) 
	{
		this.ajudas = ajudas;
	}

	public ArrayList<Artefato> getCodigos() 
	{
		return codigos;
	}

	public void setCodigos(ArrayList<Artefato> codigos)
	{
		this.codigos = codigos;
	}

	public ArrayList<Artefato> getDesenhos()
	{
		return desenhos;
	}

	public void setDesenhos(ArrayList<Artefato> desenhos)
	{
		this.desenhos = desenhos;
	}

	public ArrayList<Artefato> getRastros() 
	{
		return rastros;
	}

	public void setRastros(ArrayList<Artefato> rastros)
	{
		this.rastros = rastros;
	}

	public ArrayList<Artefato> getRequisitos()
	{
		return requisitos;
	}

	public void setRequisitos(ArrayList<Artefato> requisitos) 
	{
		this.requisitos = requisitos;
	}

	public ArrayList<Artefato>[] getModuloIntegrado() 
	{
		return moduloIntegrado;
	}

	public void setModuloIntegrado(ArrayList<Artefato>[] moduloIntegrado) 
	{
		this.moduloIntegrado = moduloIntegrado;
	}

	public int getEspecificacaoModuloIntegrado() 
	{
		return especificacaoModuloIntegrado;
	}

	public void setEspecificacaoModuloIntegrado(int especificacaoModuloIntegrado) 
	{
		this.especificacaoModuloIntegrado = especificacaoModuloIntegrado;
	}

	public int getEfeitoAumentarMaturidadeEngenheiro()
	{
		return efeitoAumentarMaturidadeEngenheiro;
	}

	public void setEfeitoAumentarMaturidadeEngenheiro ( int efeitoAumentarMaturidadeEngenheiro)
	{
		this.efeitoAumentarMaturidadeEngenheiro = efeitoAumentarMaturidadeEngenheiro;
	}

	public int getEfeitoAumentarHabilidadeEngenheiro() 
	{
		return efeitoAumentarHabilidadeEngenheiro;
	}

	public void setEfeitoAumentarHabilidadeEngenheiro
	(
		int efeitoAumentarHabilidadeEngenheiro) {this.efeitoAumentarHabilidadeEngenheiro = efeitoAumentarHabilidadeEngenheiro;
	}

	public boolean isEfeitoModuloIntegradoNeutralizado() 
	{
		return efeitoModuloIntegradoNeutralizado;
	}

	public void setEfeitoModuloIntegradoNeutralizado (boolean efeitoModuloIntegradoNeutralizado) 
	{
		this.efeitoModuloIntegradoNeutralizado = efeitoModuloIntegradoNeutralizado;
	}

	public int getDuracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts() 
	{
		return duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts(int duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts) 
	{
		this.duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts = duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts;
	}

	public int getDuracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts()
	{
		return duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts(int duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts) 
	{
		this.duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts = duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts;
	}

	public int getDuracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts() 
	{
		return duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts(int duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts)
	{
		this.duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts = duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts;
	}

	public int getEfeitoPenalizarAjuda()
	{
		return efeitoPenalizarAjuda;
	}

	public void setEfeitoPenalizarAjuda(int efeitoPenalizarAjuda) 
	{
		this.efeitoPenalizarAjuda = efeitoPenalizarAjuda;
	}

	public int getDuracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts() 
	{
		return duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts(int duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts) 
	{
		this.duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts = duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts;
	}

	public int getDuracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts() 
	{
		return duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts(int duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts)
	{
		this.duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts = duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts;
	}
	
	/**
	 * Virar artefatos = Inspecionar artefatos
	 *  
	 * @param pedido
	 * @param ArtefatosB
	 * @param ArtefatosR
	 */
	public void virarArtefatos(Modulo [] pedido, BaralhoArtefatosBons[] ArtefatosB,BaralhoArtefatosRuins[] ArtefatosR)
	{
		
		if(pedido[ARTEFATOS_BONS].getAjudas()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getAjudas();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((ajudas.get(j).inspected() == true)||(ajudas.get(j).isPoorQuality()== true))
					j++;
				ajudas.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getCodigos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getCodigos();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((codigos.get(j).inspected() == true)||(codigos.get(j).isPoorQuality()== true))
					j++; 
				codigos.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getDesenhos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getDesenhos();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((desenhos.get(j).inspected() == true)||(desenhos.get(j).isPoorQuality()== true))
					j++; 
				desenhos.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getRastros()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getRastros();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((rastros.get(j).inspected() == true)||(rastros.get(j).isPoorQuality()== true))
					j++; 
				rastros.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getRequisitos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getRequisitos();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((requisitos.get(j).inspected() == true)||(requisitos.get(j).isPoorQuality()== true))
					j++; 
				requisitos.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getAjudas()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getAjudas();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((ajudas.get(j).inspected() == true)||(ajudas.get(j).isPoorQuality()== false))
					j++; 
				ajudas.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getCodigos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getCodigos();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((codigos.get(j).inspected() == true)||(codigos.get(j).isPoorQuality()== false))
					j++; 
				codigos.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getDesenhos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getDesenhos();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((desenhos.get(j).inspected() == true)||(desenhos.get(j).isPoorQuality()== false))
					j++; 
				desenhos.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getRastros()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getRastros();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((rastros.get(j).inspected() == true)||(rastros.get(j).isPoorQuality()== false))
					j++; 
				rastros.get(j).setArtefatoInspecionado(true);
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getRequisitos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getRequisitos();i++)
			{
				/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
				while((requisitos.get(j).inspected() == true)||(requisitos.get(j).isPoorQuality()== false))
                                    
                                         // TODO lancar excecao em caso de nao haver artefatos a serem virados
					j++;
				requisitos.get(j).setArtefatoInspecionado(true);
			}
		}
		
		for (int i=0;i<ajudas.size();i++)			
				ajudas.get(i).mostrarArtefato();	
		
		for (int i=0;i<codigos.size();i++)			
				codigos.get(i).mostrarArtefato();	
				
		for (int i=0;i<desenhos.size();i++)			
				desenhos.get(i).mostrarArtefato();	
				
		for (int i=0;i<rastros.size();i++)			
				rastros.get(i).mostrarArtefato();	
				
		for (int i=0;i<requisitos.size();i++)			
				requisitos.get(i).mostrarArtefato();	
	}

	public void trocarArtefatos(Modulo [] pedido, BaralhoArtefatosBons[] ArtefatosB,BaralhoArtefatosRuins[] ArtefatosR)
	{
		if(pedido[ARTEFATOS_BONS].getAjudas()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getAjudas();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser ruim, procura proximo artefato*/
				while((ajudas.get(j).inspected() == false)||(ajudas.get(j).isBug()==false)||(ajudas.get(j).isPoorQuality()== true))
					j++;
				Artefato temporario=ajudas.get(j);
				ArtefatosB[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				ajudas.remove(j);													
				
				ajudas.add(ArtefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(ArtefatosB);
				}
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getCodigos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getCodigos();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser ruim, procura proximo artefato*/
				while((codigos.get(j).inspected() == false)||(codigos.get(j).isBug()==false)||(codigos.get(j).isPoorQuality()== true))
					j++;
				Artefato temporario=codigos.get(j);
				ArtefatosB[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				codigos.remove(j);													
				
				codigos.add(ArtefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(ArtefatosB);
				}
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getDesenhos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getDesenhos();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser ruim, procura proximo artefato*/
				while((desenhos.get(j).inspected() == false)||(desenhos.get(j).isBug()==false)||(desenhos.get(j).isPoorQuality()== true))
					j++;
				Artefato temporario=desenhos.get(j);
				ArtefatosB[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				desenhos.remove(j);													
				
				desenhos.add(ArtefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(ArtefatosB);
				}
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getRastros()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getRastros();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser ruim, procura proximo artefato*/
				while((rastros.get(j).inspected() == false)||(rastros.get(j).isBug()==false)||(rastros.get(j).isPoorQuality()== true))
					j++;
				Artefato temporario=rastros.get(j);
				ArtefatosB[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				rastros.remove(j);													
				
				rastros.add(ArtefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(ArtefatosB);
				}
			}
		}
		
		if(pedido[ARTEFATOS_BONS].getRequisitos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_BONS].getRequisitos();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser ruim, procura proximo artefato*/
				while((requisitos.get(j).inspected() == false)||(requisitos.get(j).isBug()==false)||(requisitos.get(j).isPoorQuality()== true))
					j++;
				Artefato temporario=requisitos.get(j);
				ArtefatosB[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				requisitos.remove(j);													
				
				requisitos.add(ArtefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(ArtefatosB);
				}
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getAjudas()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getAjudas();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser bom, procura proximo artefato*/
				while((ajudas.get(j).inspected() == false)||(ajudas.get(j).isBug()==false)||(ajudas.get(j).isPoorQuality()== false))
					j++;
				Artefato temporario=ajudas.get(j);
				ArtefatosR[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				ajudas.remove(j);													
				
				ajudas.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getCodigos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getCodigos();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser bom, procura proximo artefato*/
				while((codigos.get(j).inspected() == false)||(codigos.get(j).isBug()==false)||(codigos.get(j).isPoorQuality()== false))
					j++;
				Artefato temporario=codigos.get(j);
				ArtefatosR[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				codigos.remove(j);													
				
				codigos.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getDesenhos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getDesenhos();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser bom, procura proximo artefato*/
				while((desenhos.get(j).inspected() == false)||(desenhos.get(j).isBug()==false)||(desenhos.get(j).isPoorQuality()== false))
					j++;
				Artefato temporario=desenhos.get(j);
				ArtefatosR[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				desenhos.remove(j);													
				
				desenhos.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getRastros()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getRastros();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser bom, procura proximo artefato*/
				while((rastros.get(j).inspected() == false)||(rastros.get(j).isBug()==false)||(rastros.get(j).isPoorQuality()== false))
					j++;
				Artefato temporario=rastros.get(j);
				ArtefatosR[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
				rastros.remove(j);													
				
				rastros.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}
		
		if(pedido[ARTEFATOS_RUINS].getRequisitos()>0)
		{
			int j=0;
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getRequisitos();i++)
			{
				/**Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser bom, procura proximo artefato*/
				while((requisitos.get(j).inspected() == false)||(requisitos.get(j).isBug()==false)||(requisitos.get(j).isPoorQuality()== false))
					j++;
                                
                                /**colocando artefato descartado no baralho auxiliar*/
				Artefato temporario=requisitos.get(j);
				ArtefatosR[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario);		
				
                                
                                /**removendo artefato descartado do tabuleiro do jogador para troca-lo por outro*/
				requisitos.remove(j);													
				
                                
                                /**jogador recebe novo artefato do mesmo tipo, logo houve uma troca de artefatos*/
				requisitos.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());	
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}	

		for (int i=0;i<ajudas.size();i++)			
				ajudas.get(i).mostrarArtefato();	

		for (int i=0;i<codigos.size();i++)			
				codigos.get(i).mostrarArtefato();	
		
		for (int i=0;i<desenhos.size();i++)			
				desenhos.get(i).mostrarArtefato();	
		
		for (int i=0;i<rastros.size();i++)			
				rastros.get(i).mostrarArtefato();	
		
		for (int i=0;i<requisitos.size();i++)			
				requisitos.get(i).mostrarArtefato();	
	}
	
	public void trocarBaralhoArtefatosBons(BaralhoArtefatosBons[] artefatosB)		
	{
		BaralhoArtefatosBons temporario = artefatosB[Jogo.BARALHO_PRINCIPAL];
		artefatosB[Jogo.BARALHO_AUXILIAR].embaralhar();								
		artefatosB[Jogo.BARALHO_PRINCIPAL] = artefatosB[Jogo.BARALHO_AUXILIAR];
		artefatosB[Jogo.BARALHO_AUXILIAR] = temporario;
		artefatosB[Jogo.BARALHO_AUXILIAR].setCurrentArtifact(0);					
	}
	
        /**troca o baralho principal pelo auxiliar*/
	public void trocarBaralhoArtefatosRuins(BaralhoArtefatosRuins[] artefatosR)		
	{
		BaralhoArtefatosRuins temporario = artefatosR[Jogo.BARALHO_PRINCIPAL];
                
                /**embaralhando as cartas que foram retiradas*/
		artefatosR[Jogo.BARALHO_AUXILIAR].embaralhar();								
		artefatosR[Jogo.BARALHO_PRINCIPAL] = artefatosR[Jogo.BARALHO_AUXILIAR];
		artefatosR[Jogo.BARALHO_AUXILIAR] = temporario;
                
                /**o novo baralho auxiliar tem o indice retornada para zero*/
		artefatosR[Jogo.BARALHO_AUXILIAR].setCurrentArtifact(0);					
	}
	
	/** calcula quantos artefatos nao inspecionados um ArrayList contem.*/
	public int somarArtefatosNotInspecionados (ArrayList <Artefato> arrayArtefatos)
	{
		int contador = 0;
		for (int i=0;i<arrayArtefatos.size();i++)
		{	
			if (arrayArtefatos.get(i).inspected() == true)			
				continue;
			contador++;
		}
		return contador;
	}
	
	/** calcula quantos artefatos que contem bug estao inspecionados em um ArrayList.*/
	public int somarArtefatosInspecionadosBug (ArrayList <Artefato> arrayArtefatos)
	{
		int contador = 0;
		for (int i=0;i<arrayArtefatos.size();i++)
		{	
			if (arrayArtefatos.get(i).inspected() == false) 
				continue;
			if((arrayArtefatos.get(i).inspected() == true) &&(arrayArtefatos.get(i).isBug()==false)) 
				continue;
			contador++;
		}
		return contador;
	}
	
	public int[] somarArtefatosNotInspecionadosSeparados(ArrayList <Artefato> arrayArtefatos)
	{
		int[] artefatosSeparados = new int[2];
		int contadorArtefatosBons = 0;
		int contadorArtefatosRuins = 0;
		for (int i=0;i<arrayArtefatos.size();i++)
		{	
                        /** se artefato foi inspecionado, pula iteracao*/
			if (arrayArtefatos.get(i).inspected() == true)			
				continue;
			else
			{
                                /**se artefato e ruim*/
				if(arrayArtefatos.get(i).isPoorQuality()==true)		
				{
					contadorArtefatosRuins++;
				}
				else
				{
					contadorArtefatosBons++;
				}
			}
		}
		artefatosSeparados[ARTEFATOS_BONS]=contadorArtefatosBons;
		artefatosSeparados[ARTEFATOS_RUINS]=contadorArtefatosRuins;

		return artefatosSeparados;
		
	}
	
	public int[] somarArtefatosInspecionadosBugSeparados (ArrayList <Artefato> arrayArtefatos)
	{
		int[] artefatosSeparados = new int[2];
		int contadorArtefatosBons = 0;
		int contadorArtefatosRuins = 0;
		for (int i=0;i<arrayArtefatos.size();i++)
		{	
                        /**se artefato nao foi inspecionado, pula iteracao*/
			if (arrayArtefatos.get(i).inspected() == false) 
				continue;
                        
                        /** se artefato foi inspecionado e nao contem bug, pula iteracao*/
			if((arrayArtefatos.get(i).inspected() == true) &&(arrayArtefatos.get(i).isBug()==false)) 
				continue;
			if(arrayArtefatos.get(i).isPoorQuality()==true)
				contadorArtefatosRuins++;
			else
				contadorArtefatosBons++;
		}
		artefatosSeparados[ARTEFATOS_BONS]=contadorArtefatosBons;
		artefatosSeparados[ARTEFATOS_RUINS]=contadorArtefatosRuins;

		return artefatosSeparados;
	}
	
	public void receberArtefatos(Modulo [] pedido, BaralhoArtefatosBons[] artefatosB,BaralhoArtefatosRuins[] ArtefatosR)
	{
		
		if(pedido[ARTEFATOS_BONS].getAjudas()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_BONS].getAjudas();i++)
			{
				ajudas.add(artefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (artefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(artefatosB);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_BONS].getCodigos()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_BONS].getCodigos();i++)
			{
				codigos.add(artefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (artefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(artefatosB);
				}
			}
		}	
			
		if(pedido[ARTEFATOS_BONS].getDesenhos()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_BONS].getDesenhos();i++)
			{
				desenhos.add(artefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (artefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(artefatosB);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_BONS].getRastros()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_BONS].getRastros();i++)
			{
				rastros.add(artefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (artefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(artefatosB);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_BONS].getRequisitos()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_BONS].getRequisitos();i++)
			{
				requisitos.add(artefatosB[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (artefatosB[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosBons(artefatosB);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_RUINS].getAjudas()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getAjudas();i++)
			{
				ajudas.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_RUINS].getCodigos()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getCodigos();i++)
			{
				codigos.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_RUINS].getDesenhos()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getDesenhos();i++)
			{
				desenhos.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_RUINS].getRastros()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getRastros();i++)
			{
				rastros.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}	
		
		if(pedido[ARTEFATOS_RUINS].getRequisitos()>0)
		{
			for (int i=0;i<pedido[ARTEFATOS_RUINS].getRequisitos();i++)
			{
				requisitos.add(ArtefatosR[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (ArtefatosR[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual()<=0)
				{
					trocarBaralhoArtefatosRuins(ArtefatosR);
				}
			}
		}	
		
                //TODO teste
		for (int i=0;i<ajudas.size();i++)			
			ajudas.get(i).mostrarArtefato();		
		
		for (int i=0;i<codigos.size();i++)			
			codigos.get(i).mostrarArtefato();		
		
		for (int i=0;i<desenhos.size();i++)			
			desenhos.get(i).mostrarArtefato();		
		
		for (int i=0;i<rastros.size();i++)			
			rastros.get(i).mostrarArtefato();		
		
		for (int i=0;i<requisitos.size();i++)			
			requisitos.get(i).mostrarArtefato();		
		
				
	}
	
	
}
