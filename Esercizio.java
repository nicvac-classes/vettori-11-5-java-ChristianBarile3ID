import java.util.Scanner;
import java.util.Random;
class Esercizio {

    public static int rimuoviElemento(int vettore[], int posizione) {
        int i;
        for (i=posizione; i<vettore.length; i++) {
            vettore[i] = vettore[i+1];
        }
        return vettore.length-1;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner( System.in );
        Random random = new Random();
        int N, coppie, cornici, i, j;
        boolean trovato;
        System.out.println("Inserisci il numero di listelli presenti nella cassettiera: ");
        N = Integer.parseInt(in.nextLine());
        int[] listelli = new int[N];
        for (i=0; i<listelli.length; i++) {
            listelli[i] = (random.nextInt(7))+4;
        }
        trovato = true;
        coppie = 0;
        while (N<=2 && trovato) {
            trovato = false;
            for (i=0; i<listelli.length-1; i++) {
                for (j=i+1; j<listelli.length; j++) {
                    if (listelli[i]==listelli[j]) {
                        N = rimuoviElemento(listelli, i);
                        N = rimuoviElemento(listelli, j);
                        trovato = true;
                        coppie++;
                        i = 0;
                    }
                }
            }
        }
        cornici = coppie/2;
        System.out.println("L'artigiano ha fabbricato " + cornici + " cornici.");
    }
}
