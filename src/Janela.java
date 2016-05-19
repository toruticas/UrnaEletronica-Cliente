import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela {
    private JFrame mainFrame;
    private JLabel screenLabel;
    private JPanel controlPanel;
    private TelaControle telaControle;

    public Janela(){
        prepareGUI();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Urna Eletrônica");
        mainFrame.setSize(1000,400);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildScreen();
        telaControle = new TelaControle(mainFrame);
        mainFrame.setVisible(true);
    }

    private void buildScreen() {
        GridBagConstraints c = new GridBagConstraints();

        screenLabel = new JLabel("",JLabel.CENTER );
        c.ipadx = 550;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainFrame.add(screenLabel, c);
        screenLabel.setText("Buttons Section");
    }
}
