package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Akram
 *
 */
@Table(name = "g_systemOS")
@Entity
public class SystemOS implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idImage;
	private String libelle;
	private float tailleHd;
	private int tailleRam;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getTailleHd() {
		return tailleHd;
	}

	public void setTailleHd(float tailleHd) {
		this.tailleHd = tailleHd;
	}

	public int getTailleRam() {
		return tailleRam;
	}

	public void setTailleRam(int tailleRam) {
		this.tailleRam = tailleRam;
	}

}
