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

        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<Grid.matrix.size(); i++)
                {
                    for(int j=0; j<Grid.matrix.size(); j++)
                    {
                        Grid.matrix.get(i).set(j,0);
                    }
                }
            }
        });
        northPanel.add(reset);


        //DODAJ TUTAJ ZMIANE SZYBKOSCI GRY CZY COS
        //I DODAJ WYBOR DODAWANEGO OBIEKTU MOZE TAKIE GOTOWCE

        tjpanel.setPreferredSize(new Dimension(600,600));
        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);
    }
}
