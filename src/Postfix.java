import java.util.Stack;

public class Postfix {
	
	public int evaluate(String pfx) {		
		Stack<Object> stackforDigits = new Stack<Object>();
		int result = 0;
		int firstdigit = 0;
		int seconddigit = 0;

		char[] c = pfx.toCharArray();
		
		for (char chr: c) {
			if(Character.isDigit(chr)){
				stackforDigits.push(chr);	
			} else if (!(Character.isDigit(chr))){
				
				firstdigit = Integer.parseInt(stackforDigits.pop().toString());
				seconddigit = Integer.parseInt(stackforDigits.pop().toString());
				
				switch(chr) {
				case '+':
					result = seconddigit+firstdigit;
					break;
				case '/':
					result = seconddigit/firstdigit;
					break;
				case '-':	
					result = seconddigit-firstdigit;
					break;
				case '*' :
					result = seconddigit*firstdigit;
					break;	
				}
				stackforDigits.push(result);
				}
		}
		return result;
	}

}
