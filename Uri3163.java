import java.util.Scanner;

public class Uri3163 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String linha;
        int filaAtual=0;
        Fila aeronave_leste, aeronave_oeste, aeronave_sul, aeronave_norte;
        StringBuilder resultado = new StringBuilder();

        aeronave_leste = new Fila();
        aeronave_oeste = new Fila();
        aeronave_sul = new Fila();
        aeronave_norte = new Fila();

        // Parte 1: leitura - inserção dos aviões nas respectivas filas
        while (teclado.hasNext()) {
            linha = teclado.nextLine();
            if (linha.equals("0")) {
                break;
            }
            else if (linha.equals("-1")) {
                filaAtual = -1;
            }
            else if (linha.equals("-2")) {
                filaAtual = -2;
            }
            else if (linha.equals("-3")) {
                filaAtual = -3;
            }
            else if (linha.equals("-4")) {
                filaAtual = -4;
            }
            else { // Código do avião
                if (filaAtual == -1) { // oeste
                    aeronave_oeste.inserir(linha);
                }
                else if (filaAtual == -2) { // sul
                    aeronave_sul.inserir(linha);
                }
                else if (filaAtual == -3) { // norte
                    aeronave_norte.inserir(linha);
                }
                else if (filaAtual == -4) { // leste
                    aeronave_leste.inserir(linha);
                }
            }
        }
        // Retirar das filas segundo o critério definido
        // Oeste - Norte - Sul - Leste
        while ( ! (aeronave_oeste.isEmpty() && aeronave_norte.isEmpty() &&
                aeronave_sul.isEmpty() && aeronave_leste.isEmpty())) {
                
                if (!aeronave_oeste.isEmpty()) {
                    resultado.append(aeronave_oeste.retirar() + " ");
                }
                if (!aeronave_norte.isEmpty()) {
                    resultado.append(aeronave_norte.retirar() + " ");
                }
                if (!aeronave_sul.isEmpty()) {
                    resultado.append(aeronave_sul.retirar() + " ");
                }
                if (!aeronave_leste.isEmpty()) {
                    resultado.append(aeronave_leste.retirar() + " ");
                }
            }
        System.out.println(resultado.toString().trim());
    }
    
    private static class Fila {
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
}




