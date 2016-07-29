public class Solution {
    /**
     * @param matrix Image matrix to rotate
     * @return  Rotated image matrix by 90 degrees
     */
    public int[][] rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return matrix;

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                // save top
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }

        return matrix;
    }
}