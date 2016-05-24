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
          <jsp:include page="header.jsp" />
        </header>
        
     
        
        <section>
            <c:if test="${IsCustomer != null}">
                <div class="cart-box">
                    <p>User: <strong>${Username}</strong></p>
                    
                    <a href="carrello.html">
                    <img src="img/cart-small.png" alt="carrello-right" width="42px" height="42px">
                    </a>
                    
                    <c:if test="${Shopper.numOfItems > 0}">
                    <p class="text-in-circle-full">
                        ${Shopper.numOfItems}                   
                    </p>
                    </c:if>
                    
                    <c:if test="${Shopper.numOfItems == 0}">
                        <p class="text-in-circle-empty">
                            ${Shopper.numOfItems}                   
                        </p>
                        
                    </c:if>
                    
                </div>
            </c:if>
            <h2>Pagina Cliente</h2>
            
     <c:choose>            
                <c:when test="${IsCustomer == null || IsCustomer==false}">
                    <div id="errorMessage">
                        <p>Utente non autenticato o non autorizzato all'accesso dei contenuti della pagina<p>
                  </div>
               </c:when>

         <c:otherwise>      
           <table id="articoli">
                <tr>
                    <th id="h-art">Articolo</th>
                    <th id="h-img">Foto</th>                
                    <th id="h-num">Pezzi disponibili</th>
                    <th id="h-price">Prezzo</th>
                    <th id="h-shop">Aggiungi al Carrello</th>
                </tr>
                
                
                <c:forEach var="o" items="${sellingItems}">
                    <c:if test="${o.numOfItems > 0}">
                        <tr>
                            <td>${o.name}</td>
                            <td><img src="${o.imgUrl}" alt="${o.description}"></td>
                            <td>${o.numOfItems}</td>
                            <td>${o.price}€</td>
                            <td><a href="acquista.html?ObjectSaleId=${o.objectSaleId}"><img src="img/icona-carrello.png" alt="carrello"></a></td>
                        </tr>
                  </c:if>
                </c:forEach>
              
             
         </table>
           
       </c:otherwise>
     </c:choose>
            
        </section>
      
        <footer>           
            <jsp:include page="footer.jsp" />                   
        </footer>   
        
    </body>
</html>
