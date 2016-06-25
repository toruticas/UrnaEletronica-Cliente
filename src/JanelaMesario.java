import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

public class JanelaMesario implements Observer {
    private static JanelaMesario instancia;

    private JFrame mainFrame;
    private JLabel screenLabel;
    private JPanel controlPanel;
    private JButton options[];
    private TelaControle telaControle;
    private boolean visibility;

    public JanelaMesario(){
        prepareGUI();
    }

    public static synchronized JanelaMesario getInstance() {
        if (instancia == null) {
            instancia = new JanelaMesario();
        }
        return instancia;
    }

    @Override
    public void update(Observable o, Object arg) {
        toggleVoto();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Controle Urna Eletrônica");
        mainFrame.setSize(400,250);
        mainFrame.setLayout(new GridLayout(1, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildScreen();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
        visibility = true;
        mainFrame.setVisible(true);

        JanelaUrna janelaUrna = JanelaUrna.getInstance();
        janelaUrna.listenVoteComplete(this);
    }

    private void buildScreen() {
        options = new JButton[2];
        options[0] = new JButton("Iniciar Voto");
        options[0].setActionCommand("1");
        options[0].addActionListener(new ButtonClickListener());
        mainFrame.add(options[0]);
        options[1] = new JButton("Finalizar Votação");
        options[1].setActionCommand("888");
        options[1].addActionListener(new ButtonClickListener());
        mainFrame.add(options[1]);
    }

    private void toggleVisibility(){
        visibility = !visibility;
        mainFrame.setVisible(visibility);
    }

    public void toggleVoto() {
        toggleVisibility();
        JanelaUrna janelaUrna = JanelaUrna.getInstance();
        janelaUrna.toggleVoto();
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "1" ))  {
                toggleVoto();
            } else if( command.equals( "888" ))  {
                Requisicao requisicao = Requisicao.getInstance();
                requisicao.finalizarVotacao();
            }
        }
    }
}
