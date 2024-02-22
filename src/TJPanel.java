import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TJPanel extends JPanel{
    private Grid grid;

    public void addGrid(Grid grid){
        this.grid = grid;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int size = getWidth() / grid.matrix.size();
        for(int i=0; i < grid.matrix.size(); i++)
        {
            ArrayList<Integer> temp = grid.matrix.get(i);
            for(int j=0; j<temp.size(); j++)
            {
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(j*size, i*size, size, size);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(j*size, i*size, size, size);
            }
        }
    }

    class AnimationThread extends Thread{
        public void run(){
            while(true)
            {
                try {
                    sleep(0,10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }
        }
    }

    TJPanel(){
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.f),Color.BLACK)); //ustawiamy obrzeza Jpanelu

        (new AnimationThread()).start();
    }
}
