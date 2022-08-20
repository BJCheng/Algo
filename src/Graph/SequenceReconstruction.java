import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction {
    // public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
    //     // TODO: Write your code here
    //     Map<Integer, List<Integer>> graph = new HashMap<>();
    //     Map<Integer, Integer> degree = new HashMap<>();
    //     for(int[] seq: sequences) {
    //         for(int num: seq) {
    //             grap.put(num, new ArrayList<>());
    //             degree.put(num, 0);
    //         }
    //     }
    //     for(int[] seq: sequences) {
    //         for(int i=1; i<seq.length; i++) {
    //             int fromNum = seq[i-1];
    //             int toNum = seq[i];
    //             graph.get(fromNum).add(toNum);
    //             degree.put(toNum, degree.get(toNum)+1);
    //         }
    //     }
    //     List<Integer> sources = new ArrayList<>();
    //     for(Map.Entry<Integer, Integer> entry: degree.entrySet()) {
    //         if(entry.getValue() == 0) {
    //             sources.add(entry.geyKey);
    //         }
    //     }
    //     for(int source: sources) {
    //         dfs(source, graph, degree, );
    //     }
    //     return false;
    // }

    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        // TODO: Write your code here
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] seq: sequences) {
            for(int i=0; i<seq.length; i++) {
                degree.put(seq[i], 0);
                adjList.put(seq[i], new ArrayList<>());
            }
        }
        for(int[] seq: sequences) {
            for(int i=1; i<seq.length; i++) {
                int from = seq[i-1];
                int to = seq[i];
                degree.put(to, degree.get(to) + 1);
                adjList.get(from).add(to);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: degree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            Integer next = queue.poll();
            result.add(next);
            List<Integer> adj = adjList.get(next);
            for(Integer adjNode: adj) {
                degree.put(adjNode, degree.get(adjNode) - 1);
                if(degree.get(adjNode) == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        if(originalSeq.length != result.size()) {
            return false;
        }
        for(int i=0; i<originalSeq.length; i++) {
            if(originalSeq[i] != result.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
