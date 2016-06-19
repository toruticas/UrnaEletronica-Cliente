import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.ArrayList;

public class Requisicao {
    private static Requisicao instancia;

    protected Socket echoSocket;
    protected PrintWriter outputStream;
    protected BufferedReader inputStream;
    protected Colegiado colegiado;
    protected InetAddress hostName;
    protected int portNumber;

    Requisicao(String[] args) {
        if (args.length != 2) {
            System.err.println(
                "Usage: java -jar UrnaEletronica.jar http://<host name> <port number>");
            System.exit(1);
        }

        try {
            hostName = InetAddress.getByName(new URL(args[0]).getHost());
            portNumber = Integer.parseInt(args[1]);

            echoSocket = new Socket(hostName, portNumber);
            outputStream = new PrintWriter(echoSocket.getOutputStream(), true);
            inputStream = new BufferedReader(
                new InputStreamReader(echoSocket.getInputStream()));
            outputStream.println("999");
            if ((inputStream.readLine()).equals("100") == true ) {
                colegiado = Colegiado.getInstance();
                criarColegiado();
            } else {
                System.exit(1);
            }
            // echoSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }

    public static synchronized Requisicao getInstance(String[] args) {
        if (instancia == null) {
            instancia = new Requisicao(args);
        }
        return instancia;
    }

    public static synchronized Requisicao getInstance() {
        String[] args = new String[1];
        if (instancia == null) {
            instancia = new Requisicao(args);
        }
        return instancia;
    }

    public void criarColegiado() throws IOException{
        String line;
        while ((line = inputStream.readLine()) != null ) {
            if(!line.isEmpty()) {
                String[] parts = line.split(",");
                if(parts.length == 3) {
                    colegiado.putCandidato(new Candidato(
                        Integer.parseInt(parts[0]), parts[2], parts[1]));
                }
            }
        }
    }

    public void finalizarVotacao() {
        try {
            Socket socket = new Socket(hostName, portNumber);
            outputStream = new PrintWriter(socket.getOutputStream(), true);
            inputStream = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            String out = new String("888\n");
            for (Candidato candidato: colegiado.getCandidatos())
                out += String.format(
                    "%d|%d\n",
                    candidato.getCodigo(), candidato.getNumeroVotos());

            System.out.println(out);
            Colegiado colegiado = Colegiado.getInstance();
            out += String.format("%d|%d\n", Colegiado.VOTO_BRANCO, colegiado.getBrancos());
            out += String.format("%d|%d\n", Colegiado.VOTO_NULO, colegiado.getNulos());

            outputStream.println(out);
            System.out.println(inputStream.readLine());
            System.exit(1);
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
