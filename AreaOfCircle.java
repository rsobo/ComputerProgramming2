import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a radius: ");
		double rad = in.nextDouble();
		System.out.println(getAreaOfCircle(rad));
		in.close();
	}

	public static double getAreaOfCircle(double rad) {
		return Math.PI * Math.pow(rad, 2);
	}
}
