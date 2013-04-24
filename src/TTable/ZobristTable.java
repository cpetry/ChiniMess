package TTable;

public class ZobristTable {
    public static long array[] = new long[30*13];
    
    public ZobristTable(){
        for (int i=0; i < 30*13; i++){
            long random_number = (long) (Math.random() * 30*13);
            array[i] = random_number;
        }
    }
    
}
