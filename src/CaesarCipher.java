/*
 * @author Sarunas Valiulis
 */
public class CaesarCipher {
	// English alphabet string
	private String alph;
	// shit amount of the letter
	private int shift;
	// probabilities of letters appearance in English text
	private double[] statisticalAppearance = { 8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015, 6.094, 6.966, 0.153,
			0.772, 4.025, 2.406, 6.749, 7.507, 1.929, 0.095, 5.987, 6.327, 9.056, 2.758, 0.978, 2.360, 0.150, 1.974,
			0.075 };

	public CaesarCipher() {
		shift = 0;
		alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

	/*
	 * Get characters from the text and shift them in a different amount Appleies
	 * letter frequency analysis and picks the shift with the smallest chi-squared
	 * updates the shif value accordin to letter frequency analysis
	 */
	public void deCrypt(String text) {
		shift = 0;
		int finalShift = 0;
		text = text.toUpperCase();
		double finalTotal = Integer.MAX_VALUE;
		String output = "";
		while (shift < 26) {
			// replace letter with corresponding shifted letter
			for (Character ch : text.toCharArray()) {
				output += retLet(ch);
			}
			// calculates the number of appearances of the same character within cybertext
			// for particular key character and
			// also as calculating total chi-squared
			double tempTotal = 0;
			for (int i = 0; alph.length() > i; i++) {
				int letterCounter = countLetter(output, alph.charAt(i));
				double prob = output.length() * statisticalAppearance[i] / 100;
				// calculating chi - squared
				tempTotal += (letterCounter - prob) * (letterCounter - prob) / prob;
				// System.out.println(tempTotal + "##########");

			}
			// replaced current chi-squared total and updates the shift if the current total
			// is smaller than the previous one
			if (tempTotal < finalTotal) {
				finalTotal = tempTotal;
				finalShift = shift;
			}
			output = "";
			shift++;
		}
		// print out correct string deciphered one
		shift = finalShift;
		for (Character ch : text.toCharArray()) {
			output += retLet(ch);
		}
//	System.out.println(output.substring(0, 30));
	}

	/*
	 * Counts letter appearance in given text
	 * 
	 * @text text string
	 * 
	 * @letter specific letter to get the count of
	 * 
	 * @return number of letter specified in the text
	 */
	private int countLetter(String text, Character letter) {
		int letterCounter = 0;
		for (Character ch : text.toCharArray()) {
			if (letter.equals(ch)) {
				letterCounter++;
			}
		}
		return letterCounter;
	}

	/*
	 * gets the key for shift depending on the shift that was calculated in deCrypt
	 * method
	 * 
	 * @text text to be decrypted
	 * 
	 * @return the key generated using letter frequency analysis
	 */
	public char getKeyLetter(String text) {
		deCrypt(text);
//	System.out.println(shift + "=" +alph.charAt(shift));
		return alph.charAt(shift);
	}

	/*
	 * Retrieves corresponding letter depending on the shift
	 * 
	 * @letter letter to be shifted
	 * 
	 * @return letter after shift
	 */
	private char retLet(Character letter) {
		int runner = 0;
		for (Character ch : alph.toCharArray()) {
			if (ch.equals(letter)) {
				letter = alph.toCharArray()[(runner + shift) % 26];
				break;
			}
			runner++;
		}
		return letter;
	}
}
