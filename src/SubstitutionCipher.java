import java.util.ArrayList;
/*
 * @author Sarunas Valiulis
 */
public class SubstitutionCipher {

	private ArrayList<String> rows;

	public SubstitutionCipher() {
		rows = new ArrayList<>();
	}

	/*
	 * Divides cyber text into rows and reads it collumnvise frop top to bottom left
	 * to right and generates output string
	 * 
	 * @text cyphertext
	 */
	public void deCrypt(String text) {

		int textSize = 0;
		int rowStart = 0;
		int rowEnd = text.length() / 6;
		int rowSize = rowEnd;

		while (textSize != text.length()) {
			rows.add(text.substring(rowStart, rowEnd));
			rowStart += rowSize;
			rowEnd += rowSize;
			textSize += rowSize;
			if (text.length() - rowEnd < 0) {
				rowEnd = rowEnd - rowSize + text.length() % rowSize;
				rows.add(text.substring(rowStart, rowEnd));
				textSize += text.length() % rowSize;
			}

		}

		for (String str : rows) {
			System.out.println(str);
		}

		String output = "";

		for (int i = 0; i < rows.get(0).length(); i++) {
			for (String str : rows) {
				if (str.length() > 0) {
					output += str.charAt(i);
				}
			}
		}
		System.out.println(output.substring(0, 30));

	}
}
