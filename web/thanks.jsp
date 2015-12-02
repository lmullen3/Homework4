<%--
Copyright (c) 2015 Maddie Chili and Lawrence Mullen
--%>
<%@include file="/includes/header.jsp" %> 
    <body>
        <img src="images/belk-02.jpg" alt="Belk Library"/>
        <h1>Belk Library</h1>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div id="red">
            <p id="thanks">Thank you for your patronage of the Belk Library. You've successfully
                checkout out the book, ${requestScope.title}. Please note that this book is due back on ${requestScope.date}. A friendly email reminder will be sent to you if your book becomes overdue.</p>
            <a id="return" href="<c:url value ='servlet?action=goHome'/>"> Return to the front page</a>

        </div>
    </body>
<%@include file="/includes/footer.jsp" %>
