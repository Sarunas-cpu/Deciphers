import java.util.ArrayList;
import java.util.Arrays;
/*
 * @author Sarunas Valiulis
 */
public class SubstitutionCipherRnd {

	private ArrayList<String> rows;
	private ArrayList<String> rowOrder;

	public SubstitutionCipherRnd() {
		rows = new ArrayList<>();
		rowOrder = new ArrayList<>();
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

		// split the text into given rows length and add them to rows array
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
		String[] rowsOrders2 = {
//				"012345", 
//				"012354", 
//				"012435", 
//				"012453", 
//				"012534", 
//				"012543", 
//				"013245", 
//				"013254", 
//				"013425", 
//				"013452", 
//				"013524", 
//				"013542", 
//				"014235", 
//				"014253", 
//				"014325", 
//				"014352", 
//				"014523", 
//				"014532", 
//				"015234", 
//				"015243", 
//				"015324", 
//				"015342", 
//				"015423", 
//				"015432", 
//				"021345", 
//				"021354", 
//				"021435", 
//				"021453", 
//				"021534", 
//				"021543", 
//				"023145", 
//				"023154", 
//				"023415", 
//				"023451", 
//				"023514", 
//				"023541", 
//				"024135", 
//				"024153", 
//				"024315", 
//				"024351", 
//				"024513", 
//				"024531", 
//				"025134", 
//				"025143", 
//				"025314", 
//				"025341", 
//				"025413", 
//				"025431", 
//				"031245", 
//				"031254", 
//				"031425", 
//				"031452", 
//				"031524", 
//				"031542", 
//				"032145", 
//				"032154", 
//				"032415", 
//				"032451", 
//				"032514", 
//				"032541", 
//				"034125", 
//				"034152", 
//				"034215", 
//				"034251", 
//				"034512", 
//				"034521", 
//				"035124", 
//				"035142", 
//				"035214", 
//				"035241", 
//				"035412", 
//				"035421", 
//				"041235", 
//				"041253", 
//				"041325", 
//				"041352", 
//				"041523", 
//				"041532", 
//				"042135", 
//				"042153", 
//				"042315", 
//				"042351", 
//				"042513", 
//				"042531", 
//				"043125", 
//				"043152", 
//				"043215", 
//				"043251", 
//				"043512", 
//				"043521", 
//				"045123", 
//				"045132", 
//				"045213", 
//				"045231", 
//				"045312", 
//				"045321", 
//				"051234", 
//				"051243", 
//				"051324", 
//				"051342", 
//				"051423", 
//				"051432", 
//				"052134", 
//				"052143", 
//				"052314", 
//				"052341", 
//				"052413", 
//				"052431", 
//				"053124", 
//				"053142", 
//				"053214", 
//				"053241", 
//				"053412", 
//				"053421", 
//				"054123", 
//				"054132", 
//				"054213", 
//				"054231", 
//				"054312", 
//				"054321", 
//				"102345", 
//				"102354", 
//				"102435", 
//				"102453", 
//				"102534", 
//				"102543", 
//				"103245", 
//				"103254", 
//				"103425", 
//				"103452", 
//				"103524", 
//				"103542", 
//				"104235", 
//				"104253", 
//				"104325", 
//				"104352", 
//				"104523", 
//				"104532", 
//				"105234", 
//				"105243", 
//				"105324", 
//				"105342", 
//				"105423", 
//				"105432", 
//				"120345", 
//				"120354", 
//				"120435", 
//				"120453", 
//				"120534", 
//				"120543", 
//				"123045", 
//				"123054", 
//				"123405", 
//				"123450", 
//				"123504", 
//				"123540", 
//				"124035", 
//				"124053", 
//				"124305", 
//				"124350", 
//				"124503", 
//				"124530", 
//				"125034", 
//				"125043", 
//				"125304", 
//				"125340", 
//				"125403", 
//				"125430", 
//				"130245", 
//				"130254", 
//				"130425", 
//				"130452", 
//				"130524", 
//				"130542", 
//				"132045", 
//				"132054", 
//				"132405", 
//				"132450", 
//				"132504", 
//				"132540", 
//				"134025", 
//				"134052", 
//				"134205", 
//				"134250", 
//				"134502", 
//				"134520", 
//				"135024", 
//				"135042", 
//				"135204", 
				"135240",
//				"135402", 
//				"135420", 
//				"140235", 
//				"140253", 
//				"140325", 
//				"140352", 
//				"140523", 
//				"140532", 
//				"142035", 
//				"142053", 
//				"142305", 
//				"142350", 
//				"142503", 
//				"142530", 
//				"143025", 
//				"143052", 
//				"143205", 
//				"143250", 
//				"143502", 
//				"143520", 
//				"145023", 
//				"145032", 
//				"145203", 
//				"145230", 
//				"145302", 
//				"145320", 
//				"150234", 
//				"150243", 
//				"150324", 
//				"150342", 
//				"150423", 
//				"150432", 
//				"152034", 
//				"152043", 
//				"152304", 
//				"152340", 
//				"152403", 
//				"152430", 
//				"153024", 
//				"153042", 
//				"153204", 
//				"153240", 
//				"153402", 
//				"153420", 
//				"154023", 
//				"154032", 
//				"154203", 
//				"154230", 
//				"154302", 
//				"154320", 
//				"201345", 
//				"201354", 
//				"201435", 
//				"201453", 
//				"201534", 
//				"201543", 
//				"203145", 
//				"203154", 
//				"203415", 
//				"203451", 
//				"203514", 
//				"203541", 
//				"204135", 
//				"204153", 
//				"204315", 
//				"204351", 
//				"204513", 
//				"204531", 
//				"205134", 
//				"205143", 
//				"205314", 
//				"205341", 
//				"205413", 
//				"205431", 
//				"210345", 
//				"210354", 
//				"210435", 
//				"210453", 
//				"210534", 
//				"210543", 
//				"213045", 
//				"213054", 
//				"213405", 
//				"213450", 
//				"213504", 
//				"213540", 
//				"214035", 
//				"214053", 
//				"214305", 
//				"214350", 
//				"214503", 
//				"214530", 
//				"215034", 
//				"215043", 
//				"215304", 
//				"215340", 
//				"215403", 
//				"215430", 
//				"230145", 
//				"230154", 
//				"230415", 
//				"230451", 
//				"230514", 
//				"230541", 
//				"231045", 
//				"231054", 
//				"231405", 
//				"231450", 
//				"231504", 
//				"231540", 
//				"234015", 
//				"234051", 
//				"234105", 
//				"234150", 
//				"234501", 
//				"234510", 
//				"235014", 
//				"235041", 
//				"235104", 
//				"235140", 
//				"235401", 
//				"235410", 
//				"240135", 
//				"240153", 
//				"240315", 
//				"240351", 
//				"240513", 
//				"240531", 
//				"241035", 
//				"241053", 
//				"241305", 
//				"241350", 
//				"241503", 
//				"241530", 
//				"243015", 
//				"243051", 
//				"243105", 
//				"243150", 
//				"243501", 
//				"243510", 
//				"245013", 
//				"245031", 
//				"245103", 
//				"245130", 
//				"245301", 
//				"245310", 
//				"250134", 
//				"250143", 
//				"250314", 
//				"250341", 
//				"250413", 
//				"250431", 
//				"251034", 
//				"251043", 
//				"251304", 
//				"251340", 
//				"251403", 
//				"251430", 
//				"253014", 
//				"253041", 
//				"253104", 
//				"253140", 
//				"253401", 
//				"253410", 
//				"254013", 
//				"254031", 
//				"254103", 
//				"254130", 
//				"254301", 
//				"254310", 
//				"301245", 
//				"301254", 
//				"301425", 
//				"301452", 
//				"301524", 
//				"301542", 
//				"302145", 
//				"302154", 
//				"302415", 
//				"302451", 
//				"302514", 
//				"302541", 
//				"304125", 
//				"304152", 
//				"304215", 
//				"304251", 
//				"304512", 
//				"304521", 
//				"305124", 
//				"305142", 
//				"305214", 
//				"305241", 
//				"305412", 
//				"305421", 
//				"310245", 
//				"310254", 
//				"310425", 
//				"310452", 
//				"310524", 
//				"310542", 
//				"312045", 
//				"312054", 
//				"312405", 
//				"312450", 
//				"312504", 
//				"312540", 
//				"314025", 
//				"314052", 
//				"314205", 
//				"314250", 
//				"314502", 
//				"314520", 
//				"315024", 
//				"315042", 
//				"315204", 
//				"315240", 
//				"315402", 
//				"315420", 
//				"320145", 
//				"320154", 
//				"320415", 
//				"320451", 
//				"320514", 
//				"320541", 
//				"321045", 
//				"321054", 
//				"321405", 
//				"321450", 
//				"321504", 
//				"321540", 
//				"324015", 
//				"324051", 
//				"324105", 
//				"324150", 
//				"324501", 
//				"324510", 
//				"325014", 
//				"325041", 
//				"325104", 
//				"325140", 
//				"325401", 
//				"325410", 
//				"340125", 
//				"340152", 
//				"340215", 
//				"340251", 
//				"340512", 
//				"340521", 
//				"341025", 
//				"341052", 
//				"341205", 
//				"341250", 
//				"341502", 
//				"341520", 
//				"342015", 
//				"342051", 
//				"342105", 
//				"342150", 
//				"342501", 
//				"342510", 
//				"345012", 
//				"345021", 
//				"345102", 
//				"345120", 
//				"345201", 
//				"345210", 
//				"350124", 
//				"350142", 
//				"350214", 
//				"350241", 
//				"350412", 
//				"350421", 
//				"351024", 
//				"351042", 
//				"351204", 
//				"351240", 
//				"351402", 
//				"351420", 
//				"352014", 
//				"352041", 
//				"352104", 
//				"352140", 
//				"352401", 
//				"352410", 
//				"354012", 
//				"354021", 
//				"354102", 
//				"354120", 
//				"354201", 
//				"354210", 
//				"401235", 
//				"401253", 
//				"401325", 
//				"401352", 
//				"401523", 
//				"401532", 
//				"402135", 
//				"402153", 
//				"402315", 
//				"402351", 
//				"402513", 
//				"402531", 
//				"403125", 
//				"403152", 
//				"403215", 
//				"403251", 
//				"403512", 
//				"403521", 
//				"405123", 
//				"405132", 
//				"405213", 
//				"405231", 
//				"405312", 
//				"405321", 
//				"410235", 
//				"410253", 
//				"410325", 
//				"410352", 
//				"410523", 
//				"410532", 
//				"412035", 
//				"412053", 
//				"412305", 
//				"412350", 
//				"412503", 
//				"412530", 
//				"413025", 
//				"413052", 
//				"413205", 
//				"413250", 
//				"413502", 
//				"413520", 
//				"415023", 
//				"415032", 
//				"415203", 
//				"415230", 
//				"415302", 
//				"415320", 
//				"420135", 
//				"420153", 
//				"420315", 
//				"420351", 
//				"420513", 
//				"420531", 
//				"421035", 
//				"421053", 
//				"421305", 
//				"421350", 
//				"421503", 
//				"421530", 
//				"423015", 
//				"423051", 
//				"423105", 
//				"423150", 
//				"423501", 
//				"423510", 
//				"425013", 
//				"425031", 
//				"425103", 
//				"425130", 
//				"425301", 
//				"425310", 
//				"430125", 
//				"430152", 
//				"430215", 
//				"430251", 
//				"430512", 
//				"430521", 
//				"431025", 
//				"431052", 
//				"431205", 
//				"431250", 
//				"431502", 
//				"431520", 
//				"432015", 
//				"432051", 
//				"432105", 
//				"432150", 
//				"432501", 
//				"432510", 
//				"435012", 
//				"435021", 
//				"435102", 
//				"435120", 
//				"435201", 
//				"435210", 
//				"450123", 
//				"450132", 
//				"450213", 
//				"450231", 
//				"450312", 
//				"450321", 
//				"451023", 
//				"451032", 
//				"451203", 
//				"451230", 
//				"451302", 
//				"451320", 
//				"452013", 
//				"452031", 
//				"452103", 
//				"452130", 
//				"452301", 
//				"452310", 
//				"453012", 
//				"453021", 
//				"453102", 
//				"453120", 
//				"453201", 
//				"453210", 
//				"501234", 
//				"501243", 
//				"501324", 
//				"501342", 
//				"501423", 
//				"501432", 
//				"502134", 
//				"502143", 
//				"502314", 
//				"502341", 
//				"502413", 
//				"502431", 
//				"503124", 
//				"503142", 
//				"503214", 
//				"503241", 
//				"503412", 
//				"503421", 
//				"504123", 
//				"504132", 
//				"504213", 
//				"504231", 
//				"504312", 
//				"504321", 
//				"510234", 
//				"510243", 
//				"510324", 
//				"510342", 
//				"510423", 
//				"510432", 
//				"512034", 
//				"512043", 
//				"512304", 
//				"512340", 
//				"512403", 
//				"512430", 
//				"513024", 
//				"513042", 
//				"513204", 
//				"513240", 
//				"513402", 
//				"513420", 
//				"514023", 
//				"514032", 
//				"514203", 
//				"514230", 
//				"514302", 
//				"514320", 
//				"520134", 
//				"520143", 
//				"520314", 
//				"520341", 
//				"520413", 
//				"520431", 
//				"521034", 
//				"521043", 
//				"521304", 
//				"521340", 
//				"521403", 
//				"521430", 
//				"523014", 
//				"523041", 
//				"523104", 
//				"523140", 
//				"523401", 
//				"523410", 
//				"524013", 
//				"524031", 
//				"524103", 
//				"524130", 
//				"524301", 
//				"524310", 
//				"530124", 
//				"530142", 
//				"530214", 
//				"530241", 
//				"530412", 
//				"530421", 
//				"531024", 
//				"531042", 
//				"531204", 
//				"531240", 
//				"531402", 
//				"531420", 
//				"532014", 
//				"532041", 
//				"532104", 
//				"532140", 
//				"532401", 
//				"532410", 
//				"534012", 
//				"534021", 
//				"534102", 
//				"534120", 
//				"534201", 
//				"534210", 
//				"540123", 
//				"540132", 
//				"540213", 
//				"540231", 
//				"540312", 
//				"540321", 
//				"541023", 
//				"541032", 
//				"541203", 
//				"541230", 
//				"541302", 
//				"541320", 
//				"542013", 
//				"542031", 
//				"542103", 
//				"542130", 
//				"542301", 
//				"542310", 
//				"543012", 
//				"543021", 
//				"543102", 
//				"543120", 
//				"543201", 
//				"543210"
		};

		String[] newRowsOrdered = new String[rows.size() - 1];
		for (int j = 0; j < rowsOrders2.length; j++) {
			// temporary array to store row orders

			ArrayList<String> tempRows = new ArrayList<>(rows);
			// array containing reaordering order
			String rowsOrder = rowsOrders2[j];
			// reorders the rows in the array to be printed out later
			for (int i = 0; i < tempRows.size() - 1; i++) {
				// System.out.println(Character.getNumericValue(rowsOrder.charAt(i)));
				newRowsOrdered[i] = tempRows.get(Character.getNumericValue(rowsOrder.charAt(i)));
			}
			// System.out.println(Arrays.asList(newRowsOrdered));
			tempRows = new ArrayList<>(Arrays.asList(newRowsOrdered));
//			System.out.println(tempRows);
//			for(String str: rows) {
//				System.out.println(str);
//			}
			// takes the rows from the row arrays, combines the rows and reads them
			// cullumnwise while generating an output
			String output = "";

			for (int i = 0; i < tempRows.get(0).length(); i++) {
				for (String str : tempRows) {
					if (str.length() > 0) {
						output += str.charAt(i);
					}
				}
			}
			if (output.contains("THE"))
				if (output.contains("SS"))
					if (output.contains("EE"))
						if (output.contains("WAS"))
							System.out.println(j + "index " + rowsOrder + " " + output.substring(0, 30));

		}
	}

}