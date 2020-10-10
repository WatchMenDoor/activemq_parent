package com.bjsxt.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.bjsxt.pojo.Users;

/**
 * 消息服务监听器
 * @author Administrator
 *
 */
@Component(value="myListener")
public class MyMessageListener implements MessageListener{

	@Autowired
	private UserService userService;
	
	@Override
	public void onMessage(Message message) {
		//处理消息
		ObjectMessage objMessage = (ObjectMessage)message;
		Users user=null;
		try {
			user = (Users)objMessage.getObject();
			System.out.println(user);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userService.showUser(user);
	}
}
