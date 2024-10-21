package number200;

public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    breakIsland(grid, i, j);
                }
            }
        }
        return res;
    }

    private void breakIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        breakIsland(grid, i + 1, j);
        breakIsland(grid, i - 1, j);
        breakIsland(grid, i, j + 1);
        breakIsland(grid, i, j - 1);
    }
}