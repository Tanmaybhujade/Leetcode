/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    // Timeout reference
    let timeout;
    return function(...args) {
        // Clear if function called again within t seconds
       if(timeout) clearTimeout(timeout)
       timeout = setTimeout(() => fn.apply(this, args), t) 
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
