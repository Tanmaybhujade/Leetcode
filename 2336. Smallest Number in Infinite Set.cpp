class SmallestInfiniteSet
{
public:
    set<int> vec;
    SmallestInfiniteSet()
    {
        vec.clear();
        for (int i = 1; i <= 1000; i++)
        {
            vec.insert(i);
        }
    }

    int popSmallest()
    {
        int t = *vec.begin();
        vec.erase(vec.begin());
        return t;
    }

    void addBack(int num)
    {
        vec.insert(num);
    }
};
