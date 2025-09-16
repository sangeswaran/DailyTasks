import java.util.*;

public class EliminationGame
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> result = findEliminated(n, k);
        for (int i = 0; i < result.size(); i++)
        {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }
    
    public static List<Integer> findEliminated(int n, int k)
    {
        boolean[] visited = new boolean[n + 1];
        int current = 1;
        visited[current] = true;
        while (true)
        {
            current = (current + k) % n;
            if (current == 0) current = n;
            if (visited[current]) break;
            visited[current] = true;
        }
        List<Integer> eliminated = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            if (!visited[i]) eliminated.add(i);
        }
        if (eliminated.isEmpty())
        {
            eliminated.add(0);
        }
        return eliminated;
    }
}