import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;

public class JanelaUrna {
    private static JanelaUrna instancia;

    private JFrame mainFrame;
    private JLabel screenLabel;
    private JPanel controlPanel;
    private TelaControle telaControle;
    private boolean visibility;

    public JanelaUrna(){
        prepareGUI();
    }

    public static synchronized JanelaUrna getInstance() {
        if (instancia == null) {
            instancia = new JanelaUrna();
        }
        return instancia;
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Urna Eletrônica");
        mainFrame.setSize(1000,400);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildScreen();
        telaControle = new TelaControle(mainFrame);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
        visibility = false;
        mainFrame.setVisible(false);
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

        Colegiado colegiado = Colegiado.getInstance();
        String text = new String();
        for (Candidato candidato: colegiado.getCandidatos() ) {
            text += String.format(
                "%d: [%s] %s<br>",
                candidato.getCodigo(), candidato.getPartido(), candidato.getNome());
        }
        screenLabel.setText("<html>" + text + "</html>");
    }

    public void listenVoteComplete(Observer observer) {
        telaControle.addObserver(observer);
    }

    private void toggleVisibility() {
        visibility = !visibility;
        mainFrame.setVisible(visibility);
    }

    public void toggleVoto() {
        toggleVisibility();
        telaControle.resetGUI();
    }
}
