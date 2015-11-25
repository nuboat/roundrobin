package thjug.rr;

/**
 * Route object
 * 
 * @author Peerapat Asoktummarungsri
 */
public class Route<T> {
    
    private static final double STARTSCORE = 10000;
    private static final long SHIFTTIME = 60000; // 1 min
    
    private final T t;
    private final long shifttime;
    private long delay = 0;
    private double score = STARTSCORE;
    private int failCount = 0;
    
    public Route(final T t) {
        this.t = t;
        this.shifttime = SHIFTTIME;
    }
    
    public Route(final T t, final long shifttimeInSecond) {
        this.t = t;
        this.shifttime = shifttimeInSecond;
    }
    
    public T get() {
        return t;
    }
    
    public void reset() {
        delay = 0;
        score = STARTSCORE;
        failCount = 0;
    }
            
    public void fail() {
        this.delay = System.currentTimeMillis() + shifttime;
        this.score = score / 10;
        this.failCount++;
    }

    public boolean isReady() {
        return delay <= System.currentTimeMillis();
    }
    
    public boolean isSkip() {
        return !isReady();
    }
    
    public long getDelay() {
        return delay;
    }
    
    public double getScore() {
        return score;
    }
    
    public int getFailCount() {
        return failCount;
    }
    
    public boolean equals(final Route<T> r) {        
        return this.t.equals(r.t);
    }
    
}
