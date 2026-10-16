class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int topRow =0;
        int bottomRow = matrix.length-1;
        int leftCol = 0;
        int rightCol = matrix[0].length-1;

        while(topRow <= bottomRow && leftCol <= rightCol){
            for(int j=leftCol;j<=rightCol;j++){
                ans.add(matrix[topRow][j]);
            }
             topRow++;

            // Top to Bottom
            for (int i = topRow; i <= bottomRow; i++) {
                ans.add(matrix[i][rightCol]);
            }
            rightCol--;

            // Right to Left
            if (topRow <= bottomRow) {
                for (int j = rightCol; j >= leftCol; j--) {
                    ans.add(matrix[bottomRow][j]);
                }
                bottomRow--;
            }

            // Bottom to Top
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    ans.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }

        return ans;
    }
}