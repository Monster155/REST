<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<ul>
    <li>Для получения пользователя используйте GET запрос: <b>${pageContext.request.getContextPath()}/user?name=<i>*имя
        пользователя*</i>&age=<i>*возраст пользователя*</i>&isVip=<i>*true или false*</i></b>
    </li>
    <li>Для получения всех пользователей используйте GET запрос <b>${pageContext.request.getContextPath()}/user?all</b>
    </li>
</ul>
<ul>
    <li>Для добавления пользователя используйте POST запрос: <b>${pageContext.request.getContextPath()}/user?name=<i>*имя
        пользователя*</i>&age=<i>*возраст пользователя*</i>&isVip=<i>*true или false*</i></b>
    </li>
</ul>
<ul>
    <li>Для обновления пользователя используйте PUT запрос: <b>${pageContext.request.getContextPath()}/user?name=<i>*имя
        пользователя*</i>&age=<i>*возраст пользователя*</i>&newVip=<i>*новое значение (true или false)*</i></b>
    </li>
</ul>
<ul>
    <li>Для удаления пользователя используйте DELETE запрос: <b>${pageContext.request.getContextPath()}/user?name=<i>*имя
        пользователя*</i>&age=<i>*возраст пользователя*</i></b>
    </li>
</ul>
</body>
</html>
