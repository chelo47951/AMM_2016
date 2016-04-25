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
        <h1>
             <img src="img/logo.png" alt="Logo Robofigures">             
        </h1>
            
                 
         <nav>
             <div id="main-menu">
                <ul>                   
                    <li><a href="descrizione.html">Descrizione</a></li>              
                    <li><a href="cliente.html">Cliente</a></li>
                    <li><a href="venditore.html">Venditore</a></li>
                    
                </ul>
            </div>
        </nav>
        
        </header>
        
        
        
        
        <section>
            <h2>Pagina Login</h2>
            
         <c:if test="${errorMessage != null}">
             <div id="errorMessage">
                 <p>${errorMessage}<p>
             </div>
        </c:if>   
            
         <div id="main-form">
            <form method="get">
                <div class="form-row">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
                </div>
                <div class="form-row">
                <label for="pwd">Password:</label>
                <input type="password" id="pwd" name="pwd">
                </div>
                <div class="form-row">
                <input type="submit" name="Submit" value="Accedi">
                </div>

            </form>
             
         </div>
            
        </section>
       
        <footer>           
           <p>
               Contacts: <a href="mailto:chelo.fabrizio@tiscali.it"> chelo.fabrizio@tiscali.it</a>
           </p>
              <p>&copy;2016 AMM 2016 Project<p>
           
        </footer>    
        
    </body>
</html>

