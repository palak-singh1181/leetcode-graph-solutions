
public class KthSymbolInGrammar {

    public static int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;

        int parent = kthGrammar(n - 1, (k + 1) / 2);

        if (k % 2 == 1)
            return parent;
        else
            return 1 - parent;
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 5;

        System.out.println("Answer: " + kthGrammar(n, k));
    }
}