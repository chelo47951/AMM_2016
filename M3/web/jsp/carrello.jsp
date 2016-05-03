<%-- 
    Document   : carrello
    Created on : 3-mag-2016, 20.43.40
    Author     : fab
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Robofigures - Gestione carrello</title>
        
        <meta charset="UTF-8">       
        <meta name="keywords" content="Robofigures, robot, action figures, anime, serie tv, film, cartoni giapponesi">
        <meta name="description" content="Robofigures - Pagina Cliente">
        <meta name="author" content="Chelo Fabrizio">
        
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
        <link rel="shortcut icon" href="img/favicon.png">
    </head>
    <body>
        <header>
          <jsp:include page="header.jsp" />   
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
             
                <table id="articoli">
                            <tr>
                                <th id="h-oggetto">Articolo</th>
                                <th id="h-importo">Importo</th>
                                 <th id="h-azione">Azione</th>  
                            </tr>
                  <c:forEach var="o" items="${cartItems}">
                        <tr>
                            <td>${o.name}</td>
                            
                            <td>${o.price}€</td>
                            
                            <td>
                                 <form  method="get" action="acquista.html">                          
                                     <input type="submit" name="Checkout" value="Checkout">                       
                                </form>
                            </td>
                        </tr>
                        
                        
                        
                  </c:forEach>

                        
                     </table>
             
                     <div id="main-form">                      
                        <form method="get" action="checkout.html">
                        <div class="form-row clearfix">                          
                              <input type="submit" name="TotCheckout" value="Checkout Totale">
                      </div>
                       </form>
                    </div>
                    
                      <div id="main-form">
                        <form method="get" action="svuota.html"> 
                          <div class="form-row clearfix">
                              <input type="submit" name="Svuota" value="Svuota Carrello">
                         </div>
                       </form>
                    </div>

             <br>
                        <p>Torna alla tua<a href="cliente.html"> pagina</a></p>
 
       </c:otherwise>
     </c:choose>
            
        </section>
      
        <footer>
              <jsp:include page="footer.jsp" />      
        </footer>   
        
    </body>
</html>