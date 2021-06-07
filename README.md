# Concurrently Increasing Counter
# The task is to consistently increment a number in a database when parallel threads are racing to increment the number.
# Instructions
1.	Checkout the git repository in your local machine.
2.	Import the project in IDE as maven project
3.	Run maven update / clean.
4.	Update the database name, username and password in application.properties file.
5.	Create the table in database as ‘counter’ with two field id[bigint(20) as primary key] and counterValue[int(20)].
6.	Run the project as Springboot application.
7.	Run the test suite with the requests as [http://localhost:portNumber/setInitialValue/:id] and [http://localhost:portNumber/increaseCounterValue/:id].
8.	Check the results in database.
