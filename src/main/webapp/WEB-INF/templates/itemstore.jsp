<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel='stylesheet' type='text/css' href='/styles/style.css' />
</head>


<body>
<h1 align = "center"> + title + </h1>
<ul>

    <table>

        <c:forEach items="${itemPool}" var="item">
            <tr><td><c:out value="${item.nameToString()}"/><br /></td><td><c:out value="${item.priceToString()}"/><br /></td><td>
                <form action="${pageContext.request.contextPath}/itemstore" method="post">

                    <input type="submit" name="button1rem" value="remove" />
                    <input type="hidden" name="buttonhd" value="${item.nameToString()}" />

                </form>
            </td></tr>
        </c:forEach>
        <tr><td><c:out value="${sum}"/></td></tr>

    </table>



</ul>
<div>Go back to Shop: <a href="/webshop">Shop</a></div>
</body>

</html>