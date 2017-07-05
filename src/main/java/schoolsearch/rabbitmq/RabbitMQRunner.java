package schoolsearch.rabbitmq;

import schoolsearch.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RabbitMQRunner {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQReceiver receiver;
    private final ConfigurableApplicationContext context;

    public RabbitMQRunner(RabbitMQReceiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {

        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    public void run(String message) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitConfig.queueName, message);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}