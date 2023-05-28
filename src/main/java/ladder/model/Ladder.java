package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder() {}

    public Ladder(List<Line> lines) { this.lines = lines;}

    public static Ladder of(int size, int height){
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(size));
        }
        return new Ladder(lines);
    }
    public void makeLine(int size, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(size));
        }
    }

    public List<Line> getLines() {
        return lines;
    }


    public int end(int start){

        for (int i = 0; i < lines.size(); i++) {
            Line stage = lines.get(i);
            start = stage.next(start);
        }

        return start;
    }
}
