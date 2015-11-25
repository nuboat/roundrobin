package thjug.rr;

import java.util.List;

/**
 * Respectively return.
 * 
 * @author Peerapat Asoktummarungsri
 */
public class CircleRR<T> extends RR<T> {

    private int cursor;

    /**
     * Constructor of RoundRobin
     */
    public CircleRR(final List<T> list) {
        super(list);
        cursor = 0;
    }
    
    /**
     * Get Route<br>
     * Move to java.util.Optional in the future<br>
     *
     * @return List&lt;T> list of elements
     */
    @Override
    public Option<Route<T>> get() {
        if (routes.isEmpty()) {
            return Option.empty();
        }

        for(int i = 0; i < size; i++) {
            final Route<T> route = routes.get(getCursor());
            if(route.isReady()) {
                return Option.of(route);
            }
        }
        
        return Option.empty();
    }

    private synchronized int getCursor() {
        try {
            return cursor++;
        } finally {
            if (cursor >= (size)) {
                cursor = 0;
            }
        }
    }

}
