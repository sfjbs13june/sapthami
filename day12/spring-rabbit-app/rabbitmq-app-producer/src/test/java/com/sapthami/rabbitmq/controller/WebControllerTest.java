package com.sapthami.rabbitmq.controller;

import com.sapthami.rabbitmq.model.Employee;
import com.sapthami.rabbitmq.service.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class WebControllerTest {
  @InjectMocks
  WebController webController;

  @Mock
  RabbitMQSender rabbitMQSender;

  @Test
  public void producerTest() {

    doNothing().when(rabbitMQSender).send(any(Employee.class));
    String result=webController.producer("empname1","empid1");

  }
}
