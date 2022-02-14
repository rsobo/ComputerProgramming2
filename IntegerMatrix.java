
public class IntegerMatrix extends GenericMatrix<Integer>{

	//returns 2 numbers added
	@Override
	protected Integer add(Integer o1, Integer o2) {
		return o1 + o2;
	}

	//returns 2 numbers multiplied
	@Override
	protected Integer multiply(Integer o1, Integer o2) {
		return o1 * o2;
	}

	//returns 0
	@Override
	protected Integer zero() {
		return 0;
	}

}
