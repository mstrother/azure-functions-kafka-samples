package com.function;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class Function {
    /**
    * This function consume KafkaEvents on the confluent cloud. Create a local.settings.json or configure AppSettings for configuring
     * BrokerList and UserName, and Password. The value wrapped with `%` will be replaced with enviornment variables. 
     * For more details, refer https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-expressions-patterns#binding-expressions---app-settings
     * The function is a sample of consuming kafkaEvent.
     * @param kafkaEventData
     * @param context
     */
    @FunctionName("KafkaTrigger")
    public void runSingle(
            @KafkaTrigger(
                name = "KafkaTrigger",
                topic = "poc",  
                brokerList="pkc-4rn2p.canadacentral.azure.confluent.cloud:9092",
                consumerGroup="$Default", 
                username = "WOV76HBEX3YUNPHV", 
                password = "oPbYPd5xVQjGx7eUQ1ovZ+dRsv0lJ0z24eNqAHjEGHlrk4SKxEyjrjKnch4EAdVt",
                authenticationMode = BrokerAuthenticationMode.PLAIN,
                protocol = BrokerProtocol.SASLSSL,
                dataType = "string"
             ) String kafkaEventData,
            final ExecutionContext context) {
            context.getLogger().info(kafkaEventData);
    }
}
