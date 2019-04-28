<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>列表页面</title>
    <style>
        body{
            text-align:center;
        }
        p{
            font-size:24px;
            background-color:#ccc;
            text-align:center;
        }
        tr{
            width:400px;
            height:70px;
        }
        td{
            width:100px;
        }
    </style>
</head>
<body>
<center>
    <table border="1" cellspacing="0" cellpadding="0">
        <caption><h2>用户列表</h11></caption>
        <tr>
            <th width="200px;">操作</th>
            <th>用户ID</th>
            <th>用户名</th>
            <th>年龄</th>
            <th>性别</th>
        </tr>
			<#list userList as item>
				<tr align="center">
                    <td>
                        <a href="/users/findById?userId=${item.userId}">查看</a>
                        <a href="/users/toUpdate?userId=${item.userId}&userName=${item.userName}&userAge=${item.userAge}&userSex=${item.userSex}">修改</a>
                        <a href="/users/delete?userId=${item.userId}">删除</a>
                    </td>
                    <td>${item.userId}</td>
                    <td>${item.userName}</td>
                    <td>${item.userAge}</td>
                    <td>${item.userSex}</td>
                </tr>
            </#list>
    </table>
</center>
</body>
</html>