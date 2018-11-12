package com.pfinfo.lesson.example.topic;

public class OnlineServiceImpl implements OnlineService {

	@Override
	public void terminalOnline(String id) {
		System.out.println("id="+id+" 的终端上线了");
	}

}
