<%--Copyright (c) 2015 Maddie Chili and Lawrence Mullen--%>
<%@include file="/includes/header.jsp" %> 
    <body>
        <img src="images/belk-02.jpg" alt="Belk Library"/>
        <h1>Belk Library</h1>
        <div id="red">
        <h2>Checkout a book</h2>
        <form id="checkout-form" action="servlet" name="checkout-form" method="post">
                    <input type="hidden" name="action" value="userInput">
                    <label for="first_name">First Name:</label>
                    <input type="text" id="first_name" name="first_name" required/>
                    <br>
                    <label for="last_name">Last Name:</label>
                    <input type="text" id="last_name" name="last_name" required/>
                    <br>
                    <label for="email">Email Address:</label>
                    <input type="email" id="email" name="email" required/>
                    <br>
                    <label for="title">Book Title:</label>
                    <input type="text" id="title" name="title" required/>
                    <br>
                    <input type="submit" id="checkout" name="button" value="Checkout"/>
                    
                </form>
        </div>
    </body>

<%@include file="/includes/footer.jsp" %>
