Руководство по сборке проекта

1 способ (с помощью докера):

docker pull stanislavskii/electronic-store:latest
docker run -p 8080:80 stanislavskii/electronic-store

Все апи и всю работу монжо посмотреть в сваггере
Переходим сюда
http://localhost:8080/swagger-ui/index.html
База данных тут:
http://localhost:8080/h2

2 способ (с помощью mvn):

Просто компилируем программу:
mvn clean package

Запускаем jar файл и все

Все апи и всю работу монжо посмотреть в сваггере
Переходим сюда
http://localhost/swagger-ui/index.html
База данных тут:
http://localhost/h2

3 способ (докер и mvn):

Компилируем программу:
mvn clean package 

Переходим в проект:
cd ~\cft-backend-test

Выпоняем команду:
docker-compose up
Важно, Dockerfile, docker-compose.yaml должны находиться в одной директории (~/cft-backend-test). Jar файл в ~/cft-backend-test/target/

Проще всего скомпилировать программу в средах разработки, например IntellIdea

Все апи и всю работу монжо посмотреть в сваггере
Переходим сюда
http://localhost:8080/swagger-ui/index.html
База данных тут:
http://localhost:8080/h2