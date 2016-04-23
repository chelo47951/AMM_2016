<%-- 
    Document   : cliente
    Created on : 23-apr-2016, 21.15.29
    Author     : fab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Robofigures - Cliente</title>
        
        <meta charset="UTF-8">       
        <meta name="keywords" content="Robofigures, robot, action figures, anime, serie tv, film, cartoni giapponesi">
        <meta name="description" content="Robofigures - Pagina Cliente">
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
            <h2>Pagina Cliente</h2>
            
           <table id="articoli">
                <tr>
                    <th id="h-art">Articolo</th>
                    <th id="h-img">Foto</th>                
                    <th id="h-num">Pezzi disponibili</th>
                    <th id="h-price">Prezzo</th>
                    <th id="h-shop">Aggiungi al Carrello</th>
                </tr>
                
                <tr>
                    <td>Star Trek: Captain Kirk</td>
                    <td><img src="../img/kirk.jpg" alt="Captain Kirk"></td>
                    <td>2</td>
                    <td>299€</td>
                    <td><a href="cliente.html"><img src="../img/icona-carrello.png" alt="carrello"></a></td>
                </tr>
                
                <tr>
                    <td>The Crow: Eric Draven</td>
                    <td><img src="../img/theCrow.jpg" alt="Eric Draven"></td>
                    <td>4</td>
                    <td>235€</td>
                    <td><a href="cliente.html"><img src="../img/icona-carrello.png" alt="carrello"></a></td>
                </tr>
                
                 <tr>
                    <td>Devilman anime version</td>
                    <td><img src="../img/devilman.jpg" alt="Devilman anime version" ></td>
                    <td>2</td>
                    <td>85€</td>
                    <td><a href="cliente.html"><img src="../img/icona-carrello.png" alt="carrello" ></a></td>
                </tr>
                
                <tr>
                    <td>Jeeg</td>
                    <td><img src="../img/jeeg.jpg" alt="Jeeg"></td>
                    <td>5</td>
                    <td>155€</td>
                    <td><a href="cliente.html"><img src="../img/icona-carrello.png" alt="carrello" ></a></td>
                </tr>
                
                 <tr>
                    <td>Goldrake</td>
                    <td><img src="../img/goldrake.jpg" alt="Goldrake" ></td>
                    <td>8</td>
                    <td>145€</td>
                    <td><a href="cliente.html"><img src="../img/icona-carrello.png" alt="carrello"></a></td>
                </tr>
                
                 <tr>
                    <td>Nausicaa della valle del vento - dvd</td>
                    <td><img src="../img/Nausicaa-dvd.png" alt="Nausicaa"></td>
                    <td>11</td>
                    <td>35€</td>
                    <td><a href="cliente.html"><img src="../img/icona-carrello.png" alt="carrello"></a></td>
                </tr>
                
                
              
             
        </table>
            
        </section>
      
        <footer>           
           <p>
               Contacts: <a href="mailto:chelo.fabrizio@tiscali.it"> chelo.fabrizio@tiscali.it</a>
           </p>
              <p>&copy;2016 AMM 2016 Project<p>
           
        </footer>   
        
    </body>
</html>
