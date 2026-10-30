class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<List<Integer>> boxSeen = new HashSet<>();
        Set<Character>[] colSeen = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            colSeen[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            Set<Character> rowSeen = new HashSet<>();

            for (int col = 0; col < 9; col++) {

                char digit = board[row][col];

                if (digit == '.') {
                    continue;
                }

                List<Integer> square = Arrays.asList(
                    digit - '0', row / 3, col / 3
                );

                if (rowSeen.contains(digit) ||
                    colSeen[col].contains(digit) ||
                    boxSeen.contains(square)) {
                    return false;
                }

                rowSeen.add(digit);
                colSeen[col].add(digit);
                boxSeen.add(square);
            }
        }

        return true;
    }
}