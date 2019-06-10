package Chapter1.Ex_1_2;

public class Counter
implements Comparable<Counter>{
    private final String name;
    private int count;

    public Counter(String name)
    {
        this.name = name;
    }

    public void increment()
    {
        count++;
    }

    public int getTally()
    {
        return count;
    }

    public String toString()
    {
        return count + " " + this.name;
    }

    public int compareTo(Counter that)
    {
        if (this.count < that.count) return -1;
        if (this.count > that.count) return 1;
        else return 0;
    }
}
