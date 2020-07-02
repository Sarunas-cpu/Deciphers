
/*
 * @author Sarunas Valiulis
 */
public class VigenereCipherKey6 {
	private CaesarCipher caeCip;
	private VigenereCipher vigCip;

	// MLWJWYLLIPMJUVRIOPHLSMLSKVFIWI
	public VigenereCipherKey6() {
		caeCip = new CaesarCipher();

	}

	/*
	 * runs decryption for keylenghts 4-6
	 */
	public void deCrypt(String text) {
		deCrypt2(text, 4);
		deCrypt2(text, 5);
		deCrypt2(text, 6);
	}

	/*
	 * Generate string of the characters for each key character Gets the key from
	 * using Caesar Cipher class depending on the key segment using letter frequency
	 */
	public void deCrypt2(String text, int keyLength) {
		int runner = 0;
		String output = "";
		String plaintext = "";
		String key = "";
		while (runner < keyLength) {
			// generates the output string for the key character
			for (int i = 0; i < text.length(); i++) {
				if (i % keyLength == runner) {
					char ch = text.charAt(i);
					output += ch;
				}
			}
			key += caeCip.getKeyLetter(output);

			output = "";
			runner++;
		}
		System.out.println("######################################");
		System.out.println(new VigenereCipher(key).deCrypt(text).substring(0, 30));

	}
}
