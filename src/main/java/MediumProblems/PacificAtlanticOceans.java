package MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticOceans {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        byte[][] grid = new byte[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<rows;++i){
            dfs(i, 0, 1, Integer.MIN_VALUE, grid, heights, result);
            dfs(i, cols-1, 2, Integer.MIN_VALUE, grid, heights, result);
        }

        for(int i=0;i<cols;++i){
            dfs(0, i, 1, Integer.MIN_VALUE, grid, heights, result);
            dfs(rows-1, i, 2, Integer.MIN_VALUE, grid, heights, result);
        }

        return result;
    }

    private static void dfs(int x, int y, int value, int prevH, byte [][]grid, int [][]heights, List<List<Integer>> result){
        if(x < 0 || y < 0 || x == heights.length || y == heights[0].length){
            return;
        }
        if((grid[x][y] & value) > 0){
            return;
        }
        int h = heights[x][y];
        if(prevH > h){
            return;
        }
        grid[x][y] |= value;
        if(grid[x][y] == 3){
            result.add(Arrays.asList(x, y));
        }
        dfs(x+1, y, value, h, grid, heights, result);
        dfs(x, y+1, value, h, grid, heights, result);
        dfs(x-1, y, value, h, grid, heights, result);
        dfs(x, y-1, value, h, grid, heights, result);
    }

//    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
//        List<List<Integer>> coordinates = new ArrayList<>();
//        int rows = heights.length, cols = heights[0].length;
//        boolean[][] pacific = new boolean[rows][cols];
//        boolean[][] atlantic = new boolean[rows][cols];
//        for (int i=0; i<cols; i++) {
//            dfs(0,i,Integer.MIN_VALUE,pacific,heights);
//            dfs(rows-1,i,Integer.MIN_VALUE,atlantic,heights);
//        }
//
//        for (int i=0; i<rows; i++) {
//            dfs(i,0,Integer.MIN_VALUE,pacific,heights);
//            dfs(i,cols-1,Integer.MIN_VALUE,atlantic,heights);
//        }
//        for (int i=0;i<rows;i++)
//        {
//            for (int j=0;j<cols;j++)
//            {
//                if (pacific[i][j] && atlantic[i][j])
//                    coordinates.add(Arrays.asList(i,j));
//            }
//        }
//        return coordinates;
//    }
//    public static void dfs(int i, int j, int previous, boolean[][] isVisited, int[][] heights) {
//        if(i<0 || j<0 || i>= isVisited.length || j>= isVisited[0].length
//                || isVisited[i][j]==true || heights[i][j]<previous)
//            return;
//        isVisited[i][j] = true;
//        dfs(i+1,j,heights[i][j],isVisited,heights);
//        dfs(i,j+1,heights[i][j],isVisited,heights);
//        dfs(i-1,j,heights[i][j],isVisited,heights);
//        dfs(i,j-1,heights[i][j],isVisited,heights);
//
//    }
//    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
//        List<List<Integer>> coordinates = new ArrayList<>();
//        boolean[][] isVisited = new boolean[heights.length][heights[0].length];
//        for (int i=0;i<heights.length;i++)
//        {
//            for (int j=0;j<heights[0].length;j++)
//            {
//                if (i==1 && j==3)
//                {
//                    System.out.println("test");
//                }
//                if (dfsPacfic(heights,i,j,i,j,coordinates,isVisited) && dfsAtlantic(heights,i,j,i,j,coordinates,isVisited))
//                {
//                    coordinates.add(Arrays.asList(i,j));
//                }
//            }
//        }
//        return coordinates;
//    }
//
//    public static boolean dfs(int[][] heights, int i, int j, int oldI, int oldJ , List<List<Integer>> coordinates, boolean[][] isVisited) {
//        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length)
//            return true;
//
//        boolean check = false;
//
//        if ((heights[i][j]<=heights[oldI][oldJ] || (i==oldI && j==oldJ)) && (!isVisited[i][j] || (i==oldI && j==oldJ)))
//        {
//            isVisited[i][j]=true;
//            check = (dfs(heights,i-1,j,i,j,coordinates,isVisited)||
//                    dfs(heights,i,j-1,i,j,coordinates,isVisited)) &&
//                    (dfs(heights,i+1,j,i,j,coordinates,isVisited)||
//                    dfs(heights,i,j+1,i,j,coordinates,isVisited));
//            isVisited[i][j]=false;
//        }
//
//        return check;
//    }
//
//    public static boolean dfsPacfic(int[][] heights, int i, int j, int oldI, int oldJ , List<List<Integer>> coordinates, boolean[][] isVisited) {
//        if(i<0 || j<0)
//            return true;
//        if(i>=heights.length || j>=heights[0].length)
//            return false;
//
//        boolean check = false;
//
//        if ((heights[i][j]<=heights[oldI][oldJ] || (i==oldI && j==oldJ)) && (!isVisited[i][j] || (i==oldI && j==oldJ)))
//        {
//            isVisited[i][j]=true;
//            check = dfsPacfic(heights,i-1,j,i,j,coordinates,isVisited)||
//                    dfsPacfic(heights,i,j-1,i,j,coordinates,isVisited) ||
//                    dfsPacfic(heights,i+1,j,i,j,coordinates,isVisited)||
//                    dfsPacfic(heights,i,j+1,i,j,coordinates,isVisited);
//            isVisited[i][j]=false;
//        }
//
//        return check;
//    }
//
//    public static boolean dfsAtlantic(int[][] heights, int i, int j, int oldI, int oldJ , List<List<Integer>> coordinates, boolean[][] isVisited) {
//
//        if(i>=heights.length || j>=heights[0].length)
//            return true;
//        if(i<0 || j<0)
//            return false;
//
//        boolean check = false;
//
//        if ((heights[i][j]<=heights[oldI][oldJ] || (i==oldI && j==oldJ)) && (!isVisited[i][j] || (i==oldI && j==oldJ)))
//        {
//            isVisited[i][j]=true;
//            check = dfsAtlantic(heights,i-1,j,i,j,coordinates,isVisited)||
//                    dfsAtlantic(heights,i,j-1,i,j,coordinates,isVisited) ||
//                    dfsAtlantic(heights,i+1,j,i,j,coordinates,isVisited)||
//                    dfsAtlantic(heights,i,j+1,i,j,coordinates,isVisited);
//            isVisited[i][j]=false;
//        }
//
//        return check;
//    }

}
