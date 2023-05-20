/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
  let timerId = null;
  let storedArgs = null;

  function callWithStoredArgs() {
    if (storedArgs) {
      fn.apply(null, storedArgs);
      storedArgs = null;
      timerId = setTimeout(callWithStoredArgs, t);
    } else {
      timerId = null;
    }
  }

  return function(...args) {
    if (!timerId) {
      fn.apply(null, args);
      timerId = setTimeout(callWithStoredArgs, t);
    } else {
      storedArgs = args;
    }
  };
};
