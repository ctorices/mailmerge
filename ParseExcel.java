package mail;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParseExcel {

	private ArrayList<ArrayList<String>> excelData;

	public ParseExcel(String excel){
		excelData = new ArrayList<ArrayList<String>>();
	}

	public ArrayList<ArrayList<String>> parseExcelData(String excel){

		try {

			File myFile = new File(excel); 
			FileInputStream spreadSheet = new FileInputStream(myFile);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(spreadSheet);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
				
			Iterator<Row> rowIterator = mySheet.iterator();
			int i = -1;
			while (rowIterator.hasNext()) { 

				Row row = rowIterator.next();
				i += 1;
				Iterator<Cell> cellIterator = row.cellIterator();
				if(!isRowEmpty(row)){
					excelData.add(new ArrayList<String>());
				}

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						excelData.get(i).add(cell.getStringCellValue()); break;
					case Cell.CELL_TYPE_NUMERIC: 
						excelData.get(i).add(String.valueOf((int)cell.getNumericCellValue())); break;
					case Cell.CELL_TYPE_BOOLEAN: 
						break;
					default : 
					} 
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
/*
		for(int k = 0; k < excelData.size(); k++){
			for (int j = 0; j < excelData.get(k).size(); j++){
				System.out.print(excelData.get(k).get(j) + " ");
			}
			System.out.println();
		}
*/
		return excelData;

	}

	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}

}
