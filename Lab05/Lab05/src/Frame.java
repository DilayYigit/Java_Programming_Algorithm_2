import javax.swing.*;
public class Frame extends JFrame {
    private static final int FRAME_SIZE = 500;
    private JPanel mainPanel;
    private JLabel bottomPanel;

    //constructor
    public Frame() {
        mainPanel = new GridPanel();
        add(mainPanel);
    }
}
