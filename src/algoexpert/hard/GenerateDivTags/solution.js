function generateDivTags(numberOfTags) {
    // Write your code here.
      const answer = [];
      const array = [];
      array.push("<div>");
      generateDivTagsHelper(answer, array, numberOfTags, 1,0);
    return answer;
  }
  function generateDivTagsHelper(answer, array, numberOfTags, opening, closing){
      if(numberOfTags === opening && numberOfTags === closing) {
          if(check(array)) answer.push(array.join(""));
          return;
      }
      if(opening < numberOfTags && closing < numberOfTags){
          array.push("<div>");
          generateDivTagsHelper(answer, array, numberOfTags, opening+1, closing);
          array.pop();
      }
      if(closing < numberOfTags){
          array.push("</div>");
          generateDivTagsHelper(answer, array, numberOfTags, opening, closing+1);
          array.pop();
      }
      return;
  }
  function check(array){
      const stack = [];
      for(let i=0;i<array.length;i++){
          if(0<stack.length && stack[stack.length-1] === "<div>" && array[i] === "</div>"){
              stack.pop();
          } else {
              stack.push(array[i]);			
          }
      }
      return stack.length === 0;
  }
  function generateDivTags(numberOfTags) {
    // Write your code here.
      const answer = [];
      generateDivTagsHelper(answer, numberOfTags, numberOfTags, "");
    return answer;
  }
  function generateDivTagsHelper(answer, opening, closing, prefix){
      if(0<opening){
          const newPrefix = prefix + "<div>";
          generateDivTagsHelper(answer, opening-1, closing, newPrefix)
      }
      if(opening < closing){
          const newPrefix = prefix + "</div>";
          generateDivTagsHelper(answer, opening, closing-1, newPrefix)
      }
      if(closing === 0) answer.push(prefix);
      return;
  }
  
  // Do not edit the line below.
  exports.generateDivTags = generateDivTags;
  
  