package com.pfinfo.lesson.example.topic;

import java.util.function.Consumer;

public class TerminalOnlineOffline {

	OnlineService onlineService = new OnlineServiceImpl();
	
	OfflineService offlineService = new OfflineServiceImpl();
	
	@KafkaLisener(topics="${terminal.online}",containerFactory="kafkaAckFactory")
	public void online(CousumerRecord<?,?> record,Acknowledgment ack){
		termianlStatusChange(record,onlineService::terminalOnline);
		ack.acknowledge();
	} 
	
	@KafkaLisener(topics="${terminal.offline}",containerFactory="kafkaAckFactory")
	public void offline(CousumerRecord<?,?> record,Acknowledgment ack){
		termianlStatusChange(record,offlineService::terminalOffline);
		ack.acknowledge();
	}
	
	private void termianlStatusChange(CousumerRecord<?, ?> record, Consumer<String> consumer) {
		String jsonStr = record.value().toString();
		//打印接收到的入参
		System.out.println(jsonStr);
		
		//1. jsonStr to JSON
		//TODO jsonStr to JSON
		
		String id = "";
		//2. get id from JSON
		//TODO jsonStr to JSON
		boolean isourTerminal = false; 
		//TODO check id
		if(isourTerminal){
			//3. 消费
			consumer.accept(id);
		}
	}
	
}
