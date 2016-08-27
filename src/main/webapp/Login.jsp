
<!DOCTYPE html>
<html>
<head>
<link href="home.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

</head>

<body>
	<div id=welcome1>
		<marquee>Welcome to InGrow. We wish you good luck !!</marquee>
	</div>
	<div id=welcome2>InGrow</div>
	</td>


	<div id=bodymid>


		<form method="Post" action="CheckAdminLogin.jsp">
			<div id=transparent>
				<h1>Login</h1>
			</div>
			<p>
				Username : <input type='text' name='txtName'
					placeholder="enter Username" id='txtName' required> </input> <br>
				<br> Password : <input type='password' name='txtPassword'
					placeholder="enter  Password" id='txtPassword' required> </input>
			</p>
			<p>
				<br> <input type='submit' class="btn" value="Login"
					id="btnLogin"> </input> <a href="Home.jsp" class="btn">Cancel </a>
				</input>

			</p>
		</form>



	</div>



	<footer> © Copyrights 2016 InGrow </footer>
</body>
</html>
