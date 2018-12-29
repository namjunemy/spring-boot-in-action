<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body onload="document.f.username.focus();">
<div id="loginForm">
    <h3>Login With Username and Password</h3>
    <#--<#if param.error??>-->
        <#--<div class="error">-->
            <#--Incorrect username or password. Try again-->
        <#--</div>-->
    <#--</#if>-->

    <form name="f" action="/login" method="POST">
        <table>
            <tr>
                <td>User:</td>
                <td><input type="text" name="username" value=""/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="submit" value="Login"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>