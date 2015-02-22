package net.aerenserve.starport.architecture;

import java.util.ArrayList;
import java.util.List;

public class Architecture {
	
	public enum Type {
		BASIC(1),
		LUXURY(3),
		ADVANCED(7),
		MILITARY(6);
		
		public final int terminals;
		
		private Type(int terminals) {
			this.terminals = terminals;
		}
	}
	
	private List<Terminal> terminals;
	
	public Architecture(List<Terminal> terminals) {
		this.terminals = terminals;
	}
	
	public List<Terminal> getTerminals() {
		return this.terminals;
	}
	
	public static Architecture getFromType(Architecture.Type type, Terminal.Size size) {
		List<Terminal> terminals = new ArrayList<Terminal>(); 
		for(int i = 0; i < type.terminals; i++) {
			Terminal t = new Terminal(getCharForNumber(i));
			for(int s = 0; s < size.gates; s++) {
				t.addGate(new Gate(s+1, t));
			}
		}
		return new Architecture(terminals);
	}
	
	private static String getCharForNumber(int i) {
	    return i > -1 && i < 26 ? String.valueOf((char)(i + 65)) : null;
	}

}