/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    for(let i=0; i<arr.length; i++){
        if(Array.isArray(arr[i])){
            let gen = inorderTraversal(arr[i]);
            let tobeCalled = true;
            while(tobeCalled){
                let nextgen = gen.next();
                if(nextgen && !nextgen.done)
                yield nextgen.value;
                else{
                    tobeCalled = false;
                }
            }
        }else{
            yield arr[i];
        }
    }
};
