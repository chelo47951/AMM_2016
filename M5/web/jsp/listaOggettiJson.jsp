<%-- 
    Document   : listaOggettiJson
    Created on : 3-giu-2016, 13.12.24
    Author     : fab
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="o" items="${sellingItems}">
        <json:object>            
            <json:property name="objId" value="${o.objectSaleId}" />
            <json:property name="objName" value="${o.name}" />
            <json:property name="objUrl" value="${o.imgUrl}" />
            <json:property name="objDesc" value="${o.description}" />
            <json:property name="objNumOfItems" value="${o.numOfItems}" />
            <json:property name="objPrice" value="${o.price}" />                  
        </json:object>
    </c:forEach>
</json:array>