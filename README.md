# Hackathon 2022 Jump2Digital

Here is a project I have created with Spring following the instructions provided by Jump2Digital for the 2022 edition of Hackathon.

We were asked to create a DB with a list of objects located within a json file and then create a number of endpoints that would allow us to access the data in different ways, and that would provide some statistics.

In order to ensure we do this, we were given a series of four tasks.

## Task 1

For this task we were told to create the DB containing al the data provided to us with a json file. In order to achieve it, I have followed a series of steps.

First, I created the necessary Entity and Repository for the table Company, with all the required constructors and attributes to translate the data from the json file to the DB.

Then, I created a service where to set a method to save a list of objects into the DB.

Finally, I created a Command Line Runner method to feed the information from the json file into the DB.

## Task 2

For this task we were asked to create an endpoint that returns a list of all companies ordered by size.

I have created a native query in the repository and a method in the service that to get a list of all the companies in the DB in an descendant order according to their size. Then, I created the corresponding controller endpoint method in order to have access to this query. (/show_by_size)

## Task 3

Here we were told to create an endpoint that returns the same list as the previous task, but this time ordered by the year the companies were founded.

For this task I created a simple JPA query in the repository and its corresponding methods in the service and the controller in order to reach it. (/show_by_year)

## Task 4

In the last task we were asked to create endpoints to return a count of all companies grouped by either industry, year of foundation and size. 

In order to accomplish this last task I have created one controller endpoint that accepts three different parameters in order to reach three different queries that I have created in the repository. The url (/show_numbers) calls a service method with a switch case that returns a different query depending on the parameter introduced (which are: 'industry', 'year' and 'size').

Here is a postman collection showing all the entries to reach the endpoints:

~~~~
{
	"info": {
		"_postman_id": "cc78bd38-3482-483e-a993-b6463296180b",
		"name": "hackathon_challenge",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "23795458"
	},
	"item": [
		{
			"name": "show_by_size",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/show_by_size",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"show_by_size"
					]
				}
			},
			"response": []
		},
		{
			"name": "show_by_year",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/show_by_year",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"show_by_year"
					]
				}
			},
			"response": []
		},
		{
			"name": "show_numbers_industry",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/show_numbers?param=industry",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"show_numbers"
					],
					"query": [
						{
							"key": "param",
							"value": "industry"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "show_numbers_size",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/show_numbers?param=size",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"show_numbers"
					],
					"query": [
						{
							"key": "param",
							"value": "size"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "show_numbers_year",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/show_numbers?param=year",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"show_numbers"
					],
					"query": [
						{
							"key": "param",
							"value": "year"
						}
					]
				}
			},
			"response": []
		}
	]
}
~~~~
