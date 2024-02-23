import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class TJFrame extends JFrame {


    TJPanel tjpanel = new TJPanel();

    static int ArraySize = 100;

    TJFrame(){
        super("OKNO");
        buildGui();

    }

    void buildGui()
    {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();


        JButton start = new JButton("Start/Continue");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grid.isRunning = true;
            }
        });
        northPanel.add(start);



        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grid.isRunning = false;
            }
        });
        northPanel.add(stop);

        tjpanel.setPreferredSize(new Dimension(800,800));
        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);
    }
}
