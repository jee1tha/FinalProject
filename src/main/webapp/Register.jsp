<link href="Home.css" rel="stylesheet" type="text/css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>InGrow</title>

<link href="home.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id=welcome1>
		<marquee>Welcome to InGrow. We wish you good luck !!</marquee>
	</div>
	<div id=welcome2>InGrow Job Application Management</div>
	</td>




	<div id=bodyleft>

		<div id=transparent>
			<h1>User Registration</h1>
		</div>
		<form method="Post" action="AddAdminConfirm.jsp">
			<table width="200" border="0" cellpadding="5">
				<tr>
					<td>Username</td>
					<td><input type='text' name='txtUsername'
						placeholder="enter  Username" id='txtUsername' required>
						</input></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type='password' name='txtPassword'
						placeholder="enter  Password" id='txtPassword' required>
						</input></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type='confirmPassword' name='txtConfirmPassword'
						placeholder="enter Password" id='txtPasswordConfirm' required>
						</input></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type='text' name='txtName' placeholder="enter Name"
						id='txtName' required> </input></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type='text' name='txtAddress'
						placeholder="enter Address" id='txtAddress' required> </input></td>
				</tr>
				<tr>
					<td>NICNo</td>
					<td><input type='text' name='txtNICNo'
						placeholder="enter NICNo" id='txtNICNo' required> </input></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type='text' name='txtEmail'
						placeholder="enter Email" id='txtEmail' required> </input></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type='number' name='txtContactNo'
						placeholder="enter ContactNo" id='txtContactNo' required>
						</input></td>
				</tr>
			</table>

			<input type='submit' class="btn" value="Submit" id="btnLogin">
			</input> <a href="index.jsp" class="btn">Cancel </a> </input>
		</form>
	</div>

	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">
     $(function () {
         $("#btnLogin").click(function () {
             var password = $("#txtPassword").val();
             var confirmPassword = $("#txtPasswordConfirm").val();
             if (password != confirmPassword) {
                 alert("Passwords do not match.");
                 return false;
             }
             return true;
         });
     });
 </script>



</body>
<footer> © Copyrights 2016 Project InGrow </footer>
</html>
