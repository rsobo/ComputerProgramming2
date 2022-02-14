
public abstract class GenericMatrix <T extends Number>{

	protected abstract T add(T o1, T o2);
	protected abstract T multiply(T o1, T o2);
	protected abstract T zero();
	
	//adds the elements of 2 matricies
	public T[][] addMatrix(T[][] m1, T[][] m2) throws Exception{
		if(m1.length != m2.length || m1[0].length != m2[0].length){
			throw new Exception("Matricies are not same size");
		}
		
		T[][] result = (T[][]) new Number[m1.length][m2.length];
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				result[i][j] = add(m1[i][j], m2[i][j]);
			}
		}
		return result;
	}
	
	//mulitplies elements of a matricies
	public T[][] multiplyMatrix(T[][] m1, T[][] m2) throws Exception{
		if(m1.length != m2.length || m1[0].length != m2[0].length){
			throw new Exception("Matricies are not same size");
		}
		T[][] result = (T[][]) new Number[m1.length][m2.length];
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				result[i][j] = zero();
				for(int k = 0; k < m1[0].length; k++) {
					result[i][j] = add(result[i][j], multiply(m1[i][k], m2[k][j]));
				}
			}
		}
		return result;
	}
	
	//prints our the matricies
	public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {
		//nested for loop
		//loops through each matrix and prints the matrix
		for(int i = 0; i < m1.length; i++) {
			System.out.print("[");
			for(int j = 0; j < m2.length; j++) {
				System.out.print(m1[i][j] + " ");
			}
			if(i == m1.length-1) {
				System.out.print("]  " + op + "  [");
			}
			else {
				System.out.print("]     [");
			}
			for(int j = 0; j < m2.length; j++) {
				System.out.print(m2[i][j] + " ");
			}
			if(i == m1.length-1) {
				System.out.print("]  = [");
			}
			else {
				System.out.print("]    [");
			}
			for(int j = 0; j < m3.length; j++) {
				System.out.print(m3[i][j] + " ");
			}
			System.out.print("]");
			if(i != m1.length-1 || i != m2.length-1) {
				System.out.print("\n");
			}
		}		
	}
}
