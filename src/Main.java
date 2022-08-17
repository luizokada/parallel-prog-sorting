import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static String arrayToString(int[] array){
        String aux = "[" + array[0];
        for(int i = 1; i < array.length; i++){
            aux += ", " + array[i];
        }
        return aux + "]";
    }
    private static void imprimirVetor(int[] vetor) {
        System.out.println("Vetor...\n");
        for(int num : vetor) {
            System.out.print(num + ", ");
        }
    }

    public static int[] generateIntVector(int lenght) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[lenght];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(lenght); // storing random integers in an array
        }
        return arr;
    }

    public static void main(String[] args) {
        int vetor[] = {24, 66, 87, 43, 11, 27, 4, 2, 7, 8, 4, 5,
                12, 53, 42, 22, 1, 5, 9, 13, 16, 23, 13, 7, 55, 67,
                92, 22, 33, 27, 19};
        ForkJoinPool pool = new ForkJoinPool();
        ordClass sort = new ordClass();
        sort.ordenarVetorDeInteiros(vetor);
        //imprimirVetor(vetor);
        int[] A = generateIntVector(200);
        System.out.println("A (ordenado com Quicksort Mediana de 3) = " + arrayToString(A));
        //tarefa ForkJoin para ordenar o vetor A
        QuicksortForkJoinMedianThree quicksortTaskMedianThree = new QuicksortForkJoinMedianThree(A);
        //executa a tarefa utilizando o pool
        pool.invoke(quicksortTaskMedianThree);
        System.out.println("A (ordenado com Quicksort Mediana de 3) = " + arrayToString(A));
    }
}