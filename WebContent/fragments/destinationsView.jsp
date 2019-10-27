<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Destinations</h2>
<table class="w3-table w3-striped w3-hoverable">
<c:forEach items="${destinations }" var="destination">
	<tr>
		<td style="vertical-align: middle;"><img src="images/${destination.images[0] }" class="vignette"/><td>
		<td style="vertical-align: middle;">${destination.region }</td>
		<td style="vertical-align: middle;"><a href="FrontController?cde=delDestination&id=${destination.id }" class="w3-btn w3-red">Supprimer</a></td>
		<td style="vertical-align: middle;"><a href="FrontController?cde=destDetails&id=${destination.id }" class="w3-btn w3-blue">Modifier</a></td>
	</tr>
</c:forEach>
</table>
