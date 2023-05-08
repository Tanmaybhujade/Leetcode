var map = function(arr, fn) {
    let arr1=[];
    for(let i=0;i<arr.length; i++){
        let n=arr[i];
        arr1.push(fn(n,i));
    }
    return arr1;
};
