import java.util.ArrayList;

public class Ram {
    public ArrayList<Cell> cells;
    private Processor processor1, processor2;

    public Ram(ArrayList<Cell> cells, Processor processor1, Processor processor2) {
        if(cells.size() > 32){
            throw new IllegalArgumentException("Cache can only have up to 32 cells");
        } else {
            this.cells = new ArrayList<>();
            this.processor1 = processor1;
            this.processor2 = processor2;
        }
    }

    // Acessar ambas as caches para fazer a busca das celulas para definicao das tags
    public void define_tags(){
        
    }
    
}
