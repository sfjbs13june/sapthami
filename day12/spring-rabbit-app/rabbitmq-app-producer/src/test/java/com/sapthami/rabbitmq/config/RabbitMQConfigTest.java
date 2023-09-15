package com.sapthami.rabbitmq.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.test.context.ActiveProfiles;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class RabbitMQConfigTest {
	@InjectMocks
	RabbitMQConfig rabbitMQConfig;

	@Test
	public void rabbitTemplateTest() {
		ConnectionFactory connectionFactory= Mockito.mock(ConnectionFactory.class);
		MessageConverter messageConverter= Mockito.mock(MessageConverter.class);
		AmqpTemplate rabbitTemplate=rabbitMQConfig.rabbitTemplate(connectionFactory);
	}
}