<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <style>
 body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0 auto;
  display: flex;  
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.login-container {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  padding: 20px;
  width: 300px;
  text-align: center;
}

h2 {
  color: #333;
}

form {
  display: flex;
  flex-direction: column;
}

label {
  margin-bottom: 6px;
  color: #666;
}

input {
  padding: 8px;
  margin-bottom: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
 
 
 </style>
	<div class="login-container">
    <h2>Register</h2>
    <form action="SigupController" method="post">
      <label for="fullname">Full Name:</label>
      <input type="text" id="fullname" name="fullname" required>
     <label for="phone">Phone Number:</label>
      <input type="text" id="phone" name="phone" required> <br>
      <label for="email">Email Login:</label>
      <input type="email" id="email" name="email" required> <br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required> <br>
	
		<br>
			
      <button type="submit" name="btnRegister" value="SignUp">Sign Up</button>
    	
    </form>
  </div>
</body>
</html>