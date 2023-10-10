public class Processor {
    private Cache cache;

    public Processor(Cache cache) {
        this.cache = cache;
    }

    public void read(int endMemoria){
        
    }

    public void write(int newValue, int endMemoria){
        // A partir do endereco de memoria busca a celula a ser modificada
        for (Cell cell : cache.cells) {
            if (cell.getEndMemoria() == endMemoria) {
                Tags tag = cell.getTag();

                switch(tag) {
                    case MODIFICADA:
                        cell.setValue(newValue);
                        break;
                    case EXCLUSIVA:
                        cell.setValue(newValue);
                        cell.setTag(Tags.MODIFICADA);
                        break;
                    case COMPARTILHADA:
                        cell.setTag(Tags.INVALIDA);
                        break;
                    default:
                        throw new IllegalArgumentException("Tag invalida");
                }
            }
        }
    }

    public void check_cache_state(){
        for(Cell cell : cache.cells){
            System.out.println(cell.getTag() + " " + cell.getValue() + " " + cell.getEndMemoria());
        }
    }
    
}
