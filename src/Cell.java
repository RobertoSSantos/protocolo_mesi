public class Cell {
    private Tags tag;
    private int value;

    public Cell(){
        this.value = 0;
        this.tag = Tags.INVALIDA;
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

    @Override
    public String toString(){
        return "Cell: " +
                "tag = " + this.tag +
                ", value = " + this.value;
    }
}
