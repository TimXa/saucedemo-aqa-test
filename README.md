# saucedemo-aqa-test

[![java](https://img.shields.io/badge/java-17-2f6feb)](https://www.oracle.com/java/)
[![maven](https://img.shields.io/badge/maven-3.x-c71a36)](https://maven.apache.org/)
[![selenium](https://img.shields.io/badge/selenium-4.16.1-43b02a)](https://www.selenium.dev/)
[![junit5](https://img.shields.io/badge/junit-5.10.1-25a162)](https://junit.org/junit5/)
[![allure](https://img.shields.io/badge/allure-2.25.0-ff4d4f)](https://docs.qameta.io/allure/)

автотесты логина для https://www.saucedemo.com/. стек: java, selenium, junit 5, allure. паттерн: page object model.

## демо

место для гифки:

![demo](docs/demo.gif)

## быстрый старт

```
mvn test
```

## отчет allure

```
mvn allure:serve
```

результаты лежат в target/allure-results.

## сценарии авторизации

- успешный логин: standard_user / secret_sauce
- неверный пароль
- заблокированный пользователь: locked_out_user
- пустые поля
- performance_glitch_user с задержкой

## структура проекта

```
src
├─ main
│  └─ java
│     └─ org/example/pages
│        ├─ LoginPage.java
│        └─ InventoryPage.java
└─ test
   └─ java
      └─ base
         ├─ BaseTest.java
         └─ LoginTest.java
```

## требования

- java 17
- maven 3.x
- chrome

## заметки

- каждый тест независим
- запуск в chrome через selenium manager
