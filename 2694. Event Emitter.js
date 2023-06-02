class EventEmitter {
  constructor() {
    this.events = {};
  }

  subscribe(event, cb) {
    if (!(event in this.events)) {
      this.events[event] = [];
    }

    this.events[event].push(cb);

    return {
      unsubscribe: () => {
        const index = this.events[event].indexOf(cb);
        if (index !== -1) {
          this.events[event].splice(index, 1);
        }
      }
    };
  }

  emit(event, args = []) {
    if (!(event in this.events)) {
      return [];
    }

    const results = [];
    for (const cb of this.events[event]) {
      results.push(cb(...args));
    }

    return results;
  }
}
