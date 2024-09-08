package PDFScanner;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class Manager {
	public static void main(String[] args) {
		// Specify the path to your PDF file

		File file = new File("/Users/ethan/Desktop/Statements/Statement.pdf");

		try {
			// Load the PDF document
			PDDocument document = Loader.loadPDF(file);
			// Instantiate PDFTextStripper to extract text
			PDFTextStripper pdfStripper = new PDFTextStripper();
			// Extract text from the document
			String text = pdfStripper.getText(document);
			getDeposits(text);
			// Print the extracted text
//            System.out.println(text);

			// Close the document
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getDeposits(String text) {
		int transNum = 0;
		int count = 0;
		int range = 100;
		StringBuilder deposits = new StringBuilder();
		char[] charArray = text.toCharArray();
		for (int i = 0; i < charArray.length - 3; i++) {
			boolean check = true;
			count = 0;
			if (charArray[i] == 'F' && charArray[i + 1] == 'r' && charArray[i + 2] == 'o' && charArray[i + 3] == 'm') {
				transNum++;

				for (int j = i; j < i + range; j++) {
					deposits.append(charArray[j]);
				}

				deposits.append(System.lineSeparator());

			}

		}

		System.out.println(deposits.toString());
	}

}
