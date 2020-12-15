package in.nareshit.raghu;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerService {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		
		KafkaProducer<String,String> prodOb = new KafkaProducer<String, String>(props);
		
		ProducerRecord<String, String> record=new ProducerRecord<String, String>("nitone", "Hi Kafka");
		
		prodOb.send(record);
		prodOb.flush();
		prodOb.close();
		
		System.out.println("DONE");
	}
}
