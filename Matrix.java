//	Andrew Coleman
//	Matrix.java
//	Class for using a matrix of integers
//	and a set of algorithms to perform on the matrix

public class Matrix	{
	private int rows = 0, cols = 0;
	private int[][] matrix;

	// the standard constructor
	public Matrix (int r, int c)	{
		rows = r;cols = c;
		matrix = new int[rows][cols];
	}

	// constructor to use with an array
	public Matrix (int[][] array)	{
		rows = array.length;
		cols = array[0].length;
		matrix = new int[rows][cols];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++)
				matrix[r][c] = array[r][c];
	}

	public int getRows ()	{
		return rows;
	}

	public int getColumns ()	{
		return cols;
	}

	public int getElement (int r, int c)	{
		if (r <= rows && c <= cols)
			return matrix[r][c];
		return -999;
	}

	public Matrix setElement (int r, int c, int value)	{
		if (r <= rows && c <= cols)
			matrix[r][c] = value;
		return this;
	}

	// adds the totals in a row
	public int addRow (int r)	{
		int result = 0;
		for (int i = 0; i < rows; i++)
			result += matrix[r][i];
		return result;
	}

	// adds the totals in a column
	public int addColumn (int c)	{
		int result = 0;
		for (int i = 0; i < cols; i++)
			result += matrix[i][c];
		return result;
	}

	// adds two matrices
	public Matrix add (Matrix m2)	{
		if (m2.getRows() == rows && m2.getColumns() == cols)	{
			int[][] result = new int[rows][cols];
			for (int r = 0; r < rows; r++)
				for (int c = 0; c < cols; c++)
					result[r][c] = this.getElement(r, c) + m2.getElement(r, c);
			return new Matrix(result);
		}
		return this;
	}

	// subtracts two matrices
	public Matrix subtract (Matrix m2)	{
		if (m2.getRows() == rows && m2.getColumns() == cols)	{
			int[][] result = new int[rows][cols];
			for (int r = 0; r < rows; r++)
				for (int c = 0; c < cols; c++)
					result[r][c] = this.getElement(r, c) - m2.getElement(r, c);
			return new Matrix(result);
		}
		return this;
	}

	// multiplies two matricies
	public Matrix multiply (Matrix m2)	{
		if (m2.getRows() == cols && rows == m2.getColumns() )	{
			int[][] result = new int[rows][m2.getColumns()];
			for (int r = 0; r < rows; r++)
				for (int c = 0; c < m2.getColumns(); c++)
					result[r][c] = this.addRow(r) + m2.addColumn(c);
			return new Matrix(result);
		}
		return this;
	}

	// multiplies the current matrix by a scalar value
	public Matrix scalar_multiply (int value)	{
		int[][] result = new int[rows][cols];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++)
				result[r][c] = matrix[r][c] * value;
		return new Matrix(result);
	}

	// checks equality on another matrix
	public boolean equals(Matrix m2)	{
		boolean result = true;
		if (rows == m2.getRows() && cols == m2.getColumns() )
			for (int r = 0; r < rows; r++)
				for (int c = 0; c < cols; c++)
					if (matrix[r][c] != m2.getElement(r, c) && result)
						result = false;
		return result;
	}

	// overridden toString method to give you a very pretty output
	public String toString()	{
		String result = "";
		for (int r = 0; r < rows; r++)	{
			result += " [ ";
			for (int c = 0; c < cols; c++)
				result += (matrix[r][c] + " ");
			result += "]\n";
		}
		return result;
	}
}