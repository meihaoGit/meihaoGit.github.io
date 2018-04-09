package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiFunctionTest {

	public static void main(String[] args) throws IOException {
		WriteExcel();

		FileInputStream in = null;
		Workbook wb = null;
		try {
			in = new FileInputStream("sample9_1.xls");
			wb = WorkbookFactory.create(in);
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (InvalidFormatException e) {
			System.out.println(e.toString());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		Sheet sheet = wb.getSheetAt(0);
		FormulaEvaluator feval = wb.getCreationHelper().createFormulaEvaluator();

		// FLOOR.MATHフロア・マス（数値, 基準値, モード）
		Row row1 = sheet.getRow(2);
		Cell cell1 = row1.getCell(2);

		feval.evaluateInCell(cell1);
		// FLOOR.MATH(67.89,3) = 66
		System.out.printf(" FLOOR.MATH evaluatedValue : = %s\n ", feval.evaluate(cell1).getNumberValue());

		Row row2 = sheet.getRow(4);
		Cell cell2 = row2.getCell(2);

		feval.evaluateInCell(cell2);
		// FLOOR.PRECISE(1008.123) = 1008
		System.out.printf("FLOOR.PRECISE evaluatedValue : = %s\n ", feval.evaluate(cell2).getNumberValue());

		Row row3 = sheet.getRow(6);
		Cell cell3 = row3.getCell(2);

		feval.evaluateInCell(cell3);
		// CEILING.MATH(24.6,4) = 28
		System.out.printf("CEILING.MATH evaluatedValue : = %s\n ", feval.evaluate(cell3).getNumberValue());

		Row row4 = sheet.getRow(8);
		Cell cell4 = row4.getCell(2);

		feval.evaluateInCell(cell4);
		// ISO.CEILING(4.3) = 5
		System.out.printf("ISO.CEILING evaluatedValue : = %s\n ", feval.evaluate(cell4).getNumberValue());

		Row row5 = sheet.getRow(10);
		Cell cell5 = row5.getCell(2);

		feval.evaluateInCell(cell5);
		
		
		
		// DATESTRING("2009/1/31") = 平成21年01月31日
		System.out.printf("DATESTRING evaluatedValue : = %s\n ", feval.evaluate(cell5).getStringValue());
	}

	private static void WriteExcel() {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();

		FileOutputStream out = null;

		// FLOOR.MATHフロア・マス（数値, 基準値, モード）
		Row row2 = sheet.createRow(2);
		Cell cell1_2 = row2.createCell(2);

		cell1_2.setCellFormula("FloorMath(67.89,3)");

		// FLOOR.PRECISE(数値, [基準値])
		Row row4 = sheet.createRow(4);
		Cell cell1_4 = row4.createCell(2);

		cell1_4.setCellFormula("FloorPrecise(1008.123)");

		// CEILING.MATH (数値, [基準値], [モード])
		Row row6 = sheet.createRow(6);
		Cell cell1_6 = row6.createCell(2);

		cell1_6.setCellFormula("CeilingMath(24.6,4)");

		// ISO.CEILING(数値, [基準値])
		Row row8 = sheet.createRow(8);
		Cell cell1_8 = row8.createCell(2);

		cell1_8.setCellFormula("IsoCeiling(4.3)");

		// ISO.CEILING(数値, [基準値])
		Row row10 = sheet.createRow(10);
		Cell cell1_10 = row10.createCell(2);

		cell1_10.setCellFormula("DateString(\"2009/1/31\")");

		try {
			out = new FileOutputStream("sample9_1.xls");
			wb.write(out);

			System.out.println("write is sample9_1.xls");
			wb.close();

			System.out.println("done!");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}

}
