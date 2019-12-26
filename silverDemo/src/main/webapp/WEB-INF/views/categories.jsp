<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<body>
	
		Categories ${categoryId}
			
			<c:forEach var="category" items="${categories}">
			 
				<c:forEach var="childCategory" items="${category.childCategories}">
				
					<c:url var="childCategories" value="/categories">
						<c:param name="categoryId" value="${childCategory.categoryId}"/>
					</c:url>	
					<ul>
						<li> <a href="${childCategories}"> <c:out value="${childCategory.categoryName}"></c:out> </a> </li>
					</ul>				
				</c:forEach>
				
			</c:forEach>  

	</body>
</html>