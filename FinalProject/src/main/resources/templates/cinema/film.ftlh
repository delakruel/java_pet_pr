<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Фильм номер ${film.id}</title>
</head>
<body>
<form method="post" action="/cinema/film/${film.id}/update">
    <label>
        Название: <input name="Name" value="${film.name}">
    </label>
    <label>
        Год выпуска: <input name="Year" value="#{film.year}">
    </label>
    <label>
        Жанр фильма: <input name="Genre" value="${film.genre}">
    </label>
    <label>
        Возрастной рейтинг: <input name="Rating" value="#{film.rating}">
    </label>
    <input type="submit" value="Сохранить..">
</form>

</body>
</html>