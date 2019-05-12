package br.ufmg.reuso.negocio.carta;

public class Engenheiro 
{
	private String nomeEngenheiro;								//variável que guarda nome do engenheiro
	private int salarioEngenheiro;								//variável que guarda salário do engenheiro
	private int habilidadeEngenheiro;							//variável que guarda habilidade do engenheiro
	private int maturidadeEngenheiro;							//variável que guarda a maturidade do engenheiro
	
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
}
