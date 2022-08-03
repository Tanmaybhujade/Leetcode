class MyCalendar {
public:
    map<int, int> events;
    
    MyCalendar() {
        
    }
    
    bool book(int start, int end) {
        for(auto it = events.begin(); it != events.end(); it++){
            if((start >= it->first && start < it->second) || 
              (end > it->first && end <= it->second) || 
              (start <= it->first && end >= it->second)){
                //intersection is not empty
                return false;
            }else if(it->first >= end){
                //no intersection
                break;
            }
        }
        events[start] = end;
        return true;
    }
};
