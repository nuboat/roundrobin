package thjug.rr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * High score is first priority.
 * 
 * @author Peerapat Asoktummarungsri
 */
public class ScoreRR<T> extends RR<T> {

    /**
     * Constructor of RoundRobin
     */
    public ScoreRR(final List<T> list) {
        super(list);
    }
    
    /**
     * Get Route<br>
     * *Move to java.util.Optional in the future<br>
     *
     * @return Option&lt;Route<T>>
     */
    @Override
    public Option<Route<T>> get() {
        if (routes.isEmpty()) {
            return Option.empty();
        }
        
        final List<Route<T>> list = routesAtMaxScore();
        
        return Option.of(
                list.get(ThreadLocalRandom.current().nextInt(0, list.size())));
    }
    
    private List<Route<T>> routesAtMaxScore() {
        final double maxscore = maxScore();
        final List<Route<T>> list = new ArrayList<>();
        for(final Route<T> r : routes) {
            if (r.getScore() >= maxscore) {
                list.add(r);
            }
        }
        
        return list;
    }
    
    private double maxScore() {
        return Collections.max(scoreList());
    }
    
    private List<Double> scoreList() {
        final List<Double> list = new LinkedList<>();
        for(final Route<T> r : routes) {
            list.add(r.getScore());
        }
        
        return list;
    }
}
