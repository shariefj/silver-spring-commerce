<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

<style>
	h1 {text-align:center;}
	<%--p {text-align:center;}--%>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
	
</style>

	<title>Silver's Fashion Home</title>
</head>
<body>
<h1>
	 Silver's fashion
</h1>

<P>  The time on the server is ${serverTime}. </P>


<div class="topnav">

<c:forEach var="rootCategories" items="${rootCategories}">
	<c:url var="childCategories" value="/categories">
			<c:param name="categoryId" value="${rootCategories.categoryId}"/>
	</c:url>			
	  <a href="${childCategories}">${rootCategories.categoryName}</a>
	</c:forEach>  
</div>

Session Order : ${sessionCount}
Session Shipping  : ${sessionCount.shippingGroup}
Session Payment  : ${sessionCount.paymentGroup}
Session items  : ${sessionCount.items}


</body>
</html>
