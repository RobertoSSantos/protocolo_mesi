public class Processor {
    private int id;
    private Cache cache;

    public Processor(int id, Cache cache) {
        this.id = id;
        this.cache = cache;
    }

    public int getId() {
            return id;
        }
    
    public void setId(int id) {
        this.id = id;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
}
