public class Ordenacao {
    public static void main(String[] args) {
        int[] vetor = { 33, 31, 25, 79, 72, 55, 76, 21, 1, 18, 30, 25, 98, 12, 63, 98, 50, 17, 84, 1, 23, 45,
                17, 56, 45, 71, 78, 91, 60, 59, 6, 36, 91, 51, 30, 44, 41, 37, 32, 99, 29, 72, 15, 48, 33, 80, 80,
                74, 29, 31, 58, 38, 59, 64, 72, 92, 8, 89, 60, 46, 39, 71, 13, 1, 4, 77, 70, 35, 9, 83, 74, 49, 39,
                89, 72, 59, 13, 1, 68, 30, 40, 40, 38, 37, 41, 55, 47, 55, 36, 36, 72, 76, 93, 76, 40, 50, 91, 100,
                34, 10 };

        mergeSort(vetor);

        for (int numero : vetor) {
            System.out.print(numero + " ");
        }
    }

    public static void troca(int[] vetor, int primeiroIndice, int segundoIndice) {
        int auxiliar = vetor[primeiroIndice];
        vetor[primeiroIndice] = vetor[segundoIndice];
        vetor[segundoIndice] = auxiliar;
    }

    // Explicação do algoritmo: https://www.youtube.com/watch?v=xli_FI7CuzA
    // Complexidade: O(n^2)
    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    troca(vetor, j, j + 1);
                }
            }
        }
    }

    // Explicação do algoritmo: https://www.youtube.com/watch?v=g-PGLbMth_g
    // Complexidade: O(n^2)
    public static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int posicaoMenor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[posicaoMenor]) {
                    posicaoMenor = j;
                }
            }
            if (posicaoMenor != i) {
                troca(vetor, i, posicaoMenor);
            }
        }
    }

    // Explicação do algoritmo: https://www.youtube.com/watch?v=JU767SDMDvA
    // Complexidade: O(n^2)
    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int j = i;
            while (j > 0 && vetor[j - 1] > vetor[j]) {
                troca(vetor, j, j - 1);
                j--;
            }
        }
    }

    // Explicação do algoritmo: https://www.youtube.com/watch?v=4VqmGXwpLqc
    // Complexidade: O(n log n)
    // Ótimo desempenho em listas longas, não recomendado para listas pequenas.
    public static void mergeSort(int[] vetor) {
        mergeSort(vetor, 0, vetor.length - 1);
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio + 1, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int[] vetorEsquerda = new int[meio - inicio];
        int[] vetorDireita = new int[fim - meio + 1];

        for (int i = 0; i < vetorEsquerda.length; i++) {
            vetorEsquerda[i] = vetor[inicio + i];
        }

        for (int i = 0; i < vetorDireita.length; i++) {
            vetorDireita[i] = vetor[meio + i];
        }

        int ponteiroEsquerda = 0;
        int ponteiroDireita = 0;

        for (int i = inicio; i <= fim; i++) {
            if (ponteiroDireita >= vetorDireita.length || (ponteiroEsquerda < vetorEsquerda.length && vetorEsquerda[ponteiroEsquerda] < vetorDireita[ponteiroDireita])) {
                vetor[i] = vetorEsquerda[ponteiroEsquerda];
                ponteiroEsquerda++;
            } else {
                vetor[i] = vetorDireita[ponteiroDireita];
                ponteiroDireita++;
            }
        }
    }

    // Explicação do algoritmo: https://www.youtube.com/watch?v=wx5juM9bbFo&t=946s
    // Complexidade: O(n^2)
    // Na maioria dos casos tem desempenho O(n log n), em média mais rápido que o merge sort.
    // Entretando, más escolhas de pivô fazer com que o tempo de execução se torne quadrático.
    // // Excelente desempenho em listas longas (caso a escolha de pivô seja boa), não recomendado para listas pequenas.
    public static void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particiona(vetor, inicio, fim);
            quickSort(vetor, inicio, pivo - 1);
            quickSort(vetor, pivo + 1, fim);
        }
    }

    public static int particiona(int[] vetor, int inicio, int fim) {
        // Nosso pivô será sempre o elemento mais a direita (pivo = fim)
        // Existem formas melhores de escolher o pivô, mas esse não é o foco do nosso algoritmo.

        int limite = inicio;
        for (int i = inicio; i < fim; i++) {
            if (vetor[fim] > vetor[i]) {
                troca(vetor, i, limite);
                limite++;
            }
        }
        troca(vetor, limite, fim);
        return limite;
    }
}
