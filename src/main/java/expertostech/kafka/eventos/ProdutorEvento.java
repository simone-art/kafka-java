package expertostech.kafka.eventos;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

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
        return new KafkaProducer<String, String>(properties);
    }

    //Método que executará o envio da mensagem
    public void executar(){

        //Permite identificar a chave única com o código hexadecimal
        String chave = UUID.randomUUID().toString();
        //Formatando a data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String mensagem = sdf.format(new Date());
        //Concatenar a mensagem
        mensagem += "|" + chave;
        mensagem += "|NOVA_MENSAGEM";

        //Código que registro o tópico
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("RegistroEvento", chave, mensagem);
        //Código que envia o tópico
        producer.send(record);
        //Código que garante o envio do tópico
        producer.flush();
        //Aplicacão será executada toda vez que se tenha uma mensagem
        producer.close();
    }
}
