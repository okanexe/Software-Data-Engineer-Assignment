import datetime
import psycopg2

conn = psycopg2.connect(
    host="localhost",
    port="5432",
    database="data-db",
    user="postgres",
    password="123456")

cur = conn.cursor()

#cur.execute('SELECT version()')

try:
    cur.execute("INSERT INTO dates(date) VALUES(TIMESTAMP '%s')" % (datetime.datetime.now()))
    cur.close()
    conn.commit()
except :
    conn.rollback()
else:
    conn.commit()
