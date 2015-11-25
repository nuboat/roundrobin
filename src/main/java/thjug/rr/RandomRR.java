package thjug.rr;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Random
 * 
 * @author Peerapat Asoktummarungsri
 */
public class RandomRR<T> extends RR<T> {

    /**
     * Constructor of RoundRobin
     */
    public RandomRR(final List<T> list) {
        super(list);
    }

    /**
     * Get Route<br>
     * *Move to java.util.Optional in the future<br>
     *
     * @return List&lt;T> list of elements
     */
    @Override
    public Option<Route<T>> get() {
        if (routes.isEmpty()) {
            return Option.empty();
        }
        
        return Option.of(
                routes.get(ThreadLocalRandom.current().nextInt(0, routes.size() - 1)));
    }

}
