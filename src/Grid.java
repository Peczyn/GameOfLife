import java.util.ArrayList;
import java.util.Random;

public class Grid {
    public static ArrayList<ArrayList<Integer>> matrix;
    public static ArrayList<ArrayList<Integer>> neighbours;
    public static boolean isRunning = false;

    public Grid(int size){
        Random random = new Random();
        matrix = new ArrayList<>();
        neighbours = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
//                row.add(random.nextInt(2)); //
                if(i%2 != j%2) row.add(1);
                else row.add(0);
            }
            matrix.add(row);

        }
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(0);
            }
            neighbours.add(row);
        }
        (new gridNeighboursThread()).start();
    }

    class gridNeighboursThread extends Thread{
        @Override
        public void run(){
            int n = matrix.size();

            while(!isRunning){
                try {
                    sleep(0,10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    int neg = 0;
                    if(i>0 && matrix.get(i-1).get(j) == 1) {neg++;}
                    if(j>0 && matrix.get(i).get(j-1) == 1) {neg++;}
                    if(i<n-1 && matrix.get(i+1).get(j) == 1) {neg++;}
                    if(j<n-1 && matrix.get(i).get(j+1) == 1) {neg++;}
                    if(i>0 && j>0 && matrix.get(i-1).get(j-1) == 1) {neg++;}
                    if(i<n-1 && j<n-1 && matrix.get(i+1).get(j+1) == 1) {neg++;}
                    if(i>0 && j<n-1 && matrix.get(i-1).get(j+1) == 1) {neg++;}
                    if(i<n-1 && j>0 && matrix.get(i+1).get(j-1) == 1) {neg++;}

                    neighbours.get(i).set(j,neg);
                }
            }
            (new gridUpdateThread()).start();
        }
    }

    class gridUpdateThread extends Thread{
        @Override
        public void run(){
            for(int i=0; i<matrix.size(); i++)
            {
                for(int j=0; j<matrix.size(); j++)
                {

                    if(matrix.get(i).get(j)==1){
                        if(neighbours.get(i).get(j)<2 || neighbours.get(i).get(j)>3) matrix.get(i).set(j,0);
                    }
                    else{
                        if(neighbours.get(i).get(j)==3) matrix.get(i).set(j,1);
                    }
                }
            }


            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            (new gridNeighboursThread()).start();
        }
    }

}
