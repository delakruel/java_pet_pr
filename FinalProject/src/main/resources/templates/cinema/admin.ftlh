<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Список пользователей</title>
</head>
<body>
<h2>Список Пользователей:</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>День рождения</th>
        <th>E-mail</th>
        <th>Детский контроль</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthDate.getDayOfMonth()} ${user.birthDate.getMonth()} #{user.birthDate.getYear()}</td>
            <td>${user.getEMail()}</td>
            <td>#{user.childFilter}+</td>
            <td>
                <form method="post" action="/cinema/user/${user.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>
<form method="post" action="/cinema/addUser">
    <label>Имя:
        <input name="FirstName" placeholder="Имя">
    </label>
    <label>Фамилия:
        <input name="LastName" placeholder="Фамилия">
    </label>
    <label>e-Mail:
        <input name="eMail" placeholder="e-Mail">
    </label>
    <label>Дата рождения:
        <input type="datetime-local" name="BirthDate" placeholder="Дата рождения">
    </label>
    <input type="submit" value="Добавить пользователя">
</form>
<h2>Список всех фильмов:</h2>
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
            <td>
                <form method="post" action="/cinema/film/${film.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <form method="get" action="/cinema/film/${film.id}">
                    <input type="submit" value="Изменить информацию">
                </form>
            </td>
        </tr>
    </#list>
</table>
<form method="post" action="/cinema/addFilm">
    <label>Название:
        <input name="Name" placeholder="Название">
    </label>
    <label>Год выпуска:
        <input name="Year" placeholder="Год выпуска">
    </label>
    <label>Жанр:
        <input name="Genre" placeholder="Жанр">
    </label>
    <label>Возрастной рейтинг:
        <input name="Rating" placeholder="Возрастной рейтинг">
    </label>
    <input type="submit" value="Добавить фильм">
</form>

</body>
</html>