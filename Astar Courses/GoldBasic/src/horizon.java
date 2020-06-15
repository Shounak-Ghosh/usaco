import java.util.*;

public class horizon
{
    private static int N;
    private static Set<Endpoint> endpoints;
    private static Set<Long> skyline;
    public static void main(String[] args)
    {

       Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        endpoints = new TreeSet<>();

        skyline = new TreeSet<>();

        for (int i = 0; i < N; i++)
        {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long h = sc.nextLong();

            endpoints.add(new Endpoint(a, h, true));
            endpoints.add(new Endpoint(b, h, false));

            skyline.add(a);
            skyline.add(b);

        }

        long ans = 0;
        int j = 0;

        Long[] sky = skyline.toArray(new Long[N]);
        Endpoint[] ends = endpoints.toArray(new Endpoint[N*2]);

        MultiSet<Long> current = new MultiSet<>();

        for (int i = 0; i < sky.length - 1; i++) {

            long a = sky[i];
            long b = sky[i+1];

            while (true)
            {

                if (ends[j].pos >= a && ends[j].pos < b)
                {

                    if (ends[j].start)
                    {
                        current.add(ends[j].height);
                    }
                    else
                    {
                        current.removeFirst(ends[j].height);
                    }

                    j++;

                }
                else
                {
                    break;
                }

            }

            if (current.count.size() > 0)
                ans += (b - a) * current.tail();

        }
        System.out.println(ans);
    }


    private static class MultiSet<E> // E represents a generic type
    {
        TreeMap<E, Integer> count;
        private int size;

        public MultiSet()
        {
            count = new TreeMap<>();
            size = 0;
        }

        public boolean add(E e)
        {
            if (count.containsKey(e))
            {
                count.put(e, count.get(e) + 1);
            }
            else
            {
                count.put(e, 1);
            }
            size++;
            return true;

        }

        public boolean removeFirst(E e)
        {

            if (count.containsKey(e))
            {
                count.put(e, count.get(e) - 1);
                if (count.get(e) == 0)
                {
                    count.remove(e);
                }
                size--;
                return true;
            }
            return false;

        }

        public E tail()
        {
            return count.lastKey();
        }

        public String toString()
        {
            return count.toString();
        }

    }

    private static class Endpoint implements Comparable<Endpoint>
    {
        long pos;
        long height;
        boolean start;

        public Endpoint(long pos, long height, boolean start)
        {

            this.pos = pos;
            this.height = height;
            this.start = start;

        }

        public int compareTo(Endpoint other)
        {
            if (this.pos != other.pos)
            {
                return Long.compare(this.pos,other.pos);
            }
            return -1;
        }
    }
}