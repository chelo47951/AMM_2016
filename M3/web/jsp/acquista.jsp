<%-- 
    Document   : acquisto
    Created on : 25-apr-2016, 14.00.21
    Author     : fab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    
              <c:when test="${UnavailableObjectMessage != null && !UnavailableObjectMessage.equals(\"\")}">
                   <div id="errorMessage">
                        <p>${UnavailableObjectMessage}<p>
                  </div>
                   <p>Torna alla tua<a href="cliente.html"> pagina</a></p>
              </c:when>
                
                <c:when test="${TransactionCommittedMessage != null && TransactionCommittedMessage!=\"\"}">
                   
                    <h3>${TransactionCommittedMessage}</h3>
                    
                     <table id="articoli">
                            <tr>
                                <th id="h-voce">Voce</th>
                                <th id="h-importo">Importo</th>             
                            </tr>
                
                        <tr>
                            <td>Saldo precedente</td>
                            
                            <td>+${PreviousBalance}€</td>
                        </tr>
                
                
                        <tr>
                            <td>Presente acquisto</td>
                            
                            <td>-${CurrentPurchase}€</td>
                        </tr>
                        
                        <tr>
                            <td><strong>Saldo</strong></td>
                            
                            <td>+${CurrentBalance}€</td>
                        </tr>
                        
                     </table>
                        
                        <p>Torna alla tua<a href="cliente.html"> pagina</a></p>
                    
                    
               </c:when> 
                    
                     <c:when test="${TransactionRolledBackMessage != null && TransactionRolledBackMessage!=\"\"}">
                   <div id="errorMessage">
                        <p>${TransactionRolledBackMessage}<p>
                  </div>
                    <p>Torna alla tua<a href="cliente.html"> pagina</a></p>
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
                            <input type="hidden" name="ObjectSaleId" value="${o.objectSaleId}">
                            <div class="form-row clearfix">
                              <input type="submit" name="Submit" value="Conferma acquisto">
                            </div>
                       </form>

           </div>
                            
       </c:otherwise>
     </c:choose>
            
        </section>
      
        <footer>
              <jsp:include page="footer.jsp" />      
        </footer>   
        
    </body>
</html>