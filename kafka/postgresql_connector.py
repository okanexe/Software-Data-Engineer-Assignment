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
    cur.execute("SELECT * FROM orders")
except :
    conn.rollback()
else:
    conn.commit()

db_version = cur.fetchall()
print(db_version)