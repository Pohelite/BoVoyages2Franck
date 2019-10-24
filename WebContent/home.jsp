<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="fragments/header.jsp"></jsp:include>
<div id="main">
	<jsp:include page="fragments/${fragment}.jsp"></jsp:include>
</div>
<jsp:include page="fragments/footer.jsp"></jsp:include>