function subarraySort(array) {
    // Write your code here.
    let max = -Infinity;
    let start = Infinity;
    let end = -Infinity;
    for(let i=0;i<array.length;i++){
            if(max<array[i]){
                    max = array[i];
                    continue;
            }
            for(let j=i-1;0<=j;j--){
                if(array[j]<=array[i]) break;
                start = Math.min(start, j);  
            }
            end = Math.max(end,i);
    }
    start = start === Infinity ? -1 : start;
    end = start === -1 ? -1 : end;
    return [start, end];
}
function subarraySort(array) {
    // Write your code here.
    let minimum = Infinity;
    let maximum = -Infinity;
    for(let i=0;i<array.length;i++){
        const num = array[i];
        if(check(i,num,array)){
            minimum = Math.min(minimum, num);
            maximum = Math.max(maximum, num);
        }
    }
    if(minimum === Infinity) return [-1,-1];
    let start=0, end=array.length-1;
    while(minimum >= array[start]) start++;
    while(maximum <= array[end]) end--;
    return [start, end]
}
function check(i, num, array){
    if (i==0) return num > array[i+1];
    if (i == array.length-1) return num < array[i-1];
    return num > array[i+1] || num < array[i-1];
}