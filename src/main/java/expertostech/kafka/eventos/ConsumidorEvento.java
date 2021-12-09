package expertostech.kafka.eventos;

import kafka.Kafka;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

@Slf4j
public class ConsumidorEvento {

    private final KafkaConsumer<String, String> consumer;

    public ConsumidorEvento(){
        consumer = criarConsumer();
    }



    private KafkaConsumer<String, String> criarConsumer() {
        if(consumer != null){
            return consumer;
        }

        //Configurando as propiedades do kafka e sua serialização
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");

        return new KafkaConsumer<String, String>(properties);
    }

    public void executar(){
        List<String> topicos = new ArrayList<>();
        topicos.add("RegistroEvento");
        consumer.subscribe(topicos);

        log.info("Iniciando o consumer");
        boolean continuar = true;
        while (continuar){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String, String> record:records){
                gravarMensagem(record.topic(), record.partition(), record.value());
                if(record.value().equals("FECHAR")){
                    continuar = false;
                }

            }
        }
        consumer.close();
    }

    private void gravarMensagem(String topico, int particao, String mensagem){
        log.info("Topico:{}, Particao:{}, Mensagem:{}", topico, particao, mensagem);

    }


}
