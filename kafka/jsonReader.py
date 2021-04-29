import json

file1 = open('product-views.json', 'r')
Lines = file1.readlines()

for line in Lines:
    js = json.loads(line)
    print(js["event"])
