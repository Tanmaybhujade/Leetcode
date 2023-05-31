Array.prototype.groupBy = function(f) {
    return this.reduce((r, x) => {
        (r[f(x)] ||= []).push(x)
        return r 
    }, {})
}
