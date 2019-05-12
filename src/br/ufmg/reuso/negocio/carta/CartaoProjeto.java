/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.carta;

/**
 * @author Michael David
 *
 */


import java.io.File;
import java.util.NoSuchElementException;
import java.util.Random;

import br.ufmg.reuso.dados.carta.RepositorioCartaoProjeto;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Modulo;
import br.ufmg.reuso.ui.ScreenControl;

public class CartaoProjeto 
{
        
        //variavel referenciando o diretório CartaoProjeto no qual há os cartoes de projeto
	private static final String PATH = "CartaoProjeto";	
	private int complexidade;
	private int tamanho;
	private int qualidade;
	private int orcamento;
	private String codigo;
	private String titulo;
	private String texto;
	private String referenciaBibliografica;
	private Modulo[] modulos;
        
	/**
	 * Reuso de Software 2016 - Código Adicionado
	 */
	private RepositorioCartaoProjeto repositorio = new RepositorioCartaoProjeto();

	public CartaoProjeto(String codigo, String titulo, String texto, String referenciaBibliografica)
	{
		this.codigo = codigo;
		this.titulo = titulo;
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public CartaoProjeto(String facilidade)
	{
		definirProjeto(facilidade);
	}

	public void definirProjeto(String facilidade)
	{

		if (facilidade.equals(Jogo.FACIL))
		{
                    
                        // variável para conferir valores aleatórios
			Random sorteio = new Random();
                        
                        // definindo complexidade do projeto com valor igual a 2
			setComplexidade(2);	
                        
                        // definindo tamanho do projeto com valores de 1 a 2
			setTamanho((sorteio.nextInt(2)+1));
                        
                         // definindo qualidade do projeto conforme tamanho do projeto
			setQualidade((sorteio.nextInt(getTamanho())));
                        
                        // caso qualidade seja zero 
			if (this.qualidade==0)
                            
                                // ela é configurada como 1, para ter qualidade mínima
				setQualidade(1);	
                        
                        // definindo orçamento de 150 a 180 
			setOrcamento((sorteio.nextInt(31)+150));		
                        
                        // criando o número de módulos conforme o tamanho do projeto
			modulos= new Modulo[getTamanho()];				
			for (int i=0;i<modulos.length;i++)
                             
                                // construindo os módulos// construindo os módulos
				modulos[i] = new Modulo();
                        
                        // controla o número do módulo para preenchimento
			int contador;		
                        
                        // preenche os módulos
			for (contador = 0;contador <getTamanho(); contador++)		 
			{
				modulos[contador].setRequisitos((sorteio.nextInt(2)+1));
				modulos[contador].setDesenhos((sorteio.nextInt(2)+1));
				modulos[contador].setCodigos((sorteio.nextInt(2)+1));
				modulos[contador].setRastros((sorteio.nextInt(2)+1));
				modulos[contador].setAjudas((sorteio.nextInt(2)+1));
			}															

		}
		if (facilidade.equals(Jogo.MODERADO))
		{
                        // variável para conferir valores aleatórios
			Random sorteio = new Random();  
                        
                        // definindo complexidade do projeto com valor igual a 2
			setComplexidade(2);		
                        
                        // definindo tamanho do projeto com valores de 2 a 4
			setTamanho((sorteio.nextInt(3)+2));
                        
                        // definindo qualidade do projeto conforme tamnho do projeto
			setQualidade((sorteio.nextInt(getTamanho()))); 
                        
                        // caso qualidade seja zero
			if (this.qualidade<2)	
                            
                                // ela é configurada como 1
				setQualidade(2);	
                        
                        // definindo orçamento de 190 a 210
			setOrcamento((sorteio.nextInt(21)+190)); 		
                           
                        // criando o número de módulos conforme o tamanho do projeto
			modulos= new Modulo[getTamanho()];										
			for (int i=0;i<modulos.length;i++)
                            
                                // construindo os módulos
				modulos[i] = new Modulo();
                        
                        // controla o número do mdulo para preenchimento
			int contador;	
                        
                        // preenche os módulos
			for (contador = 0;contador <getTamanho(); contador++)					 
			{
				modulos[contador].setRequisitos((sorteio.nextInt(3)+1));
				modulos[contador].setDesenhos((sorteio.nextInt(3)+1));
				modulos[contador].setCodigos((sorteio.nextInt(3)+1));
				modulos[contador].setRastros((sorteio.nextInt(3)+1));
				modulos[contador].setAjudas((sorteio.nextInt(3)+1));
			}																		

		}
		if (facilidade.equals(Jogo.DIFICIL))
		{
                    
			/**
			 * Reuso de Software 2016 - Código Modificado
			 */
			String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(PATH);	
                        
                        // variável para conferir valores aleatórios
			Random sorteio = new Random();  

                        // sorteia um valor que siginificará o projeto a ser selecionado para o jogo
			int projetoSorteado = sorteio.nextInt(arquivosDiretorio.length);		 


			CartaoProjeto c = null;
			int sentinela = -1;
			int controlador = 0;
			while (sentinela ==-1)
			{
                                
                                /**testando se arquivo é .properties*/
				if(arquivosDiretorio[projetoSorteado].endsWith(".properties"))
                                    
                                    /**atualiza sentinela para sair do while*/
					sentinela=0;												
				else
				{
					controlador++;
                                        
                                        /**sorteia um número novamente*/
					projetoSorteado = sorteio.nextInt(arquivosDiretorio.length);
				}
				if (controlador>=arquivosDiretorio.length)
                                    
                                        /**se chegar aqui, significa que pasta não tem arquivo propesties*/
					sentinela=0;												
			}
                        
			/**
			 * Reuso de Software 2016 - Código Modificado
			 */
			if (!ScreenControl.nomeProjeto.equals("padrao")){
				c = repositorio.obterCartaoProjeto(PATH + File.separator + ScreenControl.nomeProjeto);	
			}else{
				c = repositorio.obterCartaoProjeto(PATH + File.separator + arquivosDiretorio[projetoSorteado]);
			}
                        
                        //tentativa de leitura e abstração de dados dos arquivos
			try		
			{
                            
                                /** lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo codigo*/
                                /** lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo titulo*/
                                /** lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo texto*/
                                /** lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo referenciaBibliografica*/
				setCodigo(c.getCodigo());		
				setTitulo(c.getTitulo());		
				setTexto(c.getTexto());		
				setReferenciaBibliografica(c.getReferenciaBibliografica());	
			}
                        
                        //se os dados estiverem fora do formato ou se não haver mais dados para saída, há problema
			catch (NoSuchElementException noSuchElementException)		
			{
                            
                                //jogo termina sem êxito devido ao problema
				System.exit(1);											
			}



                        // definindo complexidade do projeto com valor igual a 4
			setComplexidade(4);	
                        
                        // definindo tamanho do projeto com valores de 3 a 5
			setTamanho((sorteio.nextInt(3)+3));
                        
                        // definindo qualidade do projeto conforme tamnho do projeto
			setQualidade((sorteio.nextInt(getTamanho())));  
                        
                        // caso qualidade seja zero
			if (this.qualidade<3)										 
                            // ela é configurada como 1
                            setQualidade(3);
                        
			// definindo orçamento de 230 a 250
                        setOrcamento((sorteio.nextInt(21)+230));					
                           
                        // criando o número de módulos conforme o tamanho do projeto
			modulos= new Modulo[getTamanho()];							
			/*IMP*/		
			for (int i=0;i<modulos.length;i++)
                                
                                // construindo os módulos
				modulos[i] = new Modulo();								
			
                        // controla o número do módulo para preenchimento
                        int contador;												
			
                        //preenche o módulo
                        for (contador = 0;contador <getTamanho(); contador++)		
			{
				modulos[contador].setRequisitos((sorteio.nextInt(3)+2));
				modulos[contador].setDesenhos((sorteio.nextInt(3)+2));
				modulos[contador].setCodigos((sorteio.nextInt(3)+2));
				modulos[contador].setRastros((sorteio.nextInt(3)+2));
				modulos[contador].setAjudas((sorteio.nextInt(3)+2));
			}															

		}

	}

	public int getComplexidade() 
	{
		return complexidade;
	}

	public void setComplexidade(int complexidade) 
	{
		this.complexidade = complexidade;
	}

	public int getTamanho() 
	{
		return tamanho;
	}

	public void setTamanho(int tamanho) 
	{
		this.tamanho = tamanho;
	}

	public int getQualidade() 
	{
		return qualidade;
	}

	public void setQualidade(int qualidade) 
	{
		this.qualidade = qualidade;
	}

	public int getOrcamento() 
	{
		return orcamento;
	}

	public void setOrcamento(int orcamento) 
	{
                //garante que orçamento é um número divisível por 10 
		while ((orcamento%10)!=0) 	
		{
			orcamento++;
		}
		this.orcamento = orcamento;
	}

	public String getTexto() 
	{
		return texto;
	}

	public void setTexto(String texto) 
	{
		this.texto = texto;
	}

	public String getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getReferenciaBibliografica() 
	{
		return referenciaBibliografica;
	}

	public void setReferenciaBibliografica(String referenciaBibliografica) 
	{
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public Modulo[] getModulos() 
	{
		return modulos;
	}

	public void setModulos(Modulo[] modulos) 
	{
		this.modulos = modulos;
	}
}
