function spiralTraverse(array) {
    // Write your code here.
    const answer = [];
    if(array.length === 0) return answer;
    let startRow = 0;
    let startCol = 0;
    let endRow = array.length-1;
    let endCol = array[0].length-1;
    while(startRow<= endRow && startCol <= endCol){
        for(let col=startCol;col<=endCol;col++){
            answer.push(array[startRow][col]);
        }
        for(let row=startRow+1;row<=endRow;row++){
            answer.push(array[row][endCol]);
        }
        for(let col=endCol-1;startCol<=col;col--){
            if(startRow===endRow) break;
            answer.push(array[endRow][col]);
        }
        for(let row=endRow-1;startRow+1<=row;row--){
            if(startCol===endCol) break;
            answer.push(array[row][startCol]);
        }
        startRow ++;
        startCol ++;
        endRow --;
        endCol --;
    }
    return answer;
    
}
function spiralTraverse(array) {
    // Write your code here.
    const answer = [];
    if(array.length===0) return answer;
    spiralTraverseHelper(array, 0, array.length-1,0, array[0].length-1, answer);
    return answer;
}
function spiralTraverseHelper(
array, startRow, endRow, startCol, endCol, answer){
    if(endRow<startRow||endCol<startCol) return;
    for(let col=startCol; col<=endCol;col++){
        answer.push(array[startRow][col]);
    }
    for(let row=startRow+1; row<=endRow;row++){
        answer.push(array[row][endCol]);
    }
    for(let col=endCol-1; startCol <= col; col--){
        if(startRow===endRow) break;
        answer.push(array[endRow][col]);
    }
    for(let row=endRow-1; startRow +1 <= row; row --){
        if(startCol === endCol) break;
        answer.push(array[row][startCol]);
    }
    spiralTraverseHelper(array, startRow+1,endRow-1,startCol+1,endCol-1,answer);
    
}

  
// Do not edit the line below.
exports.spiralTraverse = spiralTraverse;
  