<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
${msg}
</body>
<body>
<form method="post" action="/hello">
    <input type="text" name="user" placeholder="User:"/><br/>
    <input type="text" name="password" placeholder="Password:"/><br/>
    <input type="email" name="email" placeholder="Email:"/><br/>
    <button type="submit"/>
</form>
</body>
</html>