<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователь номер ${user.id}</title>
</head>
<body>
<form method="post" action="/cinema/user/${user.id}/update">
    <label>
        Имя: <input name="FirstName" value="${user.firstName}">
    </label>
    <label>
        Фамилия: <input name="LastName" value="${user.lastName}">
    </label>
    <label>
        Дата рождения: <input type="datetime-local" name="BirthDate" value="${user.birthDate}">
    </label>
    <label>
        Детский режим: <input name="ChildFilter" value="#{user.childFilter}">
    </label>
    <label>
        e-Mail: <input type="email" name="eMail" value="${user.getEMail()}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
<h2>Список доступных для просмотра фильмов:</h2>
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
                <form method="post" action="/cinema/film/${film.id}/watchBy/${user.id}">
                    <input type="submit" value="Посмотреть">
                </form>
            </td>
        </tr>
    </#list>
</table>
<h2>Список просмотренных фильмов:</h2>
<table>
    <tr>
        <th>Фильм</th>
        <th>Год выпуска</th>
        <th>Жанр</th>
        <th>Дата последнего просмотра</th>
    </tr>
    <#list seenFilms as seenFilm>
        <tr>
            <td>${seenFilm.watched.name}</td>
            <td>#{seenFilm.watched.year}</td>
            <td>${seenFilm.watched.genre}</td>
            <td>#{seenFilm.watchDate.getDayOfMonth()} ${seenFilm.watchDate.getMonth()} #{seenFilm.watchDate.getHour()}:#{seenFilm.watchDate.getMinute()}:#{seenFilm.watchDate.getSecond()}</td>
        </tr>
    </#list>
</table>
</body>
</html>