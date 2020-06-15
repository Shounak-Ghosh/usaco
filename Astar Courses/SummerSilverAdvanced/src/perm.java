public class perm
{
    public static void main(String[] args)
    {
        dfs(0);
    }

    static String curr = "";
    static boolean[] visited = new boolean[5];
    public static void dfs(int depth)
    {
        if (curr.length() == 4)
        {
            System.out.println(curr);
            return;
        }

        for (int i = 1; i <= 4; i++)
        {
            if (!visited[i])
            {
                curr += ("" + i);
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
                if (curr.length() > 0)
                    curr = curr.substring(0,curr.length()-1);
            }
        }
    }
}
