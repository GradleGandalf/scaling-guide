# RabbitMQ Spring Boot Demo

This module demonstrates a simple message flow:

```
HTTP API -> Spring Boot Producer -> RabbitMQ -> Spring Boot Consumer -> PostgreSQL
```

## Running Locally

1. Start RabbitMQ and PostgreSQL locally. The simplest approach is Docker:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

docker run -d --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=demo -p 5432:5432 postgres:16
```

2. Build and run the Spring Boot application:

```bash
cd rabbitmq-springboot-demo
gradle bootRun
```

3. Send messages to the API:

```bash
curl -X POST -d 'hello' http://localhost:8080/api/send
```

The consumer stores each payload in the `message_entity` table in PostgreSQL.

## Performance Demo

Use `wrk` or a similar tool to generate load. The following example sends requests at ~200 RPS for 30 seconds:

```bash
wrk -t4 -c100 -d30s -R200 --latency -s post.lua http://localhost:8080/api/send
```

where `post.lua` contains:

```lua
wrk.method = "POST"
wrk.body = "test"
wrk.headers["Content-Type"] = "text/plain"
```

Monitor RabbitMQ throughput via its management UI at <http://localhost:15672>. Under typical conditions a single instance easily handles 200 messages per second. Increase the number of consumers for higher throughput.

## Security Notes

- Use strong PostgreSQL credentials and restrict network access.
- Configure RabbitMQ with user accounts instead of the default `guest` user.
- For production use TLS (`amqps` and `jdbc:postgresql://` with SSL) and enable authentication/authorization.
