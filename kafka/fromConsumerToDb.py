# Import KafkaConsumer from Kafka library
import json

import psycopg2
from kafka import KafkaConsumer
import datetime
# Import sys module
import sys

# Define server with port
bootstrap_servers = ['localhost:9092']

# Define topic name from where the message will recieve
topicName = 'kafka-1'

# Initialize consumer variable
consumer = KafkaConsumer (topicName, group_id ='group1',bootstrap_servers = bootstrap_servers)


commands = (
        """CREATE TYPE productid AS (productid VARCHAR(255));"""
        ,
        """CREATE TYPE source AS (source VARCHAR(255));"""
        ,
        """
        CREATE TABLE productViews (
            event VARCHAR(255),
            messageid VARCHAR(255),
            userid VARCHAR(255),
            properties json,
            context json,
            timestamp VARCHAR(255)
        );
        """
)

try:
    conn = psycopg2.connect(
        host="localhost",
        port="5432",
        database="data-db",
        user="postgres",
        password="123456")
    print("CONNECTED SUCCESSFULLY")
    cur = conn.cursor()

    for command in commands:
        cur.execute(command)


    for msg in consumer:
        print("Topic Name=%s,Message=%s" % (msg.topic, msg.value))
        js = json.loads(msg.value.decode('UTF-8'))
        cur = conn.cursor()

        cur.execute("""INSERT INTO productViews(event, messageid, userid, properties, context, timestamp) VALUES \
                                    ('%s', '%s', '%s', '{"productid":"%s"}', '{"source":"%s"}', '%s');""" % (
            js["event"], js["messageid"],
            js["userid"], js["properties"]["productid"], js["context"]["source"], datetime.datetime.now().strftime("%H:%M:%S.%f - %b %d %Y")))
        cur.close()
        conn.commit()

    cur.close()
    # commit the changes
    conn.commit()
except (Exception, psycopg2.DatabaseError) as error:
    print(error)
finally:
    if conn is not None:
        conn.close()

# Terminate the script
sys.exit()