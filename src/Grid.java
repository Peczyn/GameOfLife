import java.util.ArrayList;

public class Grid {
    public static ArrayList<ArrayList<Integer>> matrix;

    public Grid(int size){
        matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(0);
            }
            matrix.add(row);
        }
    }

}
