# XMLProject
Представляю прекраснейшую инструкцию по настройке проекта XMLProject, суть проекта заключается в импортировании данных из XML файла в Базу Данных
<h2> Инструкция </h2>
<h3> Настройка AppConfig </h3>
Все переменные для настройки проекта находятся в классе AppConfig
<ul>
 <li>DATA_BASE_USER - имя пользователя для подключения к БД</li>
 <li>DATA_BASE_PASSWORD - пароль для подключения к БД</li>
 <li>DATA_BASE_SERVER - URL сервера </li>
 <li>DATA_BASE_CONNECTION - строка подключения к БД </li>
 <li>XML_PATH - путь к XML файлу </li>
</ul>
<h3> Настройка Базы данных </h3>
Для того, чтобы БД смогла принять записи из XML файла необходимо создать талблицу в БД при помощи SQL заброса

CREATE TABLE `user_table` (
  `id` int,
  `first_name` varchar(45),
  `last_name` varchar(45),
  `description` varchar(150)
)

<h3> Формат XML файла </h3>
Формат xml файла имеет следующую структуру

```xml
<UserTable>
    <User>
      <Id>1</Id>
      <FirstName>Иван: 1</FirstName>
      <LastName>Иванович: 1</LastName>
      <Description>Настоящий Иван: 1</Description>
    </User>
    <User>
    ...
    </User>
</UserTable>
```
