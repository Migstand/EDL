public class SpeedTeste{
    public static void main(String[] args){
        long time = System.currentTimeMillis();
        System.out.println(time + " ms");
        PilhaArray lista = new PilhaArray(10, 10);
        for(int f = 0; f<10; f++){
            lista.push(1);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(lista.size());
        System.out.println(time2 + " ms");
        System.out.println(time2 - time);
    }
}