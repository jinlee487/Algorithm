function dijkstrasAlgorithm(start, edges) {
    // Write your code here.
      const dp = [];
      const set = new Set();
      for(let i=0;i<edges.length;i++){
          dp.push(Infinity);
      }
      dp[0] = 0;
      while(set.size != edges.length){
          let vertex = -1;
          let currentDistance = Infinity;
          for(let i=0;i<dp.length;i++){
              if(set.has(i)) continue;
              if(dp[i]<currentDistance){
                  vertex = i;
                  currentDistance = dp[i];
              }
          }
          if(currentDistance === Infinity) break;
          set.add(vertex);
          for(const edge of edges[vertex]){
              const [nextVertex,nextDistance] = edge;
              if(set.has(nextVertex)) continue;
              if(nextDistance+currentDistance<dp[nextVertex]) dp[nextVertex] = nextDistance+currentDistance;
          }
      }
      return dp.map(x => (x===Infinity ? -1 : x));
  }
  
  function dijkstrasAlgorithm(start, edges) {
    // Write your code here.
      const dp = [];
      const hash = new Map();
      const array = [];
      for(let i=0;i<edges.length;i++){
          const obj = {
              vertex: i,
              distance: Infinity
          };
          array.push(obj);
          hash.set(i,obj);
      }
      array[start].distance = 0;
      array.sort((a,b) => (b.distance - a.distance));
      while(array.length != 0){
          console.log(array);
          const obj = array.pop();
          const vertex = obj.vertex;
          const currentDistance = obj.distance;
          if(currentDistance === Infinity) break;
          for(const edge of edges[vertex]){
              const [nextVertex,nextDistance] = edge;
              if(nextDistance+currentDistance<hash.get(nextVertex).distance){
                  hash.get(nextVertex).distance = nextDistance+currentDistance;
                  array.sort((a,b) => (b.distance - a.distance));
              }
          }
      }
      for(let i=0;i<edges.length;i++){
          dp.push(hash.get(i).distance);
          if(dp[i]===Infinity) dp[i] = -1;
      }
      return dp;
  }
  
  // Do not edit the line below.
  exports.dijkstrasAlgorithm = dijkstrasAlgorithm;
  
  