<%-- 
    Document   : login.jsp
    Created on : 23-apr-2016, 19.52.24
    Author     : fab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Robofigures - Login</title>
        
        <meta charset="UTF-8">       
        <meta name="keywords" content="Robofigures, robot, action figures, anime, serie tv, film, cartoni giapponesi">
        <meta name="description" content="Robofigures - Pagina Login">
        <meta name="author" content="Chelo Fabrizio">
        
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
        <link rel="shortcut icon" href="img/favicon.png">
    </head>
    <body>
        <header>
         <jsp:include page="header.jsp" />
        </header>
        
        
        
        
        <section>
            <h2>Pagina Login</h2>
            
         <c:if test="${LoginErrorMessage != null}">
             <div id="errorMessage">
                 <p>${LoginErrorMessage}<p>
             </div>
        </c:if>   
            
         <div id="main-form">
            <form method="get"  action="login.html">
                <div class="form-row">
                <label for="Username">Username:</label>
                <input type="text" id="Username" name="Username">
                </div>
                <div class="form-row">
                <label for="Password">Password:</label>
                <input type="password" id="Password" name="Password">
                </div>
                <div class="form-row">
                <input type="submit" name="Submit" value="Accedi">
                </div>

            </form>
             
         </div>
            
        </section>
       
        <footer>           
             <jsp:include page="footer.jsp" />        
           
        </footer>    
        
    </body>
</html>

