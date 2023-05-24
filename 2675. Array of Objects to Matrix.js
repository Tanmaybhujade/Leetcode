/**
 * @param {Array} arr
 * @return {Matrix}
 */
var jsonToMatrix = function(arr) {
    var result = new Map();
    n = arr.length

    // recursive functions sets the map with proper key:value
    function recursive(arr, key, index){
        if(typeof arr !== 'object' || arr === null){
            if(!result.has(key)){
                result.set(key, Array(n).fill(""))         
            }
            result.get(key)[index] = arr;
            return
        }

        Object.keys(arr).forEach(k=>{
            const newKey = key.length === 0? k+'': key+'.'+k;   
            recursive(arr[k],  newKey, index);
        })
    }
    
    for(let i=0;i<n;i++){
        recursive(arr[i],'', i)
    }
    
    if(result.size === 0) return Array(n+1).fill(new Array().fill([]))

    let finalResult = Array(n+1).fill(false)
    let resultKeys = Array.from(result.keys()).sort();
    finalResult[0] = [...resultKeys];
    
    // once we have the map, order the key,values column wise
    resultKeys.forEach((resultKey,index) => {
        const temp = result.get(resultKey);
        for(let j=1;j<=n;j++){
            if(!finalResult[j]){
                finalResult[j]= [];
            }
            finalResult[j].push(temp.shift())
        }
    })

    return finalResult;
};
