public class ExprConverterTest {
	public static void main ( String[] args ) {
		// 5 Test cases to test out functionality
		ExprConverter Expression1 = new ExprConverter("a+b+c");
		System.out.println( "Infix Expression: " + Expression1 );
		System.out.println( "Postfix Expression: " + Expression1.toPostFix() );
		System.out.println( "Prefix Expression: " + Expression1.toPreFix() );
		System.out.println();

		ExprConverter Expression2 = new ExprConverter("a+b*c");
		System.out.println( "Infix Expression: " + Expression2 );
		System.out.println( "Postfix Expression: " + Expression2.toPostFix() );
		System.out.println( "Prefix Expression: " + Expression2.toPreFix() );
		System.out.println();

		ExprConverter Expression3 = new ExprConverter("(a+b)*(c-d)");
		System.out.println( "Infix Expression: " + Expression3 );
		System.out.println( "Postfix Expression: " + Expression3.toPostFix() );
		System.out.println( "Prefix Expression: " + Expression3.toPreFix() );
		System.out.println();

		ExprConverter Expression4 = new ExprConverter("(a*(b+(c/d)))");
		System.out.println( "Infix Expression: " + Expression4 );
		System.out.println( "Postfix Expression: " + Expression4.toPostFix() );
		System.out.println( "Prefix Expression: " + Expression4.toPreFix() );
		System.out.println();

		ExprConverter Expression5 = new ExprConverter("(a+b-c)*(e/f)-(g-h/i)");
		System.out.println( "Infix Expression: " + Expression5 );
		System.out.println( "Postfix Expression: " + Expression5.toPostFix() );
		System.out.println( "Prefix Expression: " + Expression5.toPreFix() );
		System.out.println();

		// Final one allows input
		ExprConverter Expression6 = new ExprConverter();
		System.out.println( "Infix Expression: " + Expression6 );
		System.out.println( "Postfix Expression: " + Expression6.toPostFix() );
		System.out.println( "Prefix Expression: " + Expression6.toPreFix() );

	}
}
