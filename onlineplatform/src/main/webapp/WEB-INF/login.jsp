<div>
<form action = "/login" method = "post">
<div>UserName: <input type = "text" name="userName" value=""></div>
<div>Password: &nbsp; <input type = "text" name="password" value=""></div>
<div>Submit: <input type = "submit" value="Login"></div>
<div>Submit: <input type = "button" value="Register" onclick="goToRegister()"></div>
</form>
</div>

<script type="text/javascript">
function goToRegister(){
	alert("going to register");
	window.location.href="/register"
}</script>"