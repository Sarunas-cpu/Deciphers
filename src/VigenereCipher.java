/*
 * @author Sarunas Valiulis
 */
public class VigenereCipher {

	private String alph;
	private int shift;
	private String key;
	// MLWJWYLLIPMJUVRIOPHLSMLSKVFIWI

	public VigenereCipher(String key) {
		shift = 1;
		alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.key = key;
	}

	/*
	 * Takes the text in constructs output string by shifting each character
	 * depending on the key
	 * 
	 * @text text to be decrypted
	 */
	public String deCrypt(String text) {
		int runner = 0;
		String output = "";
		for (Character ch : text.toCharArray()) {
			shift = key.charAt(runner % key.length()) % 32 - 1;
			// System.out.println(shift + "=" +alph.charAt(shift));
			output += retLet(ch);
			if (runner == key.length() - 1) {
				runner = 0;
			} else {
				runner++;
			}
		}
//		System.out.println(text.substring(0, 30));
//		System.out.println(output.substring(0,30));
		return output;
	}

	/*
	 * Shifts the letter depending on the character value
	 * 
	 * @letter letter to be shifted
	 * 
	 * @return returns the letter after shift Shift ch + shift has to be changed to
	 * ch - shift if VigenereCipher is ran alone if it runs on VigenereCipherKey6
	 * class it has to be ch + shift
	 */
	private char retLet(Character letter) {
		int ch = alph.indexOf(letter);
		int loc = (ch + shift) % alph.length();

		if (loc < 0)
			loc += alph.length();
		return alph.charAt(loc);
	}
}
