/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
  return async function(...args) {
    const start = performance.now(); 
    //we implement promise.race in this case because we have to execute two promises in the same time 
    const result = await Promise.race([fn(...args), new Promise((resolve, reject) => setTimeout(() => reject('Time Limit Exceeded'), t))]);
    const end = performance.now();
    if (end - start > t) {
      return result;
    }
    return result;
  };
};
