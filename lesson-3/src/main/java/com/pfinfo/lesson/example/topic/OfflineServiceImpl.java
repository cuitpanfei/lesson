package com.pfinfo.lesson.example.topic;

public class OfflineServiceImpl implements OfflineService {

	@Override
	public void terminalOffline(String id) {
		System.out.println("id="+id+" 的终端下线了");
	}
}
