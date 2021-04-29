# Import KafkaProducer from Kafka library
from kafka import KafkaProducer
import json
import time

file = open('product-views.json', 'r')
Lines = file.readlines()


# Define server with port
bootstrap_servers = ['localhost:9092']

# Define topic name where the message will publish
topicName = 'kafka-1'

# Initialize producer variable
producer = KafkaProducer(bootstrap_servers = bootstrap_servers)

for line in Lines:
    time.sleep(1)
    producer.send(topicName, bytes(line, encoding="ascii"))

# Publish text in defined topic
#producer.send(topicName, b'Hello from kafka')

# kafka send() is asynchronous.
# When called it adds the record to a buffer of pending record sends and immediately returns.
# This allows the producer to batch together individual records for efficiency.
# You can use flush()/poll() method to send the message immediately.
producer.flush()

# Print message
print("Message Sent")