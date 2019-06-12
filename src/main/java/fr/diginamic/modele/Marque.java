package fr.diginamic.modele;

public class Marque {

	/** id : int */
	private int id;
	/** nom : String */
	private String nom;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param nom
	 */
	public Marque(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Marque(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
