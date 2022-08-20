import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {

        // TODO: Write your code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> levels = new HashMap<>();
        for(int i=0; i<tasks; i++) {
            adjList.put(i, new ArrayList<>());
            levels.put(i, 0);
        }
        for(int[] pre: prerequisites) {
            int from = pre[0];
            int to = pre[1];
            adjList.get(from).add(to);
            levels.put(to, levels.get(to)+1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: levels.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(tasks, adjList, levels, queue, new LinkedList<>(), result);
        for(List<Integer> aResult: result) {
            System.out.println("[");
            for(int a: aResult) {
                System.out.print(a);
            }
            System.out.println("]");
        }
    }

    public static void dfs(Integer tasks, Map<Integer, List<Integer>> adjList,
                           Map<Integer, Integer> levels, Queue<Integer> queue, List<Integer> order, List<List<Integer>> result) {
        if(order.size() == tasks) {
            result.add(new ArrayList<>(order));
            return;
        }
        for(Integer next: queue) {
            order.add(next);
            Queue<Integer> nextQueue = clone(queue);
            nextQueue.remove(next);
            for(Integer adj: adjList.get(next)) {
                levels.put(adj, levels.get(adj)-1);
                if(levels.get(adj) == 0) {
                    nextQueue.add(adj);
                }
            }
            dfs(tasks, adjList, levels, nextQueue, order, result);
            for(Integer adj: adjList.get(next)) {
                levels.put(adj, levels.get(next)+1);
            }
            order.remove(next);
        }
    }

    public static Queue<Integer> clone(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        // AllTaskSchedulingOrders.printOrders(4,
        //         new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        // System.out.println();
        //
        // AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
        //         new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        // System.out.println();
    }

    public static class Meeting {
        int start;
        int end;
    }

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if(meetings.size() < 1) {
            return 0;
        }
        PriorityQueue<Meeting> pq = new PriorityQueue<>(Comparator.comparing(m -> m.end));
        pq.offer(meetings.get(0));
        int max = -1;
        for(int i=1; i<meetings.size(); i++) {
            Meeting meeting = meetings.get(i);
            Meeting earliest = pq.peek();
            if(meeting.start < pq.peek().end && meeting.end > pq.peek().start) {
                pq.offer(meeting);
            } else {
                while(pq.peek().end <= meeting.start) {
                    pq.poll();
                }
            }
            max = Math.max(max, pq.size());
        }
        return max;
    }
}
