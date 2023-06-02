/**
 * @param {Object} context
 * @param {any[]} args
 * @return {any}
 */
Function.prototype.callPolyfill = function(context, ...args) {
    // Avoiding mutating the original ref
    const newContext = {...context};
    // Object.keys doesn't scan __proto__.
    newContext.__proto__.customFunc = this;
    // newContext, which is the left object of a dot notation, becomes the 'this' in customFunc
    const ans = newContext.customFunc(...args);
    delete newContext.__proto__.customFunc;
     return ans
}
