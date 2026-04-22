public class Teste{
    public static void main(String[] args){
        VectorArray vector = new VectorArray(5);

        //StringBuilder valores = new StringBuilder(); !!! Só para lembrar

        for (int rank = 0; rank < 6; rank++){
            vector.insertAtRank(rank,"Vectoooor" + rank);
        }
        for (int ele = 0; ele< vector.size(); ele++){
            System.out.println(vector.eleAtRank(ele));
        }

        System.out.println(vector.removeAtrank(5));
    }
}