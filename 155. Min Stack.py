class MinStack:
  def __init__(self):
    self.vals = []
    self.mins = []

  def push(self, val: int) -> None:
    self.vals.append(val)
    self.mins.append(min(self.mins[-1] if self.mins else val, val))

  def pop(self) -> None:
    self.mins.pop()
    self.vals.pop()
      
  def top(self) -> int:
    return self.vals[-1]

  def getMin(self) -> int:
    return self.mins[-1]
