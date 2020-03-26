import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		//get excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\Cam\\Documents\\GitHub\\Selenium-Frameworks\\ExcelDriven\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		ArrayList<String> a = new ArrayList<String>();

		// find the sheet with the test data
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// scan the first row for the "testcase" column
				// example code - does not actually do anything because there is no error
				// checking
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0, column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("testcase")) {
						column = k;
					}
					k++;
				}

				// find the test case row and return the row with all of the data in that row
				// (does not contain error checking)
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING)
								a.add(c.getStringCellValue());
							else
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				}
			}
		}
		return a;
	}
}