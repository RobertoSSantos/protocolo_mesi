public class App {
    public static void main(String[] args) throws Exception {
        //Grupo: Gabriel Souza Dunkel, Pedro Martins de Oliveira Menezes, Roberto Souza Santos    
        //Inicializando processador 1
        Cell c1 = new Cell();
        Cell c2 = new Cell();
        Cell c3 = new Cell();
        Cell c4 = new Cell();
        Cell[] cells1 = {c1,c2,c3,c4};
        
        Cache mc1 = new Cache(cells1);
        Processor p1 = new Processor(1,mc1);

        //Inicializando processador 2
        Cell c5 = new Cell();
        Cell c6 = new Cell();
        Cell c7 = new Cell();
        Cell c8 = new Cell();
        Cell[] cells2 = {c5,c6,c7,c8};
        
        Cache mc2 = new Cache(cells2);
        Processor p2 = new Processor(2,mc2);

        Processor[] processors = {p1, p2};
        Ram ram = new Ram(processors);

        ram.read(p1, 20, 0);
        ram.read(p2, 10, 0);
        ram.read(p2, 15, 0);
        ram.read(p1, 10, 0);
        ram.write(p1, 20, 0);
        ram.write(p2, 10, 0);
        ram.write(p2, 20, 0);
        ram.write(p1, 10, 0);
    }
}
