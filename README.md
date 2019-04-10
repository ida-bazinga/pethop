# pethop-test

Spring MVC 4 + MyBatis 3 + ExtJS 4 CRUD Grid Example

Приложение основано на Spring framework с использованием SpringMVC.
Объекты домена сериализуются и десериализуются с помощью Jackson JSON (ExtData и ExtResponse).
Соединение с БД управляется движком MyBatis с использованием XML-карт.
OneClickPurchaseController-это контроллер Spring MVC подключен к Ext.data.JsonStore.
Поле базы данных 'uid' автоматически увеличивается на основе последовательности.
sql-скрипты в папке 'resources/scripts' для инициализации данных в БД Postgresql.
