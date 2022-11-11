Запуск приложения:
    docker-compose up --build -d

Тестовый запрос:
    curl --location --request POST 'http://0.0.0.0:80/core-api/logs' \
    --header 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:107.0) Gecko/20100101 Firefox/107.0' \
    --header 'Accept: application/json, text/plain, */*' \
    --header 'Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3' \
    --header 'Accept-Encoding: gzip, deflate' \
    --header 'Content-Type: application/json;charset=utf-8' \
    --data-raw '{
        "message": "test",
        "type": "APPLICATION",
        "level": "INFO",
        "timestamp": 2668034685000
    }'

Хелсчек:
    GET /core-api/actuator/health

Сваггер:
    GET /core-api/swagger-ui/index.html