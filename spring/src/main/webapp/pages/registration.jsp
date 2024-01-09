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
    <label path="password">Password</label>
    <input path="password"/>
    <errors path="password"/>
    <div>
        <label path="email">Email</label>
        <input path="email"/>
        <errors path="email"/>
    </div>
    <input type="submit">
</form>
</html>
