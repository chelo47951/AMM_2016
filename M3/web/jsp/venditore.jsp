<%-- 
    Document   : venditore
    Created on : 23-apr-2016, 21.15.14
    Author     : fab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Robofigures - Venditore</title>
        
        <meta charset="UTF-8">       
        <meta name="keywords" content="Robofigures, robot, action figures, anime, serie tv, film, cartoni giapponesi">
        <meta name="description" content="Robofigures - Pagina Venditore">
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
                    <li><a href="login.html">Login</a></li>
                </ul>
            </div>
        </nav>
            
            
            
        </header>
        

        
        <section>
            <h2>Pagina Venditore</h2>
          <div id="main-form">
            <form method="get">
                
             <div class="form-row clearfix">
                <label for="nomeArticolo">Nome Articolo:</label>
                <input type="text" id="nomeArticolo" name="nomeArticolo">
             </div>
            <div class="form-row clearfix">  
                <label for="imgurl">Url Immagine:</label>
                <input type="url" id="imgurl" name="imgurl">
                
             </div>
                
           <div class="form-row clearfix">
                <label for="descArticolo">Descrizione:</label>
                <textarea id="descArticolo" name="descArticolo" rows="5" cols="20">Inserire una descrizione</textarea>
                
           </div>
           <div class="form-row clearfix">
                <label for="prezzo">Prezzo:</label>
                <input type="number" min="0" id="prezzo" name="prezzo">
                
           </div>
                
           <div class="form-row clearfix">  
                <label for="numpezzi">Numero di pezzi:</label>
                <input type="number" min="1" id="numpezzi" name="numpezzi">
                
          </div>
                
           <div class="form-row clearfix">
                <input type="submit" value="Invia">
                
          </div>

            </form>
                 
           </div>
            
        </section>
       
       <footer> 
           <div class="footer-content">
           <p>
               Contacts: <a href="mailto:chelo.fabrizio@tiscali.it"> chelo.fabrizio@tiscali.it</a>
           </p>
              <p>&copy;2016 AMM 2016 Project<p>
           </div>
           
        </footer>   
        
    </body>
</html>

