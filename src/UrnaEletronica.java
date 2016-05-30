public class UrnaEletronica {
    public static void main(String[] args){
        Requisicao requisicao = Requisicao.getInstance(args);
        JanelaUrna janelaUrna = JanelaUrna.getInstance();
        JanelaMesario janelaMesario = JanelaMesario.getInstance();
    }
}
