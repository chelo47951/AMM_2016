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
                    
              <c:when test="${UnavailableObjectMessage != null && !UnavailableObjectMessage.equals("")}">
                   <div id="errorMessage">
                        <p>${UnavailableObjectMessage}<p>
                  </div>
              </c:when>

         <c:otherwise>      
 
                <!--  Un oggetto è diposnibile all'acquisto   -->
              
                <div><h2>${o.name}</h2></div>
                <div><h3>${o.description}</h3></div>
                 <div><img src="${o.imgUrl}" width="200" height="200" alt="${o.description}"></div>                             
                 <div>Prezzo: <strong>${o.price}€</strong></div>
                 <div>Pezzi disponibili: ${o.numOfItems}</div>
                                                 
                    <div id="main-form">
                        <form method="get" action="acquista.html">
                            <input type="hidden" name="CustomerId" value="${CustomerId}">
                            <input type="hidden" name="VendorId" value="${VendorId}">
                            <input type="hidden" name="ObjectId" value="${o.objectSaleId}">
                            <div class="form-row clearfix">
                              <input type="submit" value="Conferma acquisto">
                            </div>
                       </form>

           </div>
                            
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