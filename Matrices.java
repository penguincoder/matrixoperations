// Andrew Coleman
// Matrices.java
// demonstrates the use of the Matrix class

import Matrix;

public class Matrices	{
	public static void main (String[] args)	{
		int[][] matrix1 = {{1, 1, 1}, {5, 6, 4}, {0, 2, 3}};
		int[][] matrix2 = {{0, 0, 0}, {4, 9, 2}, {1, -2, 6}};
		Matrix m1 = new Matrix(matrix1);
		Matrix m2 = new Matrix(matrix2);
		System.out.println(m1 + "\n");
		System.out.println(m2 + "\n");
		System.out.println("Addition:");
		System.out.println(m1.add(m2)+"\n");
		System.out.println("Subtraction:");
		System.out.println(m1.subtract(m2)+"\n");
		System.out.println("Multiplication:");
		System.out.println(m1.multiply(m2)+"\n");
		System.out.println("scalar multiplication (m1 * 2):");
		System.out.println(m1.scalar_multiply(2)+"\n");
	}
}