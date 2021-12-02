package expertostech.kafka.eventos;

import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class ProdutorEvento {

    private final Producer<String, String> producer;

    //Constructor vazio
    public ProdutorEvento(){
        producer = criarProducer();

    }

    //Método responsável de criar o producer
    private Producer<String, String> criarProducer(){
     if(producer != null){
         return producer;
     }

        //Configurando as propiedades do kafka e sua serialização
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
     return null;
    }

    //Método que executará o envio da mensagem
    public void executar(){

    }
}
