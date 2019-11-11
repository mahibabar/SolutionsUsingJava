package ds.cache;

import java.util.*;

public class LRUImplementationUsingQueue {

}

class LRUCache {

    private List<String> queue;
    private HashSet<String> keys;
    private int pages;

    public LRUCache(int noOfPages) {
        this.queue = new LinkedList<>();
        this.keys = new HashSet<String>();
        this.pages = noOfPages;
    }

    public String get(String x) {

        if(keys.contains(x)) {

        } else {

        }

        return "";
    }

    public void put(String obj) {

    }
}
