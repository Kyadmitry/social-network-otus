# Social Network OTUS

## Описание проекта
Social Network OTUS - это учебный проект, построенный на основе Spring Boot 3 и Java 17. Проект использует:

- **PostgreSQL** в качестве базы данных.
- **Liquibase** для управления миграциями базы данных.

## Требования

Для запуска проекта на локальной машине необходимо:

- **Git**
- **Docker** и **Docker Compose**

## Запуск проекта локально

1. Склонируйте репозиторий проекта:
   ```bash
   git clone git@github.com:Kyadmitry/social-network-otus.git
   ```

2. Запустите проект из корня проекта (ветка master) с использованием Docker Compose:
   ```bash
   docker-compose up --build
   ```

3. Откройте Swagger UI для просмотра API документации:
   [http://127.0.0.1:8080/swagger-ui/index.html](http://127.0.0.1:8080/swagger-ui/index.html)

## Дополнительно

- **Миграции**: Liquibase автоматически применяет все необходимые миграции базы данных при запуске контейнеров.
- **API**: Полная документация доступна через Swagger UI.
