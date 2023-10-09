public class Cell {
    private Tags tag;
    private int value;
    private int endMemoria;

    public Cell(int value, int endMemoria){
        this.value = value;
        this.endMemoria = endMemoria;
    }

    public Tags getTag() {
        return tag;
    }

    public void setTag(Tags tag) {
        this.tag = tag;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getEndMemoria() {
        return endMemoria;
    }

    public void setEndMemoria(int endMemoria) {
        this.endMemoria = endMemoria;
    }
}
