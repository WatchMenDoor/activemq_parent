package com.bjsxt.service.impl;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Auther: liuxw
 * @Date: 2020-10-10
 * @Description: com.bjsxt.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void addUser(final Users user) {
        //发送消息
        this.jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createObjectMessage(user);
                return message;
            }
        });
    }
}
