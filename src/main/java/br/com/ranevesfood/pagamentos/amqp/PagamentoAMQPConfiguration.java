package br.com.ranevesfood.pagamentos.amqp;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PagamentoAMQPConfiguration {
//	@Bean
//	Queue criaFila(){	
//		System.out.println("Criando fila.......");
//		//return new Queue ("pagamento.concluido", false);
//		return QueueBuilder.nonDurable("pagamento.concluido").build();
//    }
	
	@Bean
	RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
	        return new RabbitAdmin(conn);
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
	        return event -> rabbitAdmin.initialize();
	}
	
	//código omitido

	@Bean
    Jackson2JsonMessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter){
    	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    	rabbitTemplate.setMessageConverter(messageConverter);
    	return  rabbitTemplate;
    }
    
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("pagamentos.ex");
    }

}
