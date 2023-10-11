import java.lang.reflect.Array;

public class Cache {
    public Cell[] cells;

    public Cache(Cell[] cells) {
        if(Array.getLength(cells) > 4){
            throw new IllegalArgumentException("Cache can only have up to 4 cells");
        } else {
            this.cells = cells;
        }
    }

    public void show_cells() {
        for (Cell cell : cells){
            System.out.println(cell.toString());
        }
    }

    
}
