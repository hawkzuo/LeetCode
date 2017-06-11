//207. Course Schedule

package breadth_first_search;

import java.util.ArrayList;

public class Solution207 {

	
	
// Slow referred version	
    public boolean canFinishSlow(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }    
	

    
    
    
//Fast version    
	public boolean canFinishFast(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        boolean[] visited = new boolean[numCourses];
        //Form the adjacency lists
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] checked = new int[numCourses];
        
        
        for(int i=0; i<numCourses; i++){
            if(!dfsFast(graph,visited,i,checked))
                return false;
        }
        return true;
    }

    private boolean dfsFast(ArrayList[] graph, boolean[] visited, int course,int[] global){

    	if(global[course] == 1){	return true;}
    	
    	if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfsFast(graph,visited,(int)graph[course].get(i),global))
                return false;
        }
        visited[course] = false;
        global[course] = 1;
        return true;
    }

}
