package com.test.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class CreateExcel {

	public static void readXLSFile() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream("C:/Test.xls");
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();

			while (cells.hasNext()) {
				cell = (HSSFCell) cells.next();

				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue() + " ");
				} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
				} else {
					// U Can Handle Boolean, Formula, Errors
				}
			}
			System.out.println();
		}

	}

	public static void writeXLSFile(String FileName, String Path, Object[] values, int RowCount) throws IOException {

		String excelFileName = Path + "/" + FileName; // name of excel file with
														// path

		String sheetName = "Sheet1";// name of sheet

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);

		HSSFCellStyle RedStyle = wb.createCellStyle();
		{
			RedStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
		}
		HSSFCellStyle GreenStyle = wb.createCellStyle();
		{
			GreenStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		}
		HSSFCellStyle YellowStyle = wb.createCellStyle();
		{
			YellowStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
		}
		HSSFCellStyle AllCellStyle = wb.createCellStyle();
		{
			AllCellStyle.setWrapText(true);
		}
		sheet.setColumnWidth(2, 1000);

		// iterating r number of rows

		HSSFRow row = sheet.createRow(RowCount);

		// iterating c number of columns
		for (int c = 0; c < values.length; c++) {
			HSSFCell cell = row.createCell(c);
			if (values[c].equals("PASS"))
				cell.setCellStyle(GreenStyle);
			else if (values[c].equals("FAIL"))
				cell.setCellStyle(RedStyle);
			else if (values[c].equals("SKIP"))
				cell.setCellStyle(YellowStyle);
			else {

			}

			cell.setCellValue(values[c].toString());

		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		// write this workbook to an OutputStream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}
