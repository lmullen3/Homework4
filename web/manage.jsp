<%--
Copyright (c) 2015 Maddie Chili and Lawrence Mullen
--%>
<%@include file="/includes/header.jsp" %> 
    <body>
        <img src="images/belk-02.jpg" alt="Belk Library"/>
        <h1>Belk Library</h1>
        <div id="red">
            <h2>Currently checked out books</h2>
            <table>
                <thead>
                 <tr>
                    <th id="first">Patron Name</th>
                    <th>Email Address</th>
                    <th>Book Title</th>
                    <th>Due Date</th>
                    <th>Overdue</th>
                    <th></th>
                 </tr>
                </thead>
                
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="user" items="${users}">
  <tr>
    <td>${user.firstName}  ${user.lastName}</td>
    <td>${user.email}</td>
    <td>${user.title}</td>
    <td>${user.dueDate}</td>
    <td>${user.overdue}</td>
    <td><form action="servlet" method="post">
            <input type="hidden" name="action" value="delete" >
            <input type ="hidden" name="title" value="${user.title}">
            <input type="submit" value="Check In">
        </form>
    </td>
  </tr>
  </c:forEach>
            </table>
     
           <a id="return" href="home.jsp">Return to front page</a>
        </div>  
    </body>
<%@include file="/includes/footer.jsp" %>
