/**
 * @param {object} obj1
 * @param {object} obj2
 * @return {object}
 */
function objDiff(obj1, obj2) {
  let res = {};

  function compareValues(val1, val2) {
    if (val1 !== val2) {
      return [val1, val2];
    }
    return null;
  }

  for (let key in obj1) {
    if (!(key in obj2)) {
      continue;
    }

    let val1 = obj1[key];
    let val2 = obj2[key];

    if (typeof val1 !== 'object' || typeof val2 !== 'object') {
      let diff = compareValues(val1, val2);
      if (diff !== null) {
        res[key] = diff;
      }
    } else if (Array.isArray(val1) !== Array.isArray(val2)) {
      res[key] = [val1, val2];
    } else {
      let temp = objDiff(val1, val2);
      let len = Object.keys(temp).length;
      if (len > 0) {
        res[key] = temp;
      }
    }
  }

   return res;
};
