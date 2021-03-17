class MatrixCalculator {
    public static void main(String[] args) {
        Matrix m = new Matrix(new int[][] {{1, 2},
                                           {3, 4}});

        Matrix n = new Matrix(new int[][] {{5, 6},
                                           {7, 8}});

        System.out.println(m.toString());
        System.out.println(n.toString());
        System.out.println(m.multiply(n).transpose().toString());
    }
}

class Matrix {
    private final int[][] values;

    public Matrix(int[][] matrix) {
        int width = matrix[0].length;
        for(int[] row : matrix) {
            if(row.length != width)
                throw new IllegalArgumentException("All rows of a matrix need to be equally long.");
        }

        this.values = matrix;
    }

    public Matrix add(Matrix m) {
        if(this.values.length != m.values.length || this.values[0].length != m.values[0].length)
            return null;

        for(int row = 0; row < this.values.length; row++) {
            for(int element = 0; element < this.values[row].length; element++) {
                values[row][element] += m.values[row][element];
            }
        }

        return new Matrix(values);
    }

    public Matrix multiply(Matrix m) {
        if(this.values[0].length != m.values.length)
            return null;
        
        int[][] n = this.values;
        int[][] r = new int[this.values.length][m.values[0].length];

        for(int row = 0; row < n.length; row++) {
            for(int col = 0; col < m.values.length; col++) {
                int sum = 0;

                for(int element = 0; element < n.length; element++) {
                    sum += n[row][element] * m.values[element][col];
                }
                
                r[row][col] = sum;
            }
        }

        return new Matrix(r);
    }

    public Matrix transpose() {
        int[][] m = new int[this.values[0].length][this.values.length];

        for(int row = 0; row < this.values.length; row++) {
            for(int element = 0; element < this.values[row].length; element++) {
                m[element][row] = this.values[row][element];
            }
        }

        return new Matrix(m);
    }

    public int[][] getArray() {
        return values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int[] row : values) {
            sb.append("| ");
            for(int ele : row) {
                sb.append(ele);
                sb.append(" ");
            }
            sb.append("|\n");
        }
        return sb.toString();
    }
}
