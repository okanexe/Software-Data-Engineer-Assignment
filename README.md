                                                   Hepsiburada
                                               Recommendation Team
                                        Software/Data Engineer Assignment

<h2>Task Definition</h2>

You work in an e-commerce platform as a software engineer and your mission is to build batch and real-time data pipelines together with high-performance rest APIs to create a real-time recommendation engine. Your rest API will be the source of two recommendation lists on the main page:

<b>Browsing History</b>
You should return the last ten products viewed by a given user and sorted by view date.
GET endpoint, inputs: user-id
Sample response:
{
	"user-id": "fdsfsdfs",
	"products": ["a","b","c","d"."e"],
	"type" : "personalized"
}

You should also add a functionality for users which they can delete a product from their history.
DELETE endpoint, inputs: user-id, product-id

<b>Best Seller Products</b>
You should understand the interest of a user using his/her browsing history items and recommend best seller products to him/her only from the categories of these items. Otherwise, you should return a general best seller product list without any filter.
GET endpoint, inputs: user-id
Sample response
{
	"user-id": "fdsfsdfs",
	"products": ["a","b","c","d"."e"],
	"type" : "non-personalized"
}



<b>First Strategy Details (Personalized)</b>
Use the browsing history of the user.
Extract at most three categories from this history
Offer ten products based on these categories.
Bestsellers of a category means top ten products of this category bought (last month) by the most distinct users

<b>Second Strategy Details (Non-Personalized)</b>
If a user has no browsing history you should return a list as a second strategy
It gives the top ten products bought (last month) by the most distinct users without any filter.

<b>Notes:</b>
For any recommendation list, the minimum number of products to return is five. If there are fewer products than this number, API should return an empty list.
To satisfy the requirements of the task you should have product views file data source and a database tables containing product, order(containing orders of the last month) and order item information. The definition of files and tables are in technical details.
You should create

a clickstream product view producer application as described in technical details. (View Producer App)
a streaming app to read views from Kafka and integrate with API (Stream Reader App)
a batch category based and general best sellers flow and integrate with API (ETL Process)
a recommendation Rest API to provide given endpoints (API)



For write operations, you can use the PostgreSQL we provided to you or you can select a database of your preference that you think it will be useful for this case. You are free to edit docker-compose.yml file we provided to setup a custom database. In any case, don’t forget to send us custom database related operations(table/index/schema/mapping/etc. creation) and explanations.



<h2>Technical Details</h2>

<b>Environment</b>

docker-compose.yml file is provided for you. You do not have to use this environment but it simplifies the tool setup process of your environment. If you choose to use it, you need to install Docker and Docker Compose into your computer. Following commands will setup a Kafka, PostgreSQL and Zookeeper(which is required for Kafka to run. You won’t need to use this).

To setup databases, you should run following command:
docker-compose -f ./docker-compose.yml up -d

To tear down, you should run following command:
docker-compose -f ./docker-compose.yml down

Important Note: If you tear down docker containers after ingesting data, you will lose the data you ingested and you have to ingest data again.<br>

After setup is completed;<br>
You can access Kafka from port 9092 on your localhost<br>
You can access PostgreSQL from port 5432 on your localhost. Credentials are:<br>
Username: postgres<br>
Password: 123456<br>

<h2>Data</h2>
There are two data sources:
The PostgreSQL we provided to you, which contains data-db database with following tables:



The product-views.json we provided to you. The View Producer App will read this file and publish one event in a second to Kafka. The current timestamp should be added to product view event data. An example of a product view event is given below. See the file for details.

{<br>
  "event": "ProductView",<br>
  "messageid": "c002a71a-9750-4604-8d70-d5ff3f1c4495",<br>
  "userid": "user-120",<br>
  "properties": {<br>
    "productid": "product-393"<br>
  },<br>
  "context": {<br>
    "source": "mobile-app"<br>
  }<br>
}<br>


<b>Fields descriptions:</b>
event is the name of the event<br>
messageid is a unique guid id for the event<br>
userid is the member who viewed product<br>
properties.productid is the viewed product<br>
context.source is the platform of the event source<br>

<h2>Expected Outcomes</h2>
Documentation of your solution which contains the schema/block diagram of your solution and any other details.
Codes of any application (scripts, ETLs, streaming app, rest API, tests) developed for the given task.
Especially for API application, unit testing must be satisfied

<h2>Notes</h2>
You are free to choose any programming/scripting languages.<br>
You are free to choose and install any other tools/DBS into your environment. Please give details if used.<br>
Following criteria will be considered during the evaluation of the assignment:<br>
Satisfaction of requirements<br>
Architectural Decisions & Tool Choices<br>
Code Quality & Readability<br>
Testing, packaging and deployment. (Containerization)<br>
Package your codes and documents and send them to us.<br>

You have 7 days to fulfill the assignment. Please, do not hesitate to contact us in case of any questions or suggestions.
Good luck :)
