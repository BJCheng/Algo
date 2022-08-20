package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> paths = new HashMap<>();
        Map<Integer, Integer> levels = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            paths.put(i, new ArrayList<>());
            levels.put(i, 0);
        }
        for(int[] pre: prerequisites) {
            int from = pre[0];
            int to = pre[1];
            paths.get(from).add(to);
            levels.put(to, levels.get(to)+1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: levels.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        List<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            Integer next = queue.poll();
            result.add(next);
            List<Integer> path = paths.get(next);
            for(Integer advanced: path) {
                levels.put(advanced, levels.get(advanced)-1);
                if(levels.get(advanced) == 0) {
                    queue.offer(advanced);
                }
            }
        }
        if(result.size() == 0) {
            return new int[0];
        } else {
            return result.stream().mapToInt(i->i).toArray();
        }
    }
}
