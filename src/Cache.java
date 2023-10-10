import java.util.ArrayList;

public class Cache {
    public ArrayList<Cell> cells;

    public Cache(ArrayList<Cell> cells) {
        if(cells.size() > 4){
            throw new IllegalArgumentException("Cache can only have up to 4 cells");
        } else {
            this.cells = new ArrayList<>();
        }
    }
}
