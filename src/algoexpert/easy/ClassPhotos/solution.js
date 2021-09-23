function classPhotos(redShirtHeights, blueShirtHeights) {
    // Write your code here.
      redShirtHeights.sort((o1,o2) => o1-o2);
      blueShirtHeights.sort((o1,o2) => o1-o2);
      let red = redShirtHeights[0] < blueShirtHeights[0] ? true : false;
      for(let i=0;i<redShirtHeights.length;i++){
          if(red){
              if(redShirtHeights[i] >= blueShirtHeights[i]){
                  return false;
              }
          } else {
              if(redShirtHeights[i] <= blueShirtHeights[i]){
                  return false;
              }
          }
      }
    return true;
  }
  
  // Do not edit the line below.
  exports.classPhotos = classPhotos;
  