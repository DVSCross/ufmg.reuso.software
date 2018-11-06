/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.carta;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Michael David
 *
 */

public class CartaPenalizacao extends Carta
{
	private String referenciaBibliografica;
	private int duracaoEfeito;
	private String condicaoProblema;
	
	private int quantidadePrimeiroEfeito;								/** contém quanto de efeito será gerado.*/
	private int quantidadeSegundoEfeito;								/** contém quanto de efeito será gerado.*/
	private int tipoPrimeiroEfeito; 									/** será igual a uma das constantes de efeitos oriundos de carta problema de Constants.java */
	private int tipoSegundoEfeito;										/** será igual a uma das constantes de efeitos oriundos de carta problema de Constants.java*/ 
	
	private int quantidadePrimeiraCondicao;								/** contém quanto de condicao é necessária.*/
	private int quantidadeSegundaCondicao;								/** contém quanto de condicao é necessária.*/
	private int tipoPrimeiraCondicao; 									/** será igual a uma das de condições oriundas de carta problema constantes de Constants.java*/
	private int tipoSegundaCondicao;									/** será igual a uma das de condições oriundas de carta problema constantes de Constants.java*/
	
		
	public CartaPenalizacao (String titulo, String codigo, String texto,				//construindo a carta de conceito
			String referencia, int duracao, String condicao,int efeito1,int efeito2, int quantidadeEfeito1,
			int quantidadeEfeito2, int condicao1, int condicao2, int quantCondicao1, int quantCondicao2)
	{
		//inicializando a superclasse explicitamente, texto significa a descricao do problema ao utlizar a carta
		super (titulo, codigo, texto,PROBLEMA);												
		setReferenciaBibliografica(referencia);
		setDuracaoEfeito(duracao);
		setCondicaoProblema(condicao);
		setQuantidadePrimeiroEfeito(quantidadeEfeito1);
		setQuantidadeSegundoEfeito(quantidadeEfeito2);
		setTipoPrimeiroEfeito(efeito1);
		setTipoSegundoEfeito(efeito2);
		setQuantidadePrimeiraCondicao(quantCondicao1);
		setQuantidadeSegundaCondicao(quantCondicao2);
		setTipoPrimeiraCondicao(condicao1);
		setTipoSegundaCondicao(condicao2);
	}
	
		
	@Override
	public void mostrarCarta()
	{
    // printa a carta
	}
	
	public void inserirEfeito()
	{
		if (codigoCarta =="a")
		{
			//para cada codigo descrever problema
		}
	}
		
	
	
	
	
	public String getReferenciaBibliografica() 
	{
		return referenciaBibliografica;
	}

	public void setReferenciaBibliografica(String referenciaBibliografica) 
	{
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public int getDuracaoEfeito() 
	{
		return duracaoEfeito;
	}

	public void setDuracaoEfeito(int duracaoEfeito) 
	{
		this.duracaoEfeito = duracaoEfeito;
	}

	public String getCondicaoProblema() 
	{
		return condicaoProblema;
	}

	public void setCondicaoProblema(String condicaoProblema) 
	{
		this.condicaoProblema = condicaoProblema;
	}


	public int getQuantidadePrimeiroEfeito()
	{
		return quantidadePrimeiroEfeito;
	}


	public void setQuantidadePrimeiroEfeito(int quantidadePrimeiroEfeito) 
	{
		this.quantidadePrimeiroEfeito = quantidadePrimeiroEfeito;
	}


	public int getQuantidadeSegundoEfeito() 
	{
		return quantidadeSegundoEfeito;
	}


	public void setQuantidadeSegundoEfeito(int quantidadeSegundoEfeito) 
	{
		this.quantidadeSegundoEfeito = quantidadeSegundoEfeito;
	}


	public int getTipoPrimeiroEfeito() 
	{
		return tipoPrimeiroEfeito;
	}


	public void setTipoPrimeiroEfeito(int tipoPrimeiroEfeito) 
	{
		this.tipoPrimeiroEfeito = tipoPrimeiroEfeito;
	}


	public int getTipoSegundoEfeito() 
	{
		return tipoSegundoEfeito;
	}


	public void setTipoSegundoEfeito(int tipoSegundoEfeito)
	{
		this.tipoSegundoEfeito = tipoSegundoEfeito;
	}


	public int getQuantidadePrimeiraCondicao() 
	{
		return quantidadePrimeiraCondicao;
	}


	public void setQuantidadePrimeiraCondicao(int quantidadePrimeiraCondicao) 
	{
		this.quantidadePrimeiraCondicao = quantidadePrimeiraCondicao;
	}


	public int getQuantidadeSegundaCondicao()
	{
		return quantidadeSegundaCondicao;
	}


	public void setQuantidadeSegundaCondicao(int quantidadeSegundaCondicao) 
	{
		this.quantidadeSegundaCondicao = quantidadeSegundaCondicao;
	}


	public int getTipoPrimeiraCondicao() 
	{
		return tipoPrimeiraCondicao;
	}


	public void setTipoPrimeiraCondicao(int tipoPrimeiraCondicao)
	{
		this.tipoPrimeiraCondicao = tipoPrimeiraCondicao;
	}


	public int getTipoSegundaCondicao()
	{
		return tipoSegundaCondicao;
	}


	public void setTipoSegundaCondicao(int tipoSegundaCondicao)
	{
		this.tipoSegundaCondicao = tipoSegundaCondicao;
	}

	public void dumpProperties(String path) {
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write("codigo = " + this.codigoCarta + "\n");
			writer.write("titulo = " + this.tituloCarta + "\n");
			writer.write("texto = " + this.textoCarta + "\n");
			writer.write("referenciaBibliografica = " + this.referenciaBibliografica + "\n");
			writer.write("duracaoEfeito = " + this.duracaoEfeito + "\n");
			writer.write("condicao = " + this.condicaoProblema + "\n");
			writer.write("quantidadePrimeiroEfeito = " + this.quantidadePrimeiroEfeito + "\n");
			writer.write("quantidadeSegundoEfeito = " + this.quantidadeSegundoEfeito + "\n");
			writer.write("tipoPrimeiroEfeito = " + this.tipoPrimeiroEfeito + "\n");
			writer.write("tipoSegundoEfeito = " + this.tipoSegundoEfeito + "\n");
			writer.write("quantidadePrimeiraCondicao = " + this.quantidadePrimeiraCondicao + "\n");
			writer.write("quantidadeSegundaCondicao = " + this.quantidadeSegundaCondicao + "\n");
			writer.write("tipoPrimeiraCondicao = " + this.tipoPrimeiraCondicao + "\n");
			writer.write("tipoSegundaCondicao = " + this.tipoSegundaCondicao + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
