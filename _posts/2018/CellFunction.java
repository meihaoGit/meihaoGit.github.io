package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DataFormatter;

public class CellFunction extends Var1or2ArgFunction implements FreeRefFunction {

	private static final String TYPE_G = "G";
	private static final String TYPE_F0 = "F0";
	private static final String TYPE_COMMA_0 = ",0";
	private static final String TYPE_F2 = "F2";
	private static final String TYPE_COMMA_2 = ",2";
	private static final String TYPE_C0 = "C0";
	private static final String TYPE_MINUS_C0 = "C0-";
	private static final String TYPE_C2 = "C2";
	private static final String TYPE_MINUS_C2 = "C2-";
	private static final String TYPE_P0 = "P0";
	private static final String TYPE_P2 = "P2";
	private static final String TYPE_S2 = "S2";
	private static final String TYPE_D4 = "D4";
	private static final String TYPE_D1 = "D1";
	private static final String TYPE_D2 = "D2";
	private static final String TYPE_D3 = "D3";
	private static final String TYPE_D5 = "D5";
	private static final String TYPE_D7 = "D7";
	private static final String TYPE_D6 = "D6";
	private static final String TYPE_D9 = "D9";
	private static final String TYPE_D8 = "D8";

	protected static final DataFormatter formatter = new DataFormatter();

	public ValueEval evaluate(ValueEval[] args, OperationEvaluationContext ec) {
		if (args.length == 1) {
			return evaluate(ec.getRowIndex(), ec.getColumnIndex(), args[0]);
		} else if (args.length == 2) {
			return evaluate(ec.getRowIndex(), ec.getColumnIndex(), args[0], args[1]);
		} else {
			return ErrorEval.VALUE_INVALID;
		}
	}

	public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval typeInfo) {
		return new StringEval("");
	}

	public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval typeInfo, ValueEval argsVE) {
		return new StringEval("");
	}

}
