import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaControle {
    private JFrame mainFrame;
    private JPanel controlPanel;
    private JPanel optionsPanel;
    private JPanel actionsPanel;
    private JButton options[];
    private JButton actions[];

    TelaControle(JFrame frame) {
        this.mainFrame = frame;
        optionsPanel = new JPanel();
        actionsPanel = new JPanel();
        options = new JButton[10];
        actions = new JButton[3];
        controlPanel = new JPanel();

        controlPanel.setLayout(new GridLayout(2,1));
        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        mainFrame.add(controlPanel, c);

        buildOptions();
        buildActions();
    }

    private void buildOptions() {
        optionsPanel.setLayout(new GridLayout(4,3));
        for( Integer i=1 ; i<10 ; i++) {
            buildOptionButton(Integer.toString(i), i);
        }
        JLabel nullLabel = new JLabel("",JLabel.CENTER );
        optionsPanel.add(nullLabel);
        buildOptionButton(Integer.toString(0), 9);
        controlPanel.add(optionsPanel);
    }

    private void buildOptionButton(String name, Integer id) {
        options[id] = new JButton(name);
        options[id].setActionCommand(name);
        options[id].addActionListener(new ButtonClickListener());
        optionsPanel.add(options[id]);
    }

    private void buildActions() {
        actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridBagLayout());

        buildActionButton("Branco", 0, Color.WHITE);
        buildActionButton("Corrige", 1, Color.RED);
        buildActionButton("Confirma", 2, Color.GREEN);
        controlPanel.add(actionsPanel);
    }

    private void buildActionButton(String name, Integer id, Color bg) {
        actions[id] = new JButton(name);
        actions[id].setBackground(bg);
        actions[id].setOpaque(true);
        actions[id].setActionCommand(name);
        actions[id].addActionListener(new ButtonClickListener());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(100,10,0,10);
        c.ipady = 30;
        c.weightx = 0.33;
        c.gridx = id;
        actionsPanel.add(actions[id], c);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            Colegiado colegiado = Colegiado.getInstance();

            if (command == "Confirma") {
                System.out.println("XXX: Implement Confirma");
            } else if (command == "Branco") {
                colegiado.computarVoto(Colegiado.VOTO_BRANCO);
            } else if (command == "Corrige") {
                System.out.println("XXX: Implement Corrige");
            } else {
                System.out.println("XXX: Implement Else");
            }
        }
    }
}
