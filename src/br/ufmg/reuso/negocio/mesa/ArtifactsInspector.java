package br.ufmg.reuso.negocio.mesa;

import java.util.ArrayList;

import br.ufmg.reuso.negocio.carta.Artefato;

public class ArtifactsInspector {
	
	public static final int ARTEFATOS_BONS = 0;
	public static final int ARTEFATOS_RUINS = 1;	

	public void virarRequisitos(Modulo[] pedido, 
			                    int tipo,
			                    ArrayList<Artefato> requisitos)
	{
		int j=0;
		boolean checkQuality = (tipo == ARTEFATOS_BONS);
		
		for (int i=0;i<pedido[tipo].getRequisitos();i++)
		{
			/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
			while((requisitos.get(j).inspected())||(requisitos.get(j).isPoorQuality() == checkQuality))
				j++; // TODO lancar excecao em caso de nao haver artefatos a serem virados
			requisitos.get(j).setArtefatoInspecionado(true);
		}
	}
	
	public void virarDesenhos(Modulo[] pedido,
			                   int tipo,
			                   ArrayList<Artefato> desenhos) {
		int j=0;		
		boolean checkQuality = (tipo == ARTEFATOS_BONS);
		
		for (int i=0;i<pedido[tipo].getDesenhos();i++)
		{
			/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
			while((desenhos.get(j).inspected())||(desenhos.get(j).isPoorQuality() == checkQuality))
				j++; // TODO lancar excecao em caso de nao haver artefatos a serem virados
			desenhos.get(j).setArtefatoInspecionado(true);
		}
	}
	
	public void virarAjudas(Modulo[] pedido,
			                 int tipo,
			                 ArrayList<Artefato> ajudas)
	{
		int j=0;
		boolean checkQuality = (tipo == ARTEFATOS_BONS);
		
		for (int i=0;i<pedido[tipo].getAjudas();i++)
		{
			/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
			while((ajudas.get(j).inspected()) || (ajudas.get(j).isPoorQuality() == checkQuality))
				j++; // TODO lancar excecao em caso de nao haver artefatos a serem virados
			ajudas.get(j).setArtefatoInspecionado(true);
		}
	}
	
	public void virarCodigos(Modulo[] pedido,
			                  int tipo,
			                  ArrayList<Artefato> codigos) {
		int j=0;
		boolean checkQuality = (tipo == ARTEFATOS_BONS);
		
		for (int i=0;i<pedido[tipo].getCodigos();i++)
		{
			/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
			while((codigos.get(j).inspected())||(codigos.get(j).isPoorQuality()== checkQuality))
				j++; // TODO lancar excecao em caso de nao haver artefatos a serem virados
			codigos.get(j).setArtefatoInspecionado(true);
		}
	}
	
	public void virarRastros(Modulo[] pedido, 
			                 int tipo,
			                 ArrayList<Artefato> rastros) {
		int j=0;
		boolean checkQuality = (tipo == ARTEFATOS_BONS);
		
		for (int i=0;i<pedido[tipo].getRastros();i++)
		{
			/**Enquanto artefato estiver inspecionado ou artefato ser ruim, procura proximo artefato*/
			while((rastros.get(j).inspected())||(rastros.get(j).isPoorQuality() == checkQuality))
				j++; // TODO lancar excecao em caso de nao haver artefatos a serem virados
			rastros.get(j).setArtefatoInspecionado(true);
		}		
	}
}
