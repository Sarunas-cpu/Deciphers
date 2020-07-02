import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
/*
 * @author Sarunas Valiulis
 */
public class GeneralSubCipher {
	// English alphabet string sorted by statistical analysis descending
	private String alph;
	// final letter mapping
	private HashMap<Character, Character> finalMap;
	// map to test variations of keys manually
	private HashMap<Character, Character> testMap;
	private HashMap<Double, Character> probToChar;
	// statistical analysis of current text
	private ArrayList<Double> textProbs;
	// probabilities of letters appearance in English text
	// |
	private double[] statisticalAppearance = { 18.89407891,
			// E
			10.50198803,
			// T
			7.31876821,
			// A
			6.282318737,
			// O
			6.057204711,
			// H
			5.672223479,
			// N
			5.525980608,
			// I
			5.346489359,
			// S
			5.233369873,
			// R
			4.810890469,
			// D
			3.713318976,
			// L
			3.307463761,
			// U
			2.262139721,
			// W
			1.987778096,
			// M
			1.958904503,
			// C
			1.892782727,
			// F
			1.77928826,
			// G
			1.672168482,
			// Y
			1.611796425,
			// P
			1.229815047,
			// B
			1.20144143,
			// X
			0.1142444306,
			// J
			0.0821209966,
			// Q
			0.07887115503,
			// V
			0.757088092,
			// K
			0.6348440514,
			// Z
			0.0726214597 };

	public GeneralSubCipher() {
		textProbs = new ArrayList<>();
		probToChar = new HashMap<>();
		finalMap = new HashMap<>();

		alph = "|ETAOHNISRDLUWMCFGYPBXJQVKZ";
		testMap = new HashMap<>();
		// change value of the key to map corresponding value to that character in the
		// text to decipher
		testMap.put('A', 'B');
		testMap.put('B', 'F');
		testMap.put('C', 'M');
		testMap.put('D', 'G');
		testMap.put('E', 'D');
		testMap.put('F', 'R');
		testMap.put('G', 'V');
		testMap.put('H', 'C');
		testMap.put('I', 'Q');
		testMap.put('J', 'S');
		testMap.put('K', 'P');
		testMap.put('L', '|');
		testMap.put('M', 'Z');
		testMap.put('N', 'E');
		testMap.put('O', 'X');
		testMap.put('P', 'Y');
		testMap.put('Q', 'I');
		testMap.put('R', 'J');
		testMap.put('S', 'W');
		testMap.put('T', 'O');
		testMap.put('U', 'A');
		testMap.put('V', 'T');
		testMap.put('W', 'N');
		testMap.put('X', 'H');
		testMap.put('Y', 'K');
		testMap.put('Z', 'L');
		testMap.put('|', 'U');
	}

	/*
	 * calculates the number of appearances of the same character within cybertext
	 * for particular key character and calculates the probability for given
	 * character then maps that probability to given character probabilities then
	 * sorted in descending order and then mapped accordingly to possible mapped
	 * characters <Character, Character>
	 */
	public void deCrypt(String text) {

		text = text.toUpperCase();

		double prob = 0;
		for (int i = 0; alph.length() > i; i++) {
			double letterCounter = countLetter(text, alph.charAt(i));
			prob = letterCounter / text.length() * 100;
			if (textProbs.contains(prob)) {
				prob -= 0.000000000000001;
			}
			textProbs.add(prob);
			probToChar.put(prob, alph.charAt(i));
//			System.out.println("LETTER COUNT" + letterCounter + " " + prob + "=" + alph.charAt(i));
		}
		Collections.sort(textProbs);
		Collections.reverse(textProbs);
		for (int i = 0; i < textProbs.size(); i++) {
			finalMap.put(probToChar.get(textProbs.get(i)), alph.charAt(i));
//			System.out.println(probToChar.get(textProbs.get(i)) + "=" + alph.charAt(i));
//			System.out.println(finalMap);
		}

//		System.out.println(textProbs);
		String output = "";
		// replace letter with corresponding mapped letter
		for (Character ch : text.toCharArray()) {
			output += finalMap.get(ch);
		}
		String output2 = "";
		// manual map changing
		for (Character ch : text.toCharArray()) {
			output2 += testMap.get(ch);
		}
		System.out.println(output);
		System.out.println(output2);
		System.out.println(output2.substring(0,30));

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

}
