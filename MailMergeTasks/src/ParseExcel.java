import java.awt.List;
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
	
	public static void main(String [] args){
		
		ArrayList<String[]> excelData = new ArrayList<String[]>();
	
		try {

			File myFile = new File("Book1.xlsx"); 
			FileInputStream spreadSheet = new FileInputStream(myFile);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(spreadSheet);
			
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();
			
			while (rowIterator.hasNext()) { 
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator(); 
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING: 
							//System.out.print(cell.getStringCellValue() + "\t");  
							excelData.add(new String[] {cell.getStringCellValue()});
							break;
						case Cell.CELL_TYPE_NUMERIC: 
							System.out.print(cell.getNumericCellValue() + "\t"); break;
						case Cell.CELL_TYPE_BOOLEAN: 
							System.out.print(cell.getBooleanCellValue() + "\t"); break; 
						default : 
					} 
				}
				System.out.println("");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
