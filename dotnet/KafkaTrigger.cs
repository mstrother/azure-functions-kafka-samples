using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Kafka;
using Microsoft.Azure.WebJobs.Extensions.Storage;
using Microsoft.Extensions.Logging;

namespace Confluent
{
    public class KafkaTrigger 
    {
        [FunctionName("KafkaTrigger")]
        public static void Run(
            [KafkaTrigger("pkc-4rn2p.canadacentral.azure.confluent.cloud:9092",
                          "poc",
                          Username = "WOV76HBEX3YUNPHV",
                          Password = "oPbYPd5xVQjGx7eUQ1ovZ+dRsv0lJ0z24eNqAHjEGHlrk4SKxEyjrjKnch4EAdVt",
                          Protocol = BrokerProtocol.SaslSsl,
                          AuthenticationMode = BrokerAuthenticationMode.Plain,
                          ConsumerGroup = "$Default")] KafkaEventData<string> kevent, ILogger log)
        {            
            log.LogInformation($"C# Kafka trigger function processed a message: {kevent.Value}");
        }
    }
}