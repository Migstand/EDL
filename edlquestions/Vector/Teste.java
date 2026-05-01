public class Teste{
    public static void main(String[] args){

        System.out.println("Teste da classe VectorArray");
        System.out.println(":---------------------------------------------:");
        System.out.println("");

        VectorArray vector = new VectorArray(5);

        //StringBuilder valores = new StringBuilder(); !!! Só para lembrar

        for (int rank = 0; rank < 6; rank++){
            vector.insertAtRank(rank,"Vectoooor" + rank);
        }
        for (int ele = 0; ele< vector.size(); ele++){
            System.out.println(vector.eleAtRank(ele));
        }

        System.out.println(vector.removeAtrank(5));

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Teste da classe VectorLig");
        System.out.println(":------------------------------------------------:");
        System.out.println("");

        VectorLig victor = new VectorLig();

        //victor.removeAtrank(0); Erro vector vazio!!!!!!!
        //victor.insertAtRank(1, "Ola"); Erro de memória fora de alcance!!!!!!!!!

        for (int ind = 0; ind < 6; ind++){
            victor.insertAtRank(ind, "Ola" + ind);
        }

        victor.insertAtRank(0, "BOOOM");

        victor.replaceAtrank(5, "29");
        for (int i = 0; i < victor.size(); i++){
            System.out.println(victor.eleAtRank(i));
        }
        
        System.out.println("-----------------------------------------------");

        for (int i = 1; i<5; i++){
            System.out.println(victor.removeAtrank(1));
        }

        for (int i = 0; i < victor.size(); i++){
            System.out.println(victor.eleAtRank(i));
        }      
    }   
}