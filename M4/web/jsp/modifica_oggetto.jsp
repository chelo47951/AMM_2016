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
            <h2>Modifica Oggetto</h2>
          <c:choose>            
                <c:when test="${IsVendor == null || IsVendor==false}">
                    <div id="errorMessage">
                        <p>Utente non autenticato o non autorizzato all'accesso dei contenuti della pagina<p>
                  </div>
               </c:when>

               <c:otherwise> 
                   
            <c:if test="${ObjectAdded != null}">
                <p>${ObjectAdded}</p>
              
            </c:if>
             
              
                    
             
                 <c:choose> 
                  <c:when test="${ObjectToUpdate == null}">      
                      
                     <p>Potete inserire un nuovo oggetto:</p>
                         
                    <div id="main-form">
                   <form method="get" action="venditore.html">
                 
                    <div class="form-row clearfix">
                       <label for="nomeArticolo">Nome Articolo:</label>
                       <input type="text" id="nomeArticolo" name="nomeArticolo">
                    </div>
                   
                     <div class="form-row clearfix">
                       <label for="categoria">Categoria:</label>
                       <input type="text" id="categoria" name="categoria">
                    </div>
                       
                   <div class="form-row clearfix">  
                       <label for="imgurl">Url Immagine:</label>
                       <input type="url" id="imgurl" name="imgurl">

                    </div>

                  <div class="form-row clearfix">
                       <label for="descArticolo">Descrizione:</label>
                       <textarea id="descArticolo" name="descArticolo" rows="5" cols="20" placeholder="Inserire una descrizione"></textarea>

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
                       <input type="submit" name="Submit" value="Invia">

                 </div>

                   </form>

                  </div>
                         
                   </c:when>
                         
                     <c:otherwise>
                        
                        <div id="main-form">
                          <form method="get" action="venditore.html">
                            
                           <input type="hidden" name="objectId" value="${ObjectToUpdate.objectSaleId}">
                           <div class="form-row clearfix">
                              <label for="nomeArticolo">Nome Articolo:</label>
                              <input type="text" id="nomeArticolo"  name="nomeArticolo" value="${ObjectToUpdate.name}">
                           </div>

                            <div class="form-row clearfix">
                              <label for="categoria">Categoria:</label>
                              <input type="text" id="categoria" name="categoria"  value="${ObjectToUpdate.category}">
                           </div>

                          <div class="form-row clearfix">  
                              <label for="imgurl">Url Immagine:</label>
                              <input type="url" id="imgurl" name="imgurl"  value="${ObjectToUpdate.imgUrl}">

                           </div>

                         <div class="form-row clearfix">
                              <label for="descArticolo">Descrizione:</label>
                              <textarea id="descArticolo" name="descArticolo" rows="5" cols="20" placeholder="Inserire una descrizione">${ObjectToUpdate.description}</textarea>

                         </div>
                         <div class="form-row clearfix">
                              <label for="prezzo">Prezzo:</label>
                              <input type="number" min="0" id="prezzo" name="prezzo" value="${ObjectToUpdate.price}" >

                         </div>

                         <div class="form-row clearfix">  
                              <label for="numpezzi">Numero di pezzi:</label>
                              <input type="number" min="1" id="numpezzi" name="numpezzi" value="${ObjectToUpdate.numOfItems}">

                        </div>

                         <div class="form-row clearfix">
                              <input type="submit" name="Submit" value="Invia">

                        </div>

                          </form>

                         </div>
                              
                       </c:otherwise>

                       
                       </c:choose>
                
                 </c:otherwise>
                
              </c:choose> 
            

            
        </section>
       
       <footer> 
              <jsp:include page="footer.jsp" />                   
        </footer>   
        
    </body>
</html>

