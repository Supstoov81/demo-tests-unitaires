package fr.diginamic.utils;

public final class StringUtils {

	/**
	 * Retourne la distance de Levenshtein entre 2 chaines de caractères.
	 * Cette distance est le nombre minimal de modifications nécessaires pour transformer une chaîne en une autre.
	 * Les modifications possibles sont l'insertion, la suppression ou la substitution d'un caractère.
	 *
	 * @param lhs chaîne de caractères 1 (ne doit pas être null)
	 * @param rhs chaîne de caractères 2 (ne doit pas être null)
	 * @return la distance de Levenshtein entre lhs et rhs
	 * @throws IllegalArgumentException si l'une des chaînes est null
	 */
	public static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
		if (lhs == null || rhs == null) {
			throw new IllegalArgumentException("Les chaînes de caractères ne doivent pas être nulles");
		}

		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		// Initialisation des tableaux de coûts
		int[] previousCost = new int[len0];
		int[] currentCost = new int[len0];

		// Initialisation du tableau de base (distance de l'empty string à l'autre)
		for (int i = 0; i < len0; i++) {
			previousCost[i] = i;
		}

		// Calcul des distances
		for (int j = 1; j < len1; j++) {
			char rhsChar = rhs.charAt(j - 1);
			currentCost[0] = j;

			for (int i = 1; i < len0; i++) {
				char lhsChar = lhs.charAt(i - 1);

				int costReplace = previousCost[i - 1] + (lhsChar == rhsChar ? 0 : 1);
				int costInsert = previousCost[i] + 1;
				int costDelete = currentCost[i - 1] + 1;

				currentCost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);
			}

			// Échange des tableaux de coûts
			int[] swap = previousCost;
			previousCost = currentCost;
			currentCost = swap;
		}

		// Le dernier élément du tableau précédent contient la distance de Levenshtein
		return previousCost[len0 - 1];
	}
}
