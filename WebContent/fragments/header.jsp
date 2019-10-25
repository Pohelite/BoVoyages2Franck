<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoVoyages - back</title>
<link rel="stylesheet" href="css/bovoyages.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
<script type="text/javascript" src="js/bovoyages.js"></script>
</head>
<body>
<div id="page">
<div class="w3-container w3-blue">
<h1>BoVoyages - Back Office</h1>
<nav>
<a href="FrontController?cde=home"  class="w3-btn w3-red">Toutes les destinations</a>
<a href="FrontController?cde=destDetails&id=0"  class="w3-btn w3-red">Ajouter une destination</a>
<a href="FrontController?cde=test"  class="w3-btn w3-red">Test</a>
<!-- <select id="region" name="region"> -->
<!-- <option selected="selected">-- choisir une région --</option> -->
<%-- <c:forEach items="${regions}" var="region"> --%>
<%-- 	<option>${region }</option> --%>
<%-- </c:forEach> --%>
<!-- </select> -->
</nav>
</div>