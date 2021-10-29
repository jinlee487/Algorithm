function taskAssignment(k, tasks) {
    // Write your code here.
      const answer = [];
      const obj = {};
      for(let i=0;i<tasks.length;i++){
          if(tasks[i] in obj) obj[tasks[i]].push(i);
          else obj[tasks[i]] = [i];
      }
      tasks.sort((o1,o2) => o1 - o2);
      for(let i=0;i<k;i++) answer.push([obj[tasks[i]].pop(0)]);
      for(let i=0;i<k;i++) answer[i].push(obj[tasks.pop()].pop(0));
    return answer;
  }
  
  // Do not edit the line below.
  exports.taskAssignment = taskAssignment;
  