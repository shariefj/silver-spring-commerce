<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/megamenu.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<style>

</style>
<title> Silver's Fashion home </title>
</head>
<body>
<div class="">
	<h1>Silver's Fashion</h1>
</div>

<div class="navbar">

<c:forEach var="rootCategories" items="${rootCategories}">
	
<div class="dropdown">
    <button class="dropbtn">${rootCategories.categoryName} 
    </button>
   
    <div class="dropdown-content" id="${rootCategories.categoryId}">
   
   
      <div class="row">
        <div class="column">
        	<c:forEach var="childCategories" items="${rootCategories.childCategories}">
        	<c:url var="categoryLisgtingPage" value="/categories"> 
        		<c:param name="categoryId" value="${childCategories.categoryId}"></c:param>
        	</c:url>
		          <a href="${categoryLisgtingPage}">${childCategories.categoryName}</a>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
	
</c:forEach>

   
</div>

<div style="padding:16px">
  <h3>Responsive Mega Menu (Full-width dropdown in navbar)</h3>
  <p>Hover over the "Dropdown" link to see the mega menu.</p>
  <p>Resize the browser window to see the responsive effect.</p>
</div>

</body>
</html>
