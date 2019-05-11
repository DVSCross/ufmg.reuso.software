/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 * 
 * Edited by Charles / Pedro / Salatiel / Suelen
 * Date: 14/11/2014
 */

package br.ufmg.reuso.negocio.carta;

import javax.swing.ImageIcon;

import br.ufmg.reuso.ui.ComponentCard;
import br.ufmg.reuso.ui.ScreenInteraction;
import br.ufmg.reuso.ui.ScreenTabuleiro;

/**
 * @author Michael David
 * Classe que contém o objeto artefato
 */


public class Artefato 
{
	private boolean bug;						/**se true há bug, do contrário não há bug*/
	private boolean qualidadeArtefatoRuim;		/**se true é ruim, se não é bom*/
	private boolean artefatoInspecionado;		/**se true foi inspecionado, se false não foi inspecionado*/
	
	protected EstadoCarta estado;				// verifica o estado da carta artefato
	
	/**
	 * @param bug
	 * @param qualidade
	 * Construtor da classe Artefato sendo os parâmetros,independentemente um do outro, bom ou ruim.
	 */
	public Artefato (boolean bug, boolean qualidade)
	{
		setBug(bug);
		setQualidadeArtefatoRuim(qualidade);
		setArtefatoInspecionado(false);
	}
	
	/**
	 * Método mostra artefato no console.
	 */
	public void mostrarArtefato()
	{
		// printa artefato
	}
	
	public boolean getQualidadeArtefatoRuim() {
		return this.qualidadeArtefatoRuim;
	}
	
	public boolean getBug() {
		return this.bug;
	}
	
	public boolean isBug() 
	{
		return bug;
	}
	
	public void setBug(boolean bug) 
	{
		this.bug = bug;
	}

	public boolean isPoorQuality() 
	{
		return qualidadeArtefatoRuim;
	}
	
	public void setQualidadeArtefatoRuim (boolean qualidadeArtefato) 
	{
		this.qualidadeArtefatoRuim = qualidadeArtefato;
	}

	public boolean inspected() 
	{
		return artefatoInspecionado;
	}

	public void setArtefatoInspecionado(boolean artefatoInspecionado) 
	{
		this.artefatoInspecionado = artefatoInspecionado;
	}
	
	// implementacao para o padrao de projeto State
	public void obtemEstado()
	{
		estado.getEstado(this);
	}

	/**
	 * Recebe um artefato a ser pintado e verifica, segundo seu estado qual a
	 * imagem correspondente
	 * 
	 * @param height TODO
	 * @return a imagem no formato ImagIcon a ser pintada em um Label
	 */
	public ImageIcon getImageArtefact(int height) {
		ImageIcon img = null;
		if (isPoorQuality() == true) { // Artifact
			// Bad
	
			if (inspected() == true) {
	
				if (isBug() == true) {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath
									+ "artefactBadBugged.png", 0, height);
				} else {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath + "artefactBadOk.png",
							0, height);
				}
	
			} else { // Artifact Bad not inspectioned
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "artefactBad.png", 0,
						height);
			}
	
		} else { // Artifact God
	
			if (inspected() == true) {
	
				if (isBug() == true) {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath
									+ "artefactGoodBugged.png", 0, height);
				} else {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath + "artefactGoodOk.png",
							0, height);
				}
	
			} else { // Artifact Bad not inspectioned
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "artefactGood.png", 0,
						height);
	
			}
	
		}
		return img;
	}

	/**
	 * Recebe um artefato a ser pintado e verifica, segundo seu estado qual a
	 * imagem correspondente
	 * 
	 * @param screenTabuleiro TODO
	 * @return a imagem no formato ImagIcon a ser pintada em um Label
	 */
	public ImageIcon getImageArtefact(ScreenTabuleiro screenTabuleiro) {
		ImageIcon img = null;
		if (isPoorQuality() == true) { // Artifact
			// Bad
	
			if (inspected() == true) {
	
				if (isBug() == true) {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath
									+ "artefactBadBugged.png", 0, screenTabuleiro.height);
				} else {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath + "artefactBadOk.png",
							0, screenTabuleiro.height);
				}
	
			} else { // Artifact Bad not inspectioned
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "artefactBad.png", 0,
						screenTabuleiro.height);
			}
	
		} else { // Artifact God
	
			if (inspected() == true) {
	
				if (isBug() == true) {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath
									+ "artefactGoodBugged.png", 0, screenTabuleiro.height);
				} else {
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath + "artefactGoodOk.png",
							0, screenTabuleiro.height);
				}
	
			} else { // Artifact Bad not inspectioned
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "artefactGood.png", 0,
						screenTabuleiro.height);
	
			}
	
		}
		return img;
	}	
}
