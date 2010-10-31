<html>
    <head>
        <title>Track My Bucket List</title>
        
        <link rel="shortcut icon" href="/images/gaelyk-small-favicon.png" type="image/png">
        <link rel="icon" href="/images/gaelyk-small-favicon.png" type="image/png">
        
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    </head>
    <body>
        <div>
            <h1>Track My Bucket List</h1>          
        </div>
        <% def userService = users

           if(userService.isUserLoggedIn()) { %>
               Hello, ${userService.currentUser.email} | <a href="${userService.createLogoutURL("/")}">Sign Out</a>
           <% } else { %>
               <a href="${userService.createLoginURL("/user/goals")}">Login</a>
           <% } %>
        <div>
