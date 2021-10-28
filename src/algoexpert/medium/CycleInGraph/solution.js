function cycleInGraph(edges) {
    // Write your code here.
      const visited = new Array(edges.length).fill(false);
      const current = new Array(edges.length).fill(false);
      for(let i=0;i<edges.length;i++){
          if(visited[edges[i]]) continue;		
          if(dfs(i,edges,visited,current)) return true;
      }
    return false;
  }
  function dfs(node, edges, visited,current){
      if(current[node]) return true; 	
      visited[node] = true;
      current[node] = true;
      for(let i=0;i<edges[node].length;i++){
          if(visited[edges[node][i]]){ 
              if(current[edges[node][i]]) return true;
              else continue;
          }
          if(dfs(edges[node][i],edges,visited,current)) return true;
      }
      current[node] = false;
      return false;
    }
  function cycleInGraph(edges) {
    // Write your code here.
      const visited = new Set();
      for(let i=0;i<edges.length;i++){
          if(visited.has(i)) continue;		
          if(dfs(i,edges,visited)) return true;
      }
    return false;
  }
  function dfs(node, edges, visited){
      if(visited.has(node)) return true; 	
      visited.add(node);
      for(let i=0;i<edges[node].length;i++){
          if(dfs(edges[node][i],edges,visited)) return true;
      }
      visited.delete(node);
      return false;
  }
  
  // Do not edit the line below.
  exports.cycleInGraph = cycleInGraph;
     