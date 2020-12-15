package in.nareshit.raghu;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerService {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {  
		
		Properties props=new Properties();  
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");  
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"third_app");  
		
		KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(props);  

		consumer.subscribe(Arrays.asList("nitone"));  

		while(true) {  
			ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));  
			for(ConsumerRecord<String,String> record: records){  
				System.out.println(" Data is :" +record.value());  
			}  
		}  
	}  
}
