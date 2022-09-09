import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("IP Finder Program");
        jFrame.setBounds(100,100,1000,100);
        jFrame.setVisible(true);

        JLabel label = new JLabel("Enter URL: ");
        label.setBounds(50, 70, 150, 200);

        JTextField textField = new JTextField();
        textField.setBounds(50,10,200,20);

        JButton button = new JButton("Find IP: ");
        button.setBounds(50,50,80,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = textField.getText();

                try{
                    InetAddress ia = InetAddress.getByName(url);
                    String ip = ia.getHostAddress();
                    JOptionPane.showMessageDialog(jFrame, ip);

                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jFrame.add(label);
        jFrame.add(button);
        jFrame.add(textField);
        jFrame.setLayout(new GridLayout());
    }
}