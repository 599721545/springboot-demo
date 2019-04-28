<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>新增页面</title>
</head>
<body>
<center>
    <h2>新增用户</h2>
    <form action="/users/create" method="post">
        用户名：<input type="text" name="userName" value=""/><br/>
        年龄   ：<input type="text" name="userAge" value=""/><br/>
        性别   ：<input type="text" name="userSex" value=""/><br/><br/>
        <input type="submit" value="新增"/>
    </form>
</center>
</body>
</html>