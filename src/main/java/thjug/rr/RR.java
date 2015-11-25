package thjug.rr;

import java.util.ArrayList;
import java.util.List;

/**
 * RoundRobin Interface.
 * 
 * @author Peerapat Asoktummarungsri
 */
public abstract class RR<T> {

    final int size;
    final List<Route<T>> routes = new ArrayList<>();

    /**
     * Constructor of RoundRobin
     */
    public RR(final List<T> list) {
        this.size = list.size();
        for (final T t : list) {
            routes.add(new Route(t));
        }
    }

    /**
     * Move to java.util.Optional in the future<br>
     *
     * @return Option&lt;Route&lt;T>>
     */
    public abstract Option<Route<T>> get();

}
