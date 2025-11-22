public class Fila {
    private int inicio;
    private int fim;
    private int total;
    private String elementos[];
    public static final int TAMANHO=1000;
    
    //  FIFO --> First Int, First Out
    public Fila() {
        inicio = 0;
        fim = 0;
        total = 0;
        elementos = new String[TAMANHO];
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == TAMANHO;
    }
    
    // A divisão por % TAMANHO tem como objetivo implementar um comportamento circular
    // Ex: TAMANHO = 3. [1, 2, 3], (0+1) % TAMANHO = 1, (1+1) % TAMANHO = 2, (2+1) % TAMANHO = 0  ....
    // Sempre volta para o índice 0

    public void inserir(String elemento) {
        elementos[fim] = elemento;
        fim = (fim + 1) % TAMANHO;
        total++;
    }

    public String retirar() {
        String elemento = elementos[inicio];
        inicio = (inicio + 1) % TAMANHO;
        total--;
        return elemento;
    }
}
