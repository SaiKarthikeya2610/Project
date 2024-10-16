<%@ page import="com.fod.model.User" %>
<div class="header">
    <h1>Welcome to Food App</h1>
    <%
    User user = (User) session.getAttribute("user");
    if (user != null) {
    %>
    <!-- Regular navigation links for logged-in users -->
    <a href="homeServlet">Home</a>
    <a href="cartServelet">Cart</a>
    <a href="about.jsp">About</a>
    <!-- Dropdown for Logged-in User -->
    <div class="dropdown">
        <a href="#" class="dropbtn">Welcome, <%=user.getuserName()%></a>
        <div class="dropdown-content">
            <a href="profileUpdate.jsp?userId=<%=user.getuserId()%>">Profile</a>
            <a href="orderHistoryServlet">Order History</a>
            <a href="logoutServlet">Logout</a>
        </div>
    </div>
    <% 
    } else { 
    %>
    <!-- Links for non-logged-in users -->
    <a href="homeServlet">Home</a>
    <a href="about.jsp">About</a>
    <a href="login.jsp">Sign In</a> 
    <a href="register.jsp">Sign Up</a>
    <% 
    } 
    %>
</div>
<<style>
/* General styling for the header */
.header {
    background-color: rgba(0, 0, 0, 0.8);
    color: white;
    padding: 20px;
    text-align: center;
   
    width: 100%;
    top: 0;
    left: 0;
    z-index: 1000;
}

/* Styling for links inside the header */
.header a {
    color: white;
    margin: 0 20px;
    text-decoration: none;
    font-weight: bold;
    font-size: 18px;
}

/* Hover effect for links */
.header a:hover {
    text-decoration: underline;
}

/* Dropdown container */
.dropdown {
    display: inline-block;
    position: relative;
}

/* Styling the dropdown button */
.dropdown .dropbtn {
    background-color: transparent;
    border: none;
    color: white;
    font-size: 18px;
    cursor: pointer;
    margin: 0 20px;
}

/* Dropdown content (hidden by default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: white;
    min-width: 160px;
    box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

/* Hover effect for dropdown links */
.dropdown-content a:hover {
    background-color: #f1f1f1;
}

/* Show the dropdown when hovering over the dropdown button */
.dropdown:hover .dropdown-content {
    display: block;
}

/* Additional hover effect for the dropdown button */
.dropdown:hover .dropbtn {
    text-decoration: underline;
}

</style>
