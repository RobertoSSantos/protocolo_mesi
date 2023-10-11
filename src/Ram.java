public class Ram {
    private Boolean[] ends;
    private Processor[] processors;

    public Ram( Processor[] processors) {
        this.ends = new Boolean[32];
        this.processors = processors;
    }

    public Processor changeProcessor(Processor processor){
        for(Processor p : this.processors)
            if(!processor.equals(p)){
                Processor other = p;
                return other;
            }
        return null;
    }

    public Cell find_cell(Processor processor, int memAdd){
        for(Cell c : processor.getCache().cells){
            if(c.getValue() == memAdd){
                Cell difCell = c;
                return difCell;
            }
        }
        return null;
    }

    public void read(Processor processor, int memAdd, int cell){
        if(!this.ends[memAdd]){
            if(processor.getCache().cells[cell].getTag() == Tags.INVALIDA){
                processor.getCache().cells[cell].setTag(Tags.EXCLUSIVA);
                processor.getCache().cells[cell].setValue(memAdd);
                System.out.println("Leitura Realizada");
                System.out.println(processor.getCache().cells[cell].toString());
            }
            this.ends[memAdd] = true;
        } else {
            switch (processor.getCache().cells[cell].getTag()){
                case MODIFICADA:
                    processor.getCache().cells[cell].setTag(Tags.MODIFICADA);
                    System.out.println("Falha de Leitura - Alteracao de estado Compartilhado");
                    break;
                case EXCLUSIVA:
                    processor.getCache().cells[cell].setTag(Tags.COMPARTILHADA);
                    System.out.println("Falha de Leitura - Alteracao de estado Compartilhado");
                    break;
                case COMPARTILHADA:
                    System.out.println("Leitura Realizada");
                    break;
                case INVALIDA:
                    processor.getCache().cells[cell].setTag(Tags.COMPARTILHADA);
                    System.out.println("Celula Invalida - Alteracao de estado Compartilhado");
                    break;
                default:
                    break;
            }

            Processor difProcessor = changeProcessor(processor);
            Cell difCell = find_cell(difProcessor, memAdd);

            for (Cell c : difProcessor.getCache().cells){
                if (c == difCell){
                    switch(c.getTag()){
                        case MODIFICADA:
                            c.setTag(Tags.COMPARTILHADA);
                            System.out.println("Falha de Leitura - Alteracao de estado Compartilhado");
                            break;
                        case EXCLUSIVA:
                            c.setTag(Tags.COMPARTILHADA);
                            System.out.println("Falha de Leitura - Alteracao de estado Compartilhado");
                            break;
                        case COMPARTILHADA:
                            System.out.println("Leitura Realizada");
                            break;
                        case INVALIDA:
                            c.setTag(Tags.COMPARTILHADA);
                            System.out.println("Celula Invalida - Alteracao de estado Compartilhado");
                            break;
                        default:
                            break;
                    }
                }
            }

        }
    }

    public void write(Processor processor, int memAdd, int cell){
        if(!this.ends[memAdd]){
            if(processor.getCache().cells[cell].getTag() == Tags.INVALIDA){
                processor.getCache().cells[cell].setTag(Tags.MODIFICADA);
                processor.getCache().cells[cell].setValue(memAdd);
            }
            this.ends[memAdd] = true;
        } else {
            switch (processor.getCache().cells[cell].getTag()){
                case MODIFICADA:
                    processor.getCache().cells[cell].setValue(memAdd + 1);
                    System.out.println("Escrita Realizada - Valor Atualizado");
                    break;
                case EXCLUSIVA:
                    processor.getCache().cells[cell].setValue(memAdd + 1);
                    processor.getCache().cells[cell].setTag(Tags.MODIFICADA);
                    System.out.println("Escrita Realizada - Valor Atualizado");
                    break;
                case COMPARTILHADA:
                    Processor difProcessor = changeProcessor(processor);
                    Cell difCell = find_cell(difProcessor, memAdd);

                    for (Cell c : difProcessor.getCache().cells){
                        if (c == difCell){
                            c.setTag(Tags.INVALIDA);
                            break;
                        }
                    }
                    processor.getCache().cells[cell].setValue(memAdd + 1);
                    processor.getCache().cells[cell].setTag(Tags.MODIFICADA);
                    System.out.println("Escrita Realizada - valor atualizado, copias invalidadas");
                    break;
                default:
                    break;
            }
        }
    }
}
