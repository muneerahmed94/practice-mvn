import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Muneer on 16-04-2017.
 */
public class App {
    private JButton button1;
    private JPanel panel1;
    private JTextField textField1;

    public App() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button");
                String path = null;
                try {
                    path = String.valueOf(new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
                    System.out.println();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
                System.out.println(path);
                textField1.setText(path);
            }
        });
    }

    public static void main(String args[]) {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new App().panel1);
        jFrame.setPreferredSize(new Dimension(400, 200));
        jFrame.pack();;
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
