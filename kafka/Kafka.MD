Kafka 
- Message Broker 

Key concepts and Terminology:
- Events: something happened in the world or in your business
- Producers: đưa dữ liệu vào topic
- Consumers: đọc dữ liệu từ kafka
- Brokers:  lưu trữ dữ liệu và phân phối chúng đến các consumer
- Topics:  topics are partitioned , meaning a topic is spread over a number of "buckets" located on different kafka brokers


```
    To make your data fault-tolerant and high-available  => every topic can be replicated.
```
