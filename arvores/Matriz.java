public class Matriz{
    public static void main(String[] args){
        int[][] matriz = new int[3][4];

        // 2. Preenchendo um valor específico (linha 0, coluna 1)
        matriz[0][1] = 10;

        // 3. Inicialização direta
        int[][] matriz2 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int i = 0; i < matriz.length; i++) { // Percorre linhas
            for (int j = 0; j < matriz[i].length; j++) { // Percorre colunas
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz2.length; i++) { // Percorre linhas
            for (int j = 0; j < matriz2[i].length; j++) { // Percorre colunas
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }
    }
}