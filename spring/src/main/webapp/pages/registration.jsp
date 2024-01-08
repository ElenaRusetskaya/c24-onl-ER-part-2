<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>registration</title>
</head>
<form action="/users/new" method="post" modelAttribute="user">
    <div>
        <label path="name">Name</label>
        <input path="name"/>
        <errors path="name"/>
    </div>
    <label path="surname">Surname</label>
    <input path="surname"/>
    <errors path="surname"/>
    <div>
        <label path="email">Email</label>
        <input path="email"/>
        <errors path="email"/>
    </div>
    <input type="submit">
</form>
</html>
