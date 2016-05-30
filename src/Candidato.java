public class Candidato {
    protected int codigo;
    protected String nome;
    protected String partido;
    protected int numeroVotos;

    Candidato(int codigo, String nome, String partido) {
        this.codigo = codigo;
        this.nome = nome;
        this.partido = partido;
        this.numeroVotos = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getNumeroVotos() {
        return numeroVotos;
    }

    public void adicionarVoto() {
        numeroVotos++;
    }

    public String toString() {
        return "#" + codigo + "|" + partido + "|" + nome;
    }
}
