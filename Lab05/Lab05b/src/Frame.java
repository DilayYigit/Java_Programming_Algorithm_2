import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame {

    private static final int FRAME_SIZE = 500;

    private JLabel decimalLabel;
    private JLabel hexLabel;
    private JLabel binaryLabel;

    private JTextField decimalField;
    private JTextField hexField;
    private JTextField binaryField;


    public Frame() {

        createTextField();
        createPanel();

        setSize(FRAME_SIZE, FRAME_SIZE);
    }

    /**
     * This method creates labels, empty texts and
     * actionListener for decimal, hex and binary numbers
     * @param
     * @return
     */
    private void createTextField(){
        decimalLabel = new JLabel("Decimal: ");
        hexLabel = new JLabel("Hex: ");
        binaryLabel = new JLabel("Binary: ");

        final int FIELD_WIDTH = 40;
        decimalField = new JTextField(FIELD_WIDTH);
        hexField = new JTextField(FIELD_WIDTH);
        binaryField = new JTextField(FIELD_WIDTH);

        decimalField.setText("");
        hexField.setText("");
        binaryField.setText("");
        ActionListener decimalListener = new DecimalListener();
        ActionListener hexListener = new HexListener();
        ActionListener binaryListener = new BinaryListener();
        decimalField.addActionListener(decimalListener);
        hexField.addActionListener(hexListener);
        binaryField.addActionListener(binaryListener);
    }

    /**
     * This method creates panel into the frame and
     * add labels and texts into the panel
     * @param
     * @return
     */
    private void createPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(decimalLabel);
        panel.add(decimalField);
        panel.add(hexLabel);
        panel.add(hexField);
        panel.add(binaryLabel);
        panel.add(binaryField);
        add(panel);
    }

    /**
     * This class implements actionlistener and override its method called actionperformed
     * This method sets texts by using toHex and toBinary methods
     * @param
     * @return
     */
    public class DecimalListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = Integer.parseInt(decimalField.getText());
            hexField.setText(toHex(num));
            binaryField.setText(toBinary(num));
        }
    }

    /**
     * This class implements actionlistener and override its method called actionperformed
     * This method sets texts by using hexToDecimal and toBinary methods
     * @param
     * @return null
     */
    public class HexListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String num = hexField.getText();
            decimalField.setText( ("" + hexToDecimal(num)) );
            binaryField.setText( toBinary(hexToDecimal(num)) );
        }
    }

    /**
     *
     * @param
     * @return null
     */
    public class BinaryListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = Integer.parseInt(binaryField.getText());
            hexField.setText(toHex(binaryToDecimal(num)));
            decimalField.setText( ("" + binaryToDecimal(num)) );
        }
    }

    /**
     *
     * @param
     * @return null
     */
    public static String toBinary(int decimal){
        int binary[] = new int[40];
        int index = 0;
        String output = "";
        while(decimal > 0){
            binary[index++] = decimal%2;
            decimal = decimal/2;
        }
        for(int i = index-1;i >= 0;i--){
            output += (binary[i]);
        }
        return output;
    }

    /**
     *
     * @param
     * @return null
     */
    public static String toHex(int decimal){
        int rem;
        String hex="";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            rem=decimal%16;
            hex=hexchars[rem]+hex;
            decimal=decimal/16;
        }
        return hex;
    }

    /**
     *
     * @param
     * @return null
     */
    public static int  hexToDecimal(String s){
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }

    /**
     *
     * @param
     * @return null
     */
    public static int binaryToDecimal(int binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }
}

