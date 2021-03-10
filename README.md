# notetask
Simple app for managing your notes for polS




EXAMPLE USAGES 

for getting one: curl -v http://localhost:8080/note/{id}
for getting list: curl -v http://localhost:8080/note/list
for getting history: curl -v http://localhost:8080/note/history/{id}
for adding: curl -d 'title=title1&content=content1' http://localhost:8080/note/add
for editing: curl -X PUT -d title=title2 -d content=content2 localhost:8080/note/edit/{id}
for deleting: curl -X DELETE http://localhost:8080/note/delete/{id}
