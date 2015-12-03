<%--
Copyright (c) 2015 Maddie Chili and Lawrence Mullen
--%>
<%@include file="/includes/header.jsp" %> 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <body>
        <img src="images/belk-02.jpg" alt="Belk Library"/>
        <h1>Belk Library</h1>
        <div id="red">
            <a id="check" href="<c:url value ='library?action=checkout'/>"> Check out a book</a>
            <a id="manage" href="<c:url value ='library?action=display_user'/>"> Manage checked out books</a>
        </div>
    </body>
<%@include file="/includes/footer.jsp" %>
