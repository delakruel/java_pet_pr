<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Онлайн-кинотеатр</title>
</head>
<body>
<h2>Доступные на сегодняшний момент фильмы:</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Год выпуска</th>
        <th>Жанр</th>
        <th>Возрастной рейтинг</th>
    </tr>
    <#list films as film>
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>#{film.year}</td>
            <td>${film.genre}</td>
            <td>${film.rating}+</td>
        </tr>
    </#list>
</table>
<h3>Зайти в аккаунт по ID пользователя</h3>
<form method="post" action="/cinema">
    <label>ID:
        <input name="userId" placeholder="Введите ID">
    </label>
    <input type="submit" value="Перейти">
</form>
</body>
</html>