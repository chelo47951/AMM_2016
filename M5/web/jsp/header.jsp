<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   
 
        <h1>
             <img src="img/logo.png" alt="Logo Robofigures">
        </h1>
               <!-- Sezione di navigazione -->
        <nav>
            <!-- Navigazione del sito -->
            <div id="main-menu">
                <ul> 
                    
                    <c:forEach var="menuLi" items="${menuItems}">
                    <li><a href="${menuLi.href}">${menuLi.content}</a></li>
                    </c:forEach>                 
                </ul>
            </div>
            
                    
        </nav>
   