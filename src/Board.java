import java.util.ArrayList;

/* COPYRIGHT (C) 2013 Christian Petry. All Rights Reserved. */ 
public class Board {
    private final int WIDTH = 5, HEIGHT = 6;
    
    
    ArrayList<Character> arr = new ArrayList<Character>();

    public void getField(int x, int y){
        arr.get(x + y * WIDTH);
    }
    
    public int getWidth(){
        return this.WIDTH;
    }
}
