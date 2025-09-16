import java.util.Scanner;

public class MiniRegexFinder
{
        public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        String match = firstMatch(s, p);
        System.out.println("First match: " + match);
    }
    
    private static boolean matches(String s, int si, String p, int pi)
    {
        int sl = s.length();
        int pl = p.length();
        while (pi < pl)
        {
            if (pi + 1 < pl && (p.charAt(pi + 1) == '*' || p.charAt(pi + 1) == '+'))
            {
                char ch = p.charAt(pi);
                int count = 0;
                while (si < sl && s.charAt(si) == ch)
                {
                    si++;
                    count++;
                }
                if (p.charAt(pi + 1) == '+')
                {
                    if (count == 0)
                    {
                        return false;
                    }
                }
                pi += 2;
            }
            else
            {
                if (si >= sl || s.charAt(si) != p.charAt(pi))
                {
                    return false;
                }
                si++;
                pi++;
            }
        }
        return true;
    }

    public static String firstMatch(String s, String p)
    {
        for (int start = 0; start < s.length(); start++)
        {
            int si = start, pi = 0, lastMatch = start;
            while (pi < p.length() && si < s.length())
            {
                if (pi + 1 < p.length() && (p.charAt(pi + 1) == '*' || p.charAt(pi + 1) == '+'))
                {
                    char ch = p.charAt(pi);
                    int count = 0;
                    while (si < s.length() && s.charAt(si) == ch)
                    {
                        si++;
                        count++;
                    }
                    if (p.charAt(pi + 1) == '+' && count == 0)
                    {
                        break;
                    }
                    pi += 2;
                    lastMatch = si;
                }
                else
                {
                    if (si >= s.length() || s.charAt(si) != p.charAt(pi))
                    {
                        break;
                    }
                    si++;
                    pi++;
                    lastMatch = si;
                }
            }
            if (pi == p.length()) return s.substring(start, lastMatch);
        }
        return "";
    }
}