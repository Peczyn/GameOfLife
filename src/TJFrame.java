import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Hashtable;

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


        JButton start = new JButton("Start");
        start.addActionListener(e -> Grid.isRunning = true);
        northPanel.add(start);



        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> Grid.isRunning = false);
        northPanel.add(stop);

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            for(int i=0; i<Grid.matrix.size(); i++)
            {
                for(int j=0; j<Grid.matrix.size(); j++)
                {
                    Grid.matrix.get(i).set(j,0);
                }
            }
        });
        northPanel.add(reset);

        JPanel comboBoxPanel = new JPanel();
        Integer[] options = {5,10,15,20,25,30,40,50};
        JComboBox<Integer> comboBox = new JComboBox<>(options);
        comboBox.setSelectedItem(20);
        comboBox.addActionListener(e -> {
            Grid.generateGrid((Integer) comboBox.getSelectedItem());
        });
        JLabel comboLabel = new JLabel("Grid Size");

        comboBoxPanel.add(comboLabel, BorderLayout.NORTH);
        comboBoxPanel.add(comboBox, BorderLayout.CENTER);
        northPanel.add(comboBoxPanel);


        JPanel delaySliderPanel = new JPanel();
        delaySliderPanel.setLayout(new BorderLayout());

        JLabel delayLabel = new JLabel("Simulation Speed");

        JSlider delaySlider = new JSlider(JSlider.HORIZONTAL,
                1, 10, 5);
        delaySlider.addChangeListener(e -> Grid.delay = delaySlider.getValue());

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(1, new JLabel("Slow"));
        labelTable.put(10, new JLabel("Fast"));

        delaySlider.setLabelTable(labelTable);
        delaySlider.setPaintLabels(true);

        delaySliderPanel.add(delayLabel, BorderLayout.NORTH);
        delaySliderPanel.add(delaySlider, BorderLayout.CENTER);
        delaySlider.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        northPanel.add(delaySliderPanel);

        tjpanel.setPreferredSize(new Dimension(600,600));
        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);
    }
}
