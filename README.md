# notetask
Simple app for managing your notes for polS

To start with this application you need database mysql - here is the link for download: https://dev.mysql.com/downloads/installer/
after installing and choosing login and password you have to change it in application.properties for yours. 

Now you have to create DataBase with it, there are two options that u can choose from

1. open database console and type "CREATE DATABASE notedb CHARACTER SET UTF8mb4 COLLATE utf8mb4_0900_ai_ci;" (of course u can use different name but then u have to change it in application.properties file.
2. there is second option, u can make in manually through you development environment. 

So now u can start the program and table will create automaticly because i have used hibernate and Entity is creating its own table.

There are some ways for you to start the program:
(of coruse u need to have installed java fo
1. first one of course is your development environment like visual studio code or intellij or eclipse
2. you can also start program with maven only, first u have to download and install maven and later in the project folder and type in cmd line "mvn spring-boot:run"

For front end i was using vue so first u have to install node.js from here https://nodejs.org/en/download/ then instal vue cli on your computer using command "npm install vue" then enter folder 'frontend' with your command line and type "npm run serve", now u can access site with link "https://localhost:3000"


EXAMPLE USAGES with curl links without using front end
so first run: 

for adding: curl -d 'title=title1&content=content1' http://localhost:8080/note/add

now get added one:

for getting one: curl -v http://localhost:8080/note/1

it should show you the one with titlle1 and content1

now edit first one: 

for editing: curl -X PUT -d title=title2 -d content=content2 localhost:8080/note/edit/1

and get history for it: 

for getting history: curl -v http://localhost:8080/note/history/1

doesn't matter if u type history of id 1 or 2 because they have same history but u should get list of 2 objects

now add another object: 
for adding: curl -d 'title=title4&content=aaaaa' http://localhost:8080/note/add

and after getting list:

for getting list: curl -v http://localhost:8080/note/list

u should get 2 objects as well

okey now type 

for deleting: curl -X DELETE http://localhost:8080/note/delete/2

so 

for getting list: curl -v http://localhost:8080/note/list

should return only one object but in daatabase there should be still 3

