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

//        Integer[] options = {10,50,100,200,300,450};
//        JComboBox<Integer> comboBox = new JComboBox<>(options);
//        comboBox.setSelectedItem(100);
//        comboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        northPanel.add(comboBox);

//        JButton ShuffleButton = new JButton("Shuffle");
//        ShuffleButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//            }
//        });
//        northPanel.add(ShuffleButton);


        JButton BubbleSort = new JButton("BubbleSort Start");
        BubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        northPanel.add(BubbleSort);


        JButton SelectionSort = new JButton("SelectionSort Start");
        SelectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        northPanel.add(SelectionSort);

        JButton HeapSort = new JButton("HeapSort Start");
        HeapSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        northPanel.add(HeapSort);

        JButton QuickSort = new JButton("QuickSort Start");
        QuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        northPanel.add(QuickSort);


        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        northPanel.add(stop);

        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);
    }

    class BubbleSortThread extends Thread{
        @Override
        public void run(){

        }
    }
}
