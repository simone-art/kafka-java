package expertostech.kafka.producer;

import expertostech.kafka.eventos.ProdutorEvento;

public class AplicacaoProducer {
    public static void main(String[] args) {
        AplicacaoProducer aplicacao = new AplicacaoProducer();
        aplicacao.iniciar();

    }

    //Método que vai iniciar o nosso programa
    private void iniciar(){
        ProdutorEvento produtor = new ProdutorEvento();
        produtor.executar();

    }
}
