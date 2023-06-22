package MediumProblems;

public class NumOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','1','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int counter=0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j]=='1' && !isVisited[i][j])
                {
                    dfs(grid,i,j);
                    counter++;
                }
            }
        }
        return counter;
    }
    public static void dfs(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=grid.length || j>= grid[0].length ||  grid[i][j]=='0')
            return ;
//        isVisited[i][j] = true;
        grid[i][j]='0';

        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i-1,j);

    }

}
