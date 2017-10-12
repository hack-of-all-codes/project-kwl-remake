package com.kwler.legacy.scheduler;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
/**
 * for reference, due to lack of documentation
 * https://github.com/spring-cloud/spring-cloud-aws/blob/master/spring-cloud-aws-messaging/src/main/java/org/springframework/cloud/aws/messaging/config/annotation/SqsConfiguration.java
 */
@EnableSqs
public class LegacySchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegacySchedulerApplication.class, args);
    }

    @Bean
    QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSqs) {
        return new QueueMessagingTemplate(amazonSqs);
    }
}
