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

public class CartaEngenheiro extends Carta
{
	private String nomeEngenheiro;								//variável que guarda nome do engenheiro
	private int salarioEngenheiro;								//variável que guarda salário do engenheiro
	private int habilidadeEngenheiro;							//variável que guarda habilidade do engenheiro
	private int maturidadeEngenheiro;							//variável que guarda a maturidade do engenheiro
	private boolean engenheiroTrabalhouNestaRodada; 			/**se true-> trabalhou, se false-> não trabalhou na rodada*/ 
	
	private int habilidadeEngenheiroAtual;						/**contém a pontos de habilidade que engenheiro tem na rodada*/ 

	public CartaEngenheiro (String codigo, String texto, String nomeEng, //construindo a carta de engenheiro
			int salarioEng, int habilidadeEng, int maturidadeEng)
	{
		super ("Eng.Software", codigo, texto,ENGENHEIRO);				 //inicializando a superclasse explicitamente
		
		setNomeEngenheiro(nomeEng);
		setSalarioEngenheiro(salarioEng);
		setHabilidadeEngenheiro(habilidadeEng);
		setHabilidadeEngenheiroAtual(getHabilidadeEngenheiro());		/**habilidade atual na construção da carta do engenheiro é igual à habildade da carta*/
		setMaturidadeEngenheiro(maturidadeEng);
		this.engenheiroTrabalhouNestaRodada=false;
	}
	
		
	@Override
	public void mostrarCarta()
	{
    // printa a carta
	}
	
	public String getNomeEngenheiro() 
	{
		return nomeEngenheiro;
	}

	public void setNomeEngenheiro(String nomeEngenheiro) 
	{
		this.nomeEngenheiro = nomeEngenheiro;
	}

	public int getSalarioEngenheiro() 
	{
		return salarioEngenheiro;
	}

	public void setSalarioEngenheiro(int salarioEngenheiro) 
	{
		this.salarioEngenheiro = salarioEngenheiro;
	}

	public int getHabilidadeEngenheiro() 
	{
		return habilidadeEngenheiro;
	}

	public void setHabilidadeEngenheiro(int habilidadeEngenheiro) 
	{
		this.habilidadeEngenheiro = habilidadeEngenheiro;
	}

	public int getMaturidadeEngenheiro() 
	{
		return maturidadeEngenheiro;
	}

	public void setMaturidadeEngenheiro(int maturidadeEngenheiro) 
	{
		this.maturidadeEngenheiro = maturidadeEngenheiro;
	}

	public boolean isEngenheiroTrabalhouNestaRodada() 
	{
		return engenheiroTrabalhouNestaRodada;
	}

	public void setEngenheiroTrabalhouNestaRodada(boolean engenheiroTrabalhouNestaRodada) 
	{
		this.engenheiroTrabalhouNestaRodada = engenheiroTrabalhouNestaRodada;
	}

	public int getHabilidadeEngenheiroAtual() 
	{
		return habilidadeEngenheiroAtual;
	}

	public void setHabilidadeEngenheiroAtual(int habilidadeEngenheiroAtual)
	{
		this.habilidadeEngenheiroAtual = habilidadeEngenheiroAtual;
	}
	
	public void dumpProperties(String path) {
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write("codigo = " + this.codigoCarta + "\n");
			writer.write("texto = " + this.textoCarta + "\n");
			writer.write("nome = " + this.nomeEngenheiro + "\n");
			writer.write("salario = " + this.salarioEngenheiro + "\n");
			writer.write("habilidade = " + this.habilidadeEngenheiro + "\n");
			writer.write("maturidade = " + this.maturidadeEngenheiro + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block			
		}
	}
}
