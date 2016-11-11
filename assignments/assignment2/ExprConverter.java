import java.util.Scanner;
import java.io.*;

public class ExprConverter {
	
	private String    expression;
	private StringStack strStack = new StringStack();

	public ExprConverter() {
		// Empty Constructor: Ask user for expression

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Infix equation to convert: ");
		expression = input.next();
		input.close();
		validateInput();
	}

	public ExprConverter( String expression ) {
		// Single Argument Constructor: Make expression the string given
		this.expression = expression;
		validateInput();
	}

	public void validateInput() throws RuntimeException {
		for ( int i = 0; i < expression.length(); i++ ) {
			if ( expression.charAt( i ) == '(' ) {
				strStack.push( "(" );
			} else if ( expression.charAt( i ) == ')' ) {
				if ( strStack.isEmpty() ) {
					throw new RuntimeException( "Incorrect Parentheses" );
				}
				strStack.pop();
			}
		}
		if ( !strStack.isEmpty() ) {
			throw new RuntimeException( "Incorrect Parentheses" );
		}

		for ( int i = 0; i < expression.length(); i++ ) {
			// Check if element is in string, if it's not an operand or a closing
			// parentheses it pushes it to stack
			if ( ")+-*/".indexOf( expression.charAt( i ) ) == -1 ) {
				strStack.push( String.valueOf( expression.charAt( i ) ) );
			// Checks if it is an operand or closing parentheses and pops if it is	
			} else if ( ")+-*/".indexOf( expression.charAt( i ) ) != -1 ) {
				// If the stack is empty and a closing parentheses is found
				// that means that there is an extra closing parentheses so
				// so we throw an exception.
				if ( strStack.isEmpty() ) {
					throw new RuntimeException( "Incorrect Variables" );
				}
				strStack.pop();
			}
		}

		// So after pushing all non operand characters and popping all operand characters
		// if we have one character left over then it should be valid, unless it's an
		// opening parentheses which means it's invalid. 
		if ( strStack.isEmpty() || strStack.size() > 1 ) {
			throw new RuntimeException( "Incorrect Variables" );
		
		}
		strStack.clear();
	}

	public String toPostFix() {
		// toPostFix: Convert from infix to postfix
		
		String result = "";
		for ( int i = 0; i < expression.length(); i++ ) {
			boolean stop = false;
			if ( expression.charAt( i ) == '(' ) {
				strStack.push( "(" );
			} else if ( expression.charAt( i ) == ')' ) {
				while ( !strStack.peek().equals( "(" ) ) {
					result += strStack.pop();
				}
				strStack.pop();
			} else if ( expression.charAt( i ) == '*' || expression.charAt( i ) == '/' ) {
				while ( !stop ) {
					if ( strStack.isEmpty() || strStack.peek().equals( "+" ) || strStack.peek().equals( "-" ) || strStack.peek().equals( "(" ) ) {
						strStack.push( String.valueOf( expression.charAt( i ) ) );
						stop = true;
					} else {
						result += strStack.pop();
					}
				}
			} else if ( expression.charAt( i ) == '+' || expression.charAt( i ) == '-' ) {
				while ( !stop ) {
					if ( strStack.isEmpty() || strStack.peek().equals( "(" ) ) {
						strStack.push( String.valueOf( expression.charAt( i ) ) );
						stop = true;
					} else {
						result += strStack.pop();
					} 
				}
			} else {
				result += expression.charAt( i );
			}
		}
		while ( !strStack.isEmpty() ) {
			result += strStack.pop();
		}
		return result;
	}

	public String toPreFix() {
		// toPreFix: Convert from infix to prefix
		
		// strStack = operand stack
		// opStack = operator stack
	
		StringStack opStack = new StringStack();
		String tempExpression = "";

		for ( int i = 0; i < expression.length(); i++ ) {
			boolean stop = false;
			if ( expression.charAt( i ) == '(' ) {
				opStack.push( String.valueOf( expression.charAt( i ) ) );
			} else if ( expression.charAt( i ) == ')' ) {
				while ( !opStack.peek().equals( "(" ) ) {
					String tempStr = strStack.pop();
					tempExpression = opStack.pop() + strStack.pop() + tempStr;
					strStack.push( tempExpression );
				}
				opStack.pop();
			} else if ( expression.charAt( i ) == '*' || expression.charAt( i ) == '/' ) {
				while ( !stop ) {
					if ( opStack.isEmpty() || opStack.peek().equals( "+" ) || opStack.peek().equals( "-" ) || opStack.peek().equals( "(" ) ) {
						opStack.push( String.valueOf( expression.charAt( i ) ) );
						stop = true;
					} else {
						String tempStr = strStack.pop();
						tempExpression = opStack.pop() + strStack.pop() + tempStr;
						strStack.push( tempExpression );
					}
				}

			} else if ( expression.charAt( i ) == '+' || expression.charAt( i ) == '-' ) {
				while ( !stop ) {
					if ( opStack.isEmpty() || opStack.peek().equals( "(" ) ) {
						opStack.push( String.valueOf( expression.charAt( i ) ) );
						stop = true;
					} else {
						String tempStr = strStack.pop();
						tempExpression = opStack.pop() + strStack.pop() + tempStr;
						strStack.push( tempExpression );
					} 
				}
			} else {
				strStack.push( String.valueOf( expression.charAt( i ) ) );
			}
		}
		while ( !opStack.isEmpty() ) {
			String tempStr = strStack.pop();
			tempExpression = opStack.pop() + strStack.pop() + tempStr;
			strStack.push( tempExpression );

		}
		return strStack.pop(); 

	}

	public String toString() {
		return expression;
	}
}
