package br.com.andre.mqtt.config;

import br.com.andre.mqtt.handlers.WeightMessageHandler;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

@Configuration
public class MqttConfiguration {

    @Bean
    public MqttPahoClientFactory mqttPahoClientFactory() {

        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] { "tcp://localhost:1883" });

        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    public IntegrationFlow mqttInbound(MqttPahoClientFactory clientFactory, WeightMessageHandler messageHandler) {

        return IntegrationFlows.from(
                new MqttPahoMessageDrivenChannelAdapter("mqtt_service", clientFactory, "pesagem"))
                    .handle(messageHandler)
                .get();
    }

}
