import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParseExcel {

	private ArrayList<ArrayList<String>> excelData;

	public ParseExcel(){
		excelData = new ArrayList<ArrayList<String>>();
	}

	public ArrayList<ArrayList<String>> parseExcelData(String excel){

		try {

			File myFile = new File(excel); 
			DataFormatter formatData = new DataFormatter();
			FileInputStream spreadSheet = new FileInputStream(myFile);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(spreadSheet);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			for (int rn=mySheet.getFirstRowNum(); rn<=mySheet.getLastRowNum(); rn++) {
				Row row = mySheet.getRow(rn);
				//If row isn't empty, add new ArrayList to excelData
				if (!isRowEmpty(row))
				{
					excelData.add(new ArrayList<String>());
					//Add cell data to current row in ArrayList
					for (int cn=0; cn<row.getLastCellNum(); cn++) 
					{
						Cell cell = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
						//If cell is blank, just add blank 
						if (cell == null) 
							excelData.get(rn).add(formatData.formatCellValue(cell));
						else 
							excelData.get(rn).add(formatData.formatCellValue(cell));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
