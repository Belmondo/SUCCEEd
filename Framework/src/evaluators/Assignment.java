package evaluators;

import java.util.HashMap;

public class Assignment {
	
	private HashMap<String, Object> assignments;

	public Assignment() {
		this.assignments = new HashMap<String, Object>();
	}

	public void assign(String symbol, Boolean value) {
		this.assignments.put(symbol, value);
	}

	public Boolean booleanValue(String symbol) {
		return (Boolean) this.assignments.get(symbol);
	}

	public void assign(String symbol, String value) {
		this.assignments.put(symbol, value);
	}

	public String stringValue(String symbol) {
		return (String) this.assignments.get(symbol);
	}

	public void assign(String symbol, Number value) {
		this.assignments.put(symbol, value);
	}

	public Number numberValue(String symbol) {
		return (Number) this.assignments.get(symbol);
	}

}
