import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class cgiving
{
    public static int Dijkstras(Vertex[] graph, int source, int destination)
    {
        //current keeps track of the vertex we are currently looking at
        Vertex current = graph[source];
        //set the minimum distance of the source vertex to 0
        current.minDistance = 0;

        //create the PriorityQueue which will keep track of the vertices by minimum distance
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
        //push the current vertex into the queue
        priorityQueue.add(current);

        //continue while the queue is not empty
        while (!priorityQueue.isEmpty())
        {
            //current is the next vertex in the queue, or the vertex with the minimum distance
            current = priorityQueue.remove();

            //if we are currently looking at the destination vertex, break out of the loop
            if (current.id == destination)
            {
                break;
            }

            //examine each neighbor of the current vertex by looking at each edge that connects them
            for (Edge edge : current.neighbors)
            {
                //end keeps track of the vertex opposite of the current vertex on the edge
                Vertex end = graph[edge.end];
                //distance keeps track of the distance between the current vertex and the end vertex
                int distance = edge.distance;
                //newDistance keeps track of the distance up to the current vertex added with the distance
                //between the current vertex and the end vertex
                int newDistance = current.minDistance + distance;

                //if the newDistance is less than the minimum distance of the end vertex, replace it
                if (newDistance < end.minDistance)
                {
                    priorityQueue.remove(end);
                    end.minDistance = newDistance;
                    priorityQueue.add(end);
                }
            }
        }

        //if we haven't visited the destination vertex, return -1, otherwise, return the distance
        if (graph[destination].minDistance == Integer.MAX_VALUE)
        {
            return -1;
        } else {
            return graph[destination].minDistance;
        }
    }

    public static void main(String[] ags)
    {
        Scanner in = new Scanner(System.in);

        int vertices = in.nextInt();
        int edges = in.nextInt();
        int source = in.nextInt();

        Vertex[] graph = new Vertex[vertices+1];

        for (int j = 1; j <= vertices; j++)
        {
            graph[j] = new Vertex(j);
        }

        for (int k = 0; k < edges; k++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int distance = in.nextInt();
            graph[a].neighbors.add(new Edge(b, distance));
            graph[b].neighbors.add(new Edge(a,distance));
        }

        for (int i = 1; i <= vertices; i++)
        {
            int result = Dijkstras(graph, source, i);

            System.out.println(result);
        }


    }

    static class Vertex implements Comparable<Vertex>
    {
        int id, minDistance;
        List<Edge> neighbors;

        public Vertex(int id)
        {
            this.id = id;
            this.minDistance = Integer.MAX_VALUE;
            this.neighbors = new ArrayList<Edge>();
        }

        public int compareTo(Vertex v)
        {
            return (this.minDistance > v.minDistance) ? 1 : -1;
        }
    }

    static class Edge
    {
        int end, distance;

        public Edge(int end, int distance)
        {
            this.end = end;
            this.distance = distance;
        }
    }
}
