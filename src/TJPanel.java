import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class TJPanel extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int size = getWidth() / Grid.matrix.size();
        for(int i=0; i < Grid.matrix.size(); i++)
        {
            ArrayList<Integer> temp = Grid.matrix.get(i);
            for(int j=0; j<temp.size(); j++)
            {
                if(Grid.matrix.get(i).get(j) == 1){
                    g2d.setColor(Color.decode("#F58A07"));
                }
                else {
                    g2d.setColor(Color.decode("#183642"));
                }
                g2d.fillRect(j*size, i*size, size, size);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(j*size, i*size, size, size);
            }
        }
    }

    class AnimationThread extends Thread{
        public void run(){
            repaint();
            while(true)
            {
                try {
                    sleep(0,100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }
        }
    }

    TJPanel(){
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.f),Color.BLACK)); //ustawiamy obrzeza Jpanelu
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point cords = getMousePosition();
                if(cords==null) return;

//                System.out.println(cords);
//                System.out.println(getWidth());
//                System.out.println(getHeight());

                int row = cords.y/(getWidth()/Grid.matrix.size());
                int col = cords.x/(getHeight()/Grid.matrix.size());

                Grid.matrix.get(row).set(col,1);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Point cords = getMousePosition();
                if(cords==null) return;

                System.out.println(cords);
                System.out.println(getWidth());
                System.out.println(getHeight());

                int row = cords.y/(getWidth()/Grid.matrix.size());
                int col = cords.x/(getHeight()/Grid.matrix.size());

                Grid.matrix.get(row).set(col,1);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        (new AnimationThread()).start();
    }
}
