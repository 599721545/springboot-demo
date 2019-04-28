<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>修改页面</title>
</head>
<body>
<center>
    <h2>修改用户</h2>
    <form action="user/update" method="post">
        <input type="hidden" name="userId" value="${userId}"/>
        用户名：<input type="text" name="userName" value="${userName}"/><br/>
        年龄   ：<input type="text" name="userAge" value="${userAge}"/><br/>
        性别   ：<input type="text" name="userSex" value="${userSex}"/><br/><br/>
        <input type="submit" value="修改"/>
    </form>
</center>
</body>
</html>