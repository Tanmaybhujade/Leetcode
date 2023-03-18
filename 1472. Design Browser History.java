 class BrowserHistory {

Stack<String> back = new Stack<>();
Stack<String> ford = new Stack<>();
public BrowserHistory(String homepage) {
    back.push(homepage);
}

public void visit(String url) {
    back.push(url);
    while(ford.size() > 0){
        ford.pop();
    }
}

public String back(int steps) {
    while(back.size() > 1 && steps > 0){
        ford.push(back.pop());
        steps--;
    }
    return back.peek();
}

public String forward(int steps) {
    while(ford.size() > 0 && steps > 0){
        back.push(ford.pop());
        steps--;
    }
    return back.peek();
  }
}
