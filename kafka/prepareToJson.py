import json

import psycopg2

toJson = b'{"event": "ProductView", "messageid": "6b1291ea-e50d-425b-9940-44c2aff089c1", \
    "userid": "user-78", "properties": {"productid": "product-173"}, "context": {"source": "desktop"}}'

print(toJson.decode('UTF-8'))

js = json.loads(toJson.decode('UTF-8'))
# print(js['properties']['productid'])

# commands to create table for data that coming from kafka streams
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
            context json
        );
        """
        ,
        """INSERT INTO productViews(event, messageid, userid, properties, context) VALUES \
                    ('%s', '%s', '%s', '{"productid":"%s"}', '{"source":"%s"}');""" % (js["event"], js["messageid"],
                                                                js["userid"], js["properties"]["productid"], js["context"]["source"])
)

try:
    # read the connection parameters

    # connect to the PostgreSQL server
    conn = psycopg2.connect(
        host="localhost",
        port="5432",
        database="data-db",
        user="postgres",
        password="123456")
    print("CONNECTED SUCCESSFULLY")
    cur = conn.cursor()
    # create table one by one
    for command in commands:
        cur.execute(command)
    # close communication with the PostgreSQL database server
    cur.close()
    # commit the changes
    conn.commit()
except (Exception, psycopg2.DatabaseError) as error:
    print(error)
finally:
    if conn is not None:
        conn.close()