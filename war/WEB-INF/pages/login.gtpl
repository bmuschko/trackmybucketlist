<% include '/WEB-INF/includes/header.gtpl' %>

<h2>Login</h2>

<form action="/" method="POST">
   <table border="0">
      <tbody>
         <tr>
            <td>Username:</td>
            <td><input type="text" name="username"></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type="text" name="password"></td>
         </tr>
      </tbody>
   </table>
   <br>
   <input type="submit" value="Login">
</form>

<% include '/WEB-INF/includes/footer.gtpl' %>