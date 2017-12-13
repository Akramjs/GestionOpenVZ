package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mohamed
 *
 */
@Table(name = "g_serveur")
@Entity
public class Serveur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idServeur;
	private String idGestionnaire;
	private String imageOS;
	private String ip;
	private String marque;
	private String ram;
	private String rom;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdServeur() {
		return idServeur;
	}

	public void setIdServeur(int idServeur) {
		this.idServeur = idServeur;
	}

	public String getIdGestionnaire() {
		return idGestionnaire;
	}

	public void setIdGestionnaire(String idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}

	public String getImageOS() {
		return imageOS;
	}

	public void setImageOS(String imageOS) {
		this.imageOS = imageOS;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

}
