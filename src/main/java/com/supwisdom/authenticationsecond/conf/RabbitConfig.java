package com.supwisdom.authenticationsecond.conf;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class RabbitConfig {

	/**
	 * 同步RPC队列
	 */
	public static final String SIMPLE_MODEL = "simple-model";

	/**
	 * 异步RPC队列，使用临时回复队列，或者使用“Direct reply-to”特性
	 */
	public static final String WORK_MODEL = "work-model";

	/**
	 * 异步RPC队列，每个客户端使用不同的固定回复队列，需要额外提供correlationId以关联请求和响应
	 */
	public static final String QUEUE_ASYNC_RPC_WITH_FIXED_REPLY = "rpc.with.fixed.reply";

	@Bean
	public Queue simpleModelQueue() {
		return new Queue(SIMPLE_MODEL);
	}

	@Bean
	public Queue workModelQueue() {
		return new Queue(WORK_MODEL);
	}

	@Bean
	public Queue fixedReplyRPCQueue() {
		return new Queue(QUEUE_ASYNC_RPC_WITH_FIXED_REPLY);
	}

	@Bean
	public Queue repliesQueue() {
		return new AnonymousQueue();
	}

	@Bean
	@Primary
	public SimpleMessageListenerContainer replyContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueueNames(repliesQueue().getName());
		return container;
	}

	@Bean
	public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate template, SimpleMessageListenerContainer container) {
		return new AsyncRabbitTemplate(template, container);
	}

	@Bean
	public FanoutExchange fanoutExchange(){
		return new FanoutExchange("stu_fanoutExchange");
	}


	//声明两个队列，分别与上面声明的fanout交换机进行绑定
	@Bean
	public Queue queueA(){
		return new Queue("queueA");
	}

	@Bean
	public Queue queueB(){
		return new Queue("queueB");
	}

	//绑定queue6
	@Bean
	public Binding binding6(){
		return BindingBuilder.bind(queueA()).to(fanoutExchange());
	}

	//绑定queue7
	@Bean
	public Binding binding7(){
		return BindingBuilder.bind(queueB()).to(fanoutExchange());
	}


}
