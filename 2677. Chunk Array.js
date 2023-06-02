/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    if(size <= 0) { throw new Error('Size must be greater than 0.');}
    
    let chuncks = [];
    while(arr.length > 0){
        chuncks.push(arr.splice(0,size));
    }
    return chuncks;
};
