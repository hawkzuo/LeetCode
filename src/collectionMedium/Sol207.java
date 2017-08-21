package collectionMedium;

import java.util.*;

/**
 * Created by Amos on 2017/8/21.
 * Course Schedule
 */
public class Sol207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Memorized dfs: Running time: O(V+E)
        // Each edge is visited at most twice [constant times]
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        int[] checked = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i,checked))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course,int[] global){
        if(global[course] == 1){	return true;}

        if(visited[course])
            return false;
        else
            visited[course] = true;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i),global))
                return false;
        }
        visited[course] = false;
        // The reason why the global marker can be used is:
        // If there's a cycle in the graph, it must be detected the first time when running into any of the vertex
        // in that graph. If not, then there must be no cycles containing this vertex

        global[course] = 1;
        return true;
    }
}
