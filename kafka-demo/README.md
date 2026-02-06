# Using Kafka with Spring boot

1. Kafka is running locally in port 9092
2. Producer(Order Service) creates messages for topic order.created(message content: {customer_id, amount, currency}) using POST "/service/order"
   ![alt text](image.png)
3. Consumer(Customer Service) consumes and print the messages
   ![alt text](image-1.png)