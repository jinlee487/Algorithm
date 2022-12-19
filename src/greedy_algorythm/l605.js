/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
/* 
https://leetcode.com/problems/can-place-flowers/
 */
 var canPlaceFlowers = function(flowerbed, n) {
    var left = false;
    var right = false; 
    for(let i=0;i<flowerbed.length;i++){
        if(i-1<0) {
            left = true;
        } else {
            if(flowerbed[i-1] !== 1) left = true;
        }
        if(flowerbed.length-1<i+1) {
            right = true;
        } else {
            if(flowerbed[i+1] !== 1) right = true;
        }
        if(left && right && 0 < n && flowerbed[i] !== 1) {
            flowerbed[i] = 1;
            n--;
        }
        right = left = false;
    }
    return n === 0;
};