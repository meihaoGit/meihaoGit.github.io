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

		// DATEDIF(開始日,終了日,"YD")

		Row row6 = sheet.getRow(12);
		Cell cell6 = row6.getCell(2);

		feval.evaluateInCell(cell6);

		// CEILING.PRECISE(14,5) = 15
		System.out.printf("CEILING.PRECISE evaluatedValue : = %s\n ", feval.evaluate(cell6).getStringValue());

		Row row7 = sheet.getRow(14);
		Cell cell7 = row7.getCell(2);

		feval.evaluateInCell(cell7);

		// ISOWEEKNUM(DATE(2018,1,15)) = 3
		System.out.printf("ISOWEEKNUM evaluatedValue : = %s\n ", feval.evaluate(cell7).getNumberValue());

		Row row8 = sheet.getRow(16);
		Cell cell8 = row8.getCell(2);

		feval.evaluateInCell(cell8);

		// UNICODE("B") = 66
		System.out.printf("UNICODE evaluatedValue : = %s\n ", feval.evaluate(cell8).getNumberValue());
		// System.out.printf("UNICODE evaluatedValue : = %s\n ", sbyte[0]);

		Row row9 = sheet.getRow(18);
		Cell cell9 = row9.getCell(2);

		feval.evaluateInCell(cell9);

		// UNICHAR(3042) =  あ
		System.out.printf("UNICHAR evaluatedValue : = %s\n ", feval.evaluate(cell9).getStringValue());

		Row row10 = sheet.getRow(20);
		Cell cell10 = row10.getCell(2);

		feval.evaluateInCell(cell10);

		// JIS("ｶﾀｶﾞﾅ") = 3
		System.out.printf("JIS evaluatedValue : = %s\n ", feval.evaluate(cell10).getStringValue());

		Row row11 = sheet.getRow(22);
		Cell cell11 = row11.getCell(2);

		feval.evaluateInCell(cell11);

		// TIMEVALUE("18:45")   0.78125
		System.out.printf("TIMEVALUE evaluatedValue : = %s\n ", feval.evaluate(cell11).getNumberValue());

		Row row12 = sheet.getRow(24);
		Cell cell12 = row12.getCell(2);

		feval.evaluateInCell(cell12);

		// DateValue("2018/04/08")   43198
		System.out.printf("DATEVALUE evaluatedValue : = %s\n ", feval.evaluate(cell12).getNumberValue());

		Row row13 = sheet.getRow(26);
		Cell cell13 = row13.getCell(2);

		feval.evaluateInCell(cell13);

		// ARABIC("LVII")   57
		System.out.printf("ARABIC evaluatedValue : = %s\n ", feval.evaluate(cell13).getStringValue());

		Row row14 = sheet.getRow(28);
		Cell cell14 = row14.getCell(2);

		feval.evaluateInCell(cell14);

		// Yen(99.888)   ¥99.89
		System.out.printf("YEN evaluatedValue : = %s\n ", feval.evaluate(cell14).getStringValue());

		Row row15 = sheet.getRow(30);
		Cell cell15 = row15.getCell(3);

		feval.evaluateInCell(cell15);

		// IFS(C30>=90,"出荷可",C30>=80,"再検査",TRUE,"開発中止")
		System.out.printf("IFS evaluatedValue : = %s\n ", feval.evaluate(cell15).getStringValue());

		Row row16 = sheet.getRow(32);
		Cell cell16 = row16.getCell(2);

		feval.evaluateInCell(cell16);

		// XOR(100>=60,100>=70,100>=90) TRUE
		System.out.printf("XOR evaluatedValue : = %s\n ", feval.evaluate(cell16).getBooleanValue());

		Row row17 = sheet.getRow(34);
		Cell cell17 = row17.getCell(2);

		feval.evaluateInCell(cell17);

		// NUMBERSTRING(12345,3)   一二三四五
		System.out.printf("NUMBERSTRING evaluatedValue : = %s\n ", feval.evaluate(cell17).getStringValue());

		Row row18 = sheet.getRow(36);
		Cell cell18 = row18.getCell(3);

		feval.evaluateInCell(cell18);

		// SWITCH(B3,1,"日",2,"月",3,"火",4,"水",5,"木",6,"金",7,"土") "日"
		System.out.printf("SWITCH evaluatedValue : = %s\n ", feval.evaluate(cell18).getStringValue());

		Row row19 = sheet.getRow(38);
		Cell cell19 = row19.getCell(4);

		feval.evaluateInCell(cell19);

		// ISFORMULA(C39:C40)
		System.out.printf("ISFORMULA evaluatedValue : = %s\n ", feval.evaluate(cell19).getBooleanValue());

		Row row20 = sheet.getRow(40);
		Cell cell20 = row20.getCell(3);

		feval.evaluateInCell(cell20);

		// NUMBERVALUE(\"12,345\") 12345
		System.out.printf("NUMBERVALUE evaluatedValue : = %s\n ", feval.evaluate(cell20).getNumberValue());

		Row row21 = sheet.getRow(42);
		Cell cell21 = row21.getCell(4);

		feval.evaluateInCell(cell21);

		// DATEDIF(C42,D42)
		System.out.printf("DATEDIF evaluatedValue : = %s\n ", feval.evaluate(cell21).getNumberValue());

		Row row22 = sheet.getRow(44);
		Cell cell22 = row22.getCell(5);

		feval.evaluateInCell(cell22);

		// CONCAT(C45,D45,E5)
		System.out.printf("CONCAT evaluatedValue : = %s\n ", feval.evaluate(cell22).getStringValue());

		Row row23 = sheet.getRow(46);
		Cell cell23 = row23.getCell(8);

		feval.evaluateInCell(cell23);

		// TEXTJOIN(" ,",FALSE,C47,D47,E47)
		System.out.printf("TEXTJOIN evaluatedValue : = %s\n ", feval.evaluate(cell23).getStringValue());

		Row row24 = sheet.getRow(48);
		Cell cell24 = row24.getCell(2);

		feval.evaluateInCell(cell24);

		//REPLACEB("abcdefghijk",3,1,"2")
		System.out.printf("REPLACEB evaluatedValue : = %s\n ", feval.evaluate(cell24).getStringValue());

		Row row25 = sheet.getRow(50);
		Cell cell25 = row25.getCell(3);

		feval.evaluateInCell(cell25);

		// TEXTJOIN(" ,",FALSE,C47,D47,E47)
		System.out.printf("CELL evaluatedValue : = %s\n ", feval.evaluate(cell25).getStringValue());

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

		// DATESTRING("2009/1/31")
		Row row10 = sheet.createRow(10);
		Cell cell1_10 = row10.createCell(2);

		cell1_10.setCellFormula("DateString(\"2009/1/31\")");

		// CEILING.PRECISE(数値,基準値)
		Row row12 = sheet.createRow(12);
		Cell cell1_12 = row12.createCell(2);

		cell1_12.setCellFormula("CeilingPrecise(14,5)");

		// ISOWEEKNUM(日付)
		Row row14 = sheet.createRow(14);
		Cell cell1_14 = row14.createCell(2);

		cell1_14.setCellFormula("IsoWeekNum(DATE(2018,1,15))");

		// UNICODE(日付文字列)
		Row row16 = sheet.createRow(16);
		Cell cell1_16 = row16.createCell(2);

		cell1_16.setCellFormula("UNICODE(\"B\")");

		// UNICHAR 文字コード（Unicode）に対応する文字を返す
		Row row18 = sheet.createRow(18);
		Cell cell1_18 = row18.createCell(2);

		cell1_18.setCellFormula("UNICHAR(3042)");

		// JIS("ｶﾀｶﾞﾅ")
		Row row20 = sheet.createRow(20);
		Cell cell1_20 = row20.createCell(2);

		cell1_20.setCellFormula("Jis(\"ｶﾀｶﾞﾅ\")");

		// TIMEVALUE(時刻文字列)
		Row row22 = sheet.createRow(22);
		Cell cell1_22 = row22.createCell(2);

		cell1_22.setCellFormula("TIMEVALUE(\"18:45\")");

		// DATEVALUE(日付文字列)
		Row row24 = sheet.createRow(24);
		Cell cell1_24 = row24.createCell(2);

		cell1_24.setCellFormula("DateValue(\"2018/04/08\")");

		// ARABIC(文字列)
		Row row26 = sheet.createRow(26);
		Cell cell1_26 = row26.createCell(2);

		cell1_26.setCellFormula("Arabic(\"LVII\")");

		// YEN(数値, [桁数])
		Row row28 = sheet.createRow(28);
		Cell cell1_28 = row28.createCell(2);

		cell1_28.setCellFormula("YEN(99.888,4)");

		// IFS (論理式1, 真の場合1, 論理式2, 真の場合2, ..., 論理式127, 真の場合127)
		Row row30 = sheet.createRow(30);
		Cell cell1_30 = row30.createCell(2);
		Cell cell1_31 = row30.createCell(3);

		cell1_30.setCellValue(90.5);

		cell1_31.setCellFormula("IFS(C31>=90,\"出荷可\",C31>=80,\"再検査\",TRUE,\"開発中止\")");

		// XOR(論理式 1, [論理式 2],…)
		Row row32 = sheet.createRow(32);
		Cell cell1_32 = row32.createCell(2);
		cell1_32.setCellFormula("XOR(100>=60,100>=70,100>=90)");

		// NUMBERSTRING （数値, 形式）
		Row row34 = sheet.createRow(34);
		Cell cell1_34 = row34.createCell(2);

		cell1_34.setCellFormula("NUMBERSTRING(\"12345\",\"2\")");

		// SWITCH(評価値, 値1, 結果1, 値2, 結果2・・・, 既定値)
		Row row36 = sheet.createRow(36);
		Cell cell1_36 = row36.createCell(2);
		Cell cell1_37 = row36.createCell(3);

		cell1_36.setCellValue(3);

		cell1_37.setCellFormula("SWITCH(C37,1,\"日\",2,\"月\",3,\"火\",4,\"水\",5,\"木\",6,\"金\",7,\"土\")");

		// ISFORMULA(範囲)
		Row row38 = sheet.createRow(38);
		Cell cell1_38 = row38.createCell(2);
		Cell cell1_39 = row38.createCell(3);
		Cell cell1_40 = row38.createCell(4);

		cell1_38.setCellFormula("MOD(34,4)");
		cell1_39.setCellValue(50.5);
		cell1_40.setCellFormula("ISFORMULA(C39:D39)");

		// NUMBERVALUE(文字列, [Decimal_separator], [Group_separator ])]
		Row row40 = sheet.createRow(40);
		Cell cell1_41 = row40.createCell(2);
		Cell cell1_41_1 = row40.createCell(3);
		cell1_41.setCellValue("12347756.00");

		cell1_41_1.setCellFormula("NUMBERVALUE(C41)");

		// DATEDIF(開始日, 終了日, "単位")
		Row row42 = sheet.createRow(42);
		Cell cell1_42 = row42.createCell(2);
		Cell cell1_43 = row42.createCell(3);
		Cell cell1_44 = row42.createCell(4);

		cell1_42.setCellValue("2017/5/31");
		cell1_43.setCellValue("2018/10/01");

		cell1_44.setCellFormula("DATEDIF(C43,D43,\"D\")");

		// CONCAT(文字列 1 [文字列 2], ...)
		Row row44 = sheet.createRow(44);
		Cell cell1_44_1 = row44.createCell(2);
		Cell cell1_44_2 = row44.createCell(3);
		Cell cell1_44_3 = row44.createCell(4);
		Cell cell1_44_4 = row44.createCell(5);

		cell1_44_1.setCellValue("CONCATテスト");
		cell1_44_2.setCellValue("文字列 2");
		cell1_44_3.setCellValue("文字列 3");

		cell1_44_4.setCellFormula("CONCAT(C45,D45,E45)");

		// TEXTJOIN(区切り記号, 空の文字列を無視, 文字列1, 文字列2, ..., 文字列252)
		Row row45 = sheet.createRow(46);
		Cell cell1_45_1 = row45.createCell(2);
		Cell cell1_45_2 = row45.createCell(3);
		Cell cell1_45_3 = row45.createCell(4);
		Cell cell1_45_4 = row45.createCell(5);
		Cell cell1_45_5 = row45.createCell(6);
		Cell cell1_45_6 = row45.createCell(7);
		Cell cell1_45_7 = row45.createCell(8);

		cell1_45_1.setCellValue(" ,");
		cell1_45_2.setCellValue("FALSE");
		cell1_45_3.setCellValue("TEXTJOINテスト");
		cell1_45_4.setCellValue("文字列 2");
		cell1_45_5.setCellValue("");
		cell1_45_6.setCellValue("文字列 3");

		//cell1_45_6.setCellFormula("TEXTJOIN(\",\",\"FALSE\",E47,F47,G47,H47)");
		cell1_45_7.setCellFormula("TEXTJOIN(C47,D47,E47,F47,G47,H47)");

		// REPLACEB(文字列, 開始位置, バイト数, 置換文字列)
		Row row48 = sheet.createRow(48);
		Cell cell1_48 = row48.createCell(2);

		cell1_48.setCellFormula("REPLACEB(\"abcdghijk\",5,1,\"2\")");

		// CELL(検査の種類, [対象範囲])
		Row row49 = sheet.createRow(50);
		Cell cell1_49 = row49.createCell(2);
		Cell cell1_50 = row49.createCell(3);

		cell1_49.setCellValue("TEXTJOIN ありがとうございます。contents");

		cell1_50.setCellFormula("CELL(\"contents\",C51)");

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
