import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(100);

        TJFrame frame = new TJFrame();
        frame.setSize(1200,1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}