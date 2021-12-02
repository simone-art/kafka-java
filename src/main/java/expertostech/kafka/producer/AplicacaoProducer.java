package expertostech.kafka.producer;

import expertostech.kafka.eventos.ProdutorEvento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
