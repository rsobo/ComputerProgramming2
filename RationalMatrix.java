
public class RationalMatrix extends GenericMatrix<Rational> {

	//returns the sum of 2 numbers
	@Override
	protected Rational add(Rational o1, Rational o2) {
		return o1.add(o2);
	}

	//returns the product of 2 numbers
	@Override
	protected Rational multiply(Rational o1, Rational o2) {
		return o1.multiply(o2);
	}

	//returns 0
	@Override
	protected Rational zero() {
		return new Rational(0, 1);
	}

}
