import java.util.*;

public class WordSearch
{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++)
        {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++)
            {
                grid[i][j] = line.charAt(j);
            }
        }
        String word = sc.nextLine().trim();
        int result = countOccurrences(grid, word);
        System.out.println(result);
        sc.close();
    }
    
    private static final int[][] DIRS = {
        {0, 1},   // → right
        {0, -1},  // ← left
        {1, 0},   // ↓ down
        {-1, 0},  // ↑ up
        {1, 1},   // ↘ diagonal down-right
        {-1, -1}, // ↖ diagonal up-left
        {1, -1},  // ↙ diagonal down-left
        {-1, 1}   // ↗ diagonal up-right
    };

    public static int countOccurrences(char[][] grid, String word)
    {
        int n = grid.length;
        int count = 0;
        int L = word.length();
        char first = word.charAt(0);
        char last = word.charAt(L-1);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != first)
                {
                    continue;
                }
                for (int[] dir : DIRS)
                {
                    int dx = dir[0];
                    int dy = dir[1];
                    int x = i, y = j;
                    int k;
                    for (k = 0; k < L; k++)
                    {
                        int nx = x + dx * k;
                        int ny = y + dy * k;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        {
                            break;
                        }
                        if (grid[nx][ny] != word.charAt(k))
                        {
                            break;
                        }
                    }
                    if (k == L)
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}