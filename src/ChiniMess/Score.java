package ChiniMess;

import Figures.Figure;

public class Score {
    public static int calculateScore(Board b){
        int score = 0;
        for (int r = 0; r < 6; r++)
            for (int c = 0; c < 5; c++){
                Square s = new Square(c, r);
                if (!s.isValid())
                    throw new IllegalArgumentException("wrong square!");
                Figure f = b.getFigureFromField(s);
                
                if (f == null) 
                    score += 0;
                else if (f.getColor() == true)  // is white
                    score += f.getScore();
                else if (f.getColor() == false) // is black
                    score -= f.getScore();
            }
        return score;
    }
}
