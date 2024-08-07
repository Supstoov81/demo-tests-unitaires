package fr.diginamic.enumerations;

import java.text.Normalizer;

/**
 * Représente une saison et fournit les 4 instances de saisons.
 * 
 * @author DIGINAMIC
 *
 */
public enum Saison {

	/** Les 4 instances de Saison */
	PRINTEMPS("Printemps", 1), ETE("Eté", 2), AUTOMNE("Automne", 3), HIVER("Hiver", 4);

	/** libelle */
	private String libelle;
	/** ordre */
	private int ordre;

	/**
	 * Constructeur
	 * 
	 * @param libelle libellé
	 * @param ordre   ordre
	 */
	private Saison(String libelle, int ordre) {
		this.libelle = libelle;
		this.ordre = ordre;
	}

	/**
	 * Permet de rechercher une Saison à partir de son libellé
	 * 
	 * @param libelle libellé
	 * @return {@link Saison}
	 */
	public static Saison valueOfLibelle(String libelle) {
		if (libelle == null || libelle.trim().isEmpty()) {
			throw new IllegalArgumentException("Libelle cannot be null or empty");
		}
		String normalizedLibelle = Normalizer.normalize(libelle, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
		for (Saison saison : values()) {
			String normalizedSaisonLibelle = Normalizer.normalize(saison.getLibelle(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
			if (normalizedLibelle.equals(normalizedSaisonLibelle)) {
				return saison;
			}
		}
		throw new IllegalArgumentException("No enum constant with libelle " + libelle);
	}

	@Override
	public String toString() {
		return ordre + ". " + libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the ordre
	 */
	public int getOrdre() {
		return ordre;
	}
}