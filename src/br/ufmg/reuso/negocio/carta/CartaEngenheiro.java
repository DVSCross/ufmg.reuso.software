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
	private Engenheiro engenheiro;
	
  /**se true-> trabalhou, se false-> não trabalhou na rodada*/ 
	private boolean engenheiroTrabalhouNestaRodada; 			

	
        /**contém a pontos de habilidade que engenheiro tem na rodada*/
	private int habilidadeEngenheiroAtual;						 
        
        //construindo a carta de engenheiro
	public CartaEngenheiro (String codigo, String texto, String nomeEng, 
			int salarioEng, int habilidadeEng, int maturidadeEng)
	{
                
                //inicializando a superclasse explicitamente
		super ("Eng.Software", codigo, texto,ENGENHEIRO);				 
		
		this.engenheiro = new Engenheiro();
		this.engenheiro.setNomeEngenheiro(nomeEng);
		this.engenheiro.setSalarioEngenheiro(salarioEng);
		this.engenheiro.setHabilidadeEngenheiro(habilidadeEng);		
		this.engenheiro.setMaturidadeEngenheiro(maturidadeEng);
		this.engenheiroTrabalhouNestaRodada=false;
    
    /**habilidade atual na construção da carta do engenheiro é igual à habildade da carta*/
		this.setHabilidadeEngenheiroAtual(this.engenheiro.getHabilidadeEngenheiro()); 
	}
	
		
	@Override
	public void mostrarCarta()
	{
            // printa a carta
	}
	
	public Engenheiro getEngenheiro() {
		return this.engenheiro;
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
			writer.write("nome = " + this.engenheiro.getNomeEngenheiro() + "\n");
			writer.write("salario = " + this.engenheiro.getSalarioEngenheiro() + "\n");
			writer.write("habilidade = " + this.engenheiro.getHabilidadeEngenheiro() + "\n");
			writer.write("maturidade = " + this.engenheiro.getMaturidadeEngenheiro() + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block			
		}
	}
}
