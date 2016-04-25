<%-- 
    Document   : acquisto
    Created on : 25-apr-2016, 14.00.21
    Author     : fab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Robofigures - Riepilogo acquisto</title>
        
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
            <h2>Pagina Riepilogo acquisto</h2>
            
     <c:choose>            
                <c:when test="${IsCustomer == null || IsCustomer==false}">
                    <div id="errorMessage">
                        <p>Utente non autenticato o non autorizzato all'accesso dei contenuti della pagina<p>
                  </div>
               </c:when>

         <c:otherwise>      
 
                
              
                            <div>${o.name}</div>
                            <div><img src="${o.imgUrl}" alt="${o.description}"></div>                             
                            <div>${o.price}</div>
                            <div>${o.numOfItems}</div>>
                            <div><a href="cliente.html"><img src="${shopperImgUrl}" alt="carrello"></a> </div>
                        
             
         
              
             
         </table
           
       </c:otherwise>
     </c:choose>
            
        </section>
      
        <footer>           
           <p>
               Contacts: <a href="mailto:chelo.fabrizio@tiscali.it"> chelo.fabrizio@tiscali.it</a>
           </p>
              <p>&copy;2016 AMM 2016 Project<p>
           
        </footer>   
        
    </body>
</html>