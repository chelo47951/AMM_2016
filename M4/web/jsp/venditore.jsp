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
            <jsp:include page="header.jsp" />  
        </header>
        

        
        <section>
            <h2>Pagina Venditore</h2>
          <c:choose>            
                <c:when test="${IsVendor == null || IsVendor==false}">
                    <div id="errorMessage">
                        <p>Utente non autenticato o non autorizzato all'accesso dei contenuti della pagina<p>
                  </div>
               </c:when>

               <c:otherwise> 

                 <div id="main-form">
                   <form method="get" action="venditore.html">
                  
                  <div class="form-row clearfix">
                       <input type="submit" name="NewObject" value="Aggiungi Nuovo Oggetto">

                 </div>
                   </form>
                 </div>
                   
                   <h3>Oggetti attualmente in vendita:</h3>     
          <table id="articoli">
                <tr>
                    <th id="h-art">Articolo</th>
                    <th id="h-img">Foto</th>                
                    <th id="h-num">Pezzi disponibili</th>
                    <th id="h-price">Prezzo</th>
                    <th id="h-action">Azione</th>
                </tr>
                
                
                <c:forEach var="o" items="${sellingItems}">
                  <c:choose>
                    <c:when test="${o.numOfItems > 0}">
                        <tr>
                            <td>${o.name}</td>
                            <td><img src="${o.imgUrl}" alt="${o.description}"></td>
                            <td>${o.numOfItems}</td>
                            <td>${o.price}€</td>
                            <td> 
                             
                                <a href="venditore.html?AddItem=Aggiungi&objectSaleId=${o.objectSaleId}"><img src="img/add-icon-small.png" alt="Aggiungi pezzo"></a>
                                <a href="venditore.html?Update=Modifica&objectSaleId=${o.objectSaleId}"><img src="img/modify-icon-small.png" alt="Modifica"></a>
                                <a href="venditore.html?Remove=Rimuovi&objectSaleId=${o.objectSaleId}"><img src="img/remove-icon-small.png" alt="Rimuovi"></a>                  
                                                      
                            </td>
                        </tr>
                  </c:when>
                  <c:otherwise>
                      <div class="removed">
                      <tr>
                            <td>${o.name}</td>
                            <td><img src="${o.imgUrl}" alt="${o.description}"></td>
                            <td>${o.numOfItems}</td>
                            <td>${o.price}€</td>
                            <td> 
                                <a href="venditore.html?AddItem=Aggiungi&objectSaleId=${o.objectSaleId}"><img src="img/add-icon-small.png" alt="Aggiungi pezzo"></a>
                                <a href="venditore.html?Update=Modifica&objectSaleId=${o.objectSaleId}"><img src="img/modify-icon-small.png" alt="Modifica"></a> 
                                <a href="venditore.html?Remove=Rimuovi&objectSaleId=${o.objectSaleId}"><img src="img/remove-icon-small.png" alt="Rimuovi"></a>                      
                                                      
                            </td>
                        </tr>
                      </div>
                  </c:otherwise>
                        
                </c:choose>
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

