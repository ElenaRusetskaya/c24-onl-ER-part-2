<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/save-request" method="post">
    Name:
    <input type="text" name="name" /><br><br>
    Age:
    <input  type="number" name="age" /><br><br>
    Gender:
    <input type="radio" name="gender" value="Female" checked />Female
    <input type="radio" name="gender" value="Male" />Male<br><br>
    Education:
    <select name="education">
        <option>Average education</option>
        <option>Secondary special education</option>
        <option>Higher education</option>
    </select><br><br>
    <p>Submit button
        <input type="submit" name="accept" value="Accept" /></p>
    <p>Cancel button
        <input type="submit" name="cancel" value="Cancel" /></p>
</form>
<h1>${message}</h1>
</body>
</html>