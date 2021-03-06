package expertostech.kafka.consumer;

import expertostech.kafka.eventos.ConsumidorEvento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AplicacaoConsumer {
    public static void main(String[] args) {
        AplicacaoConsumer aplicacao = new AplicacaoConsumer();
        aplicacao.iniciar();

    }

    //Método que vai iniciar o nosso programa
    private void iniciar(){
        log.info("Iniciando a aplicação");
        ConsumidorEvento consumidor = new ConsumidorEvento();
        consumidor.executar();

    }
}
