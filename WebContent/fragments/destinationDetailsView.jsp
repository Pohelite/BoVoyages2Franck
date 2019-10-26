<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="w3-card-4">
	<div class="w3-container w3-light-blue">
	  <h2>${title }</h2>
	</div>
<form action="FrontController" class="w3-container" method="post">
	<input type="hidden" name="cde" value="${cde }"/>
	<input type="hidden" name="id" value="${destination.id }"/>
	
	<label for="region" class="w3-text-blue">Région</label>
	<input id="region" name="region"  class="w3-input" value="${destination.region }">
	<span id="error_region"></span>
	
	<label for="description" class="w3-text-blue">Description du voyage</label>
	<textarea id="description" name="description"  class="w3-input" >
	${destination.description }
	</textarea>
	<span id="error_description"></span>
	
	<div class="w3-container">
		<h4>Images <button type="button" class="w3-btn w3-circle w3-red">+</button></h4>
		<c:forEach items="${destination.images }" var="image">
			<div class="w3-container w3-cell">
				<img alt="${image }" src="images/${image }"/>
			</div>
		</c:forEach>
			
	</div>
	
	<div class="w3-container" id="containerDates">
		<h4>Dates de voyage <button type="button" class="w3-btn w3-circle w3-red" onclick="cloneDatesVoyage()">+</button></h4>
		<span id="nbDates" style="display: none" data-nb-dates="${fn:length(datesVoyages) }">${fn:length(datesVoyages) }</span>
		<c:forEach items="${datesVoyages}" var="dv" varStatus="st">
		<div class="w3-section w3-border">
			<input type="hidden" name="iddv_"${st.index } value="${dv.id }" />
			<div class="w3-container w3-margin-bottom w3-margin-top">
				<label  class="w3-text-blue">Date de départ : </label>
				jour <input name="depart_jour_${st.index }" value="${dv.dateAller.date }" size="4" class="jour"/>
				mois <input name="depart_mois_${st.index }" value="${dv.dateAller.month + 1}" size="4" class="mois"/>
				année <input name="depart_an_${st.index }" value="${dv.dateAller.year + 1900}" size="4" class="an"/><span id="error_depart_${st.index }"></span>
			</div>
			<div class="w3-container w3-margin-bottom">
				<label  class="w3-text-blue">Date de retour : </label>
				jour <input name="retour_jour_${st.index }" value="${dv.dateRetour.date }" size="4" class="jour"/>
				mois <input name="retour_mois_${st.index }" value="${dv.dateRetour.month + 1}" size="4" class="mois"/>
				année <input name="retour_an_${st.index }" value="${dv.dateRetour.year + 1900}" size="4" class="an"/><span id="error_retour_${st.index }"></span>
			</div>
			<div class="w3-container w3-margin-bottom">
				<label  class="w3-text-blue">Tarif : </label>
				<input name="prix_${st.index }" value="${dv.prixHT }" size="8"/>
				<label  class="w3-text-blue">Nb places : </label>
				<input name="places_${st.index }" value="${dv.nbPlaces }" size="8"/><span id="error_prixouplaces_${st.index }"></span>
			</div>
		</div>
		</c:forEach>
	</div>
	<c:if test="${fn:length(erreurs) gt 0}">
		<div class="erreurs"><ul>
			<c:forEach items="${erreurs }" var="erreur">
				<li>${erreur }</li>
			</c:forEach>
		</ul></div>
	</c:if> 	
	<button class="w3-btn w3-light-blue perso-margin">Enregister</button>
</form>
</div>
	<div id="toClone" style="display: none">
		<div class="w3-section w3-border">
			<input type="hidden" name="iddv_"${st.index } value="0" />
			<div class="w3-container w3-margin-bottom w3-margin-top">
				<label  class="w3-text-blue">Date de départ : </label>
				jour <input name="depart_jour_" size="4" class="jour"/>
				mois <input name="depart_mois_" size="4" class="mois"/>
				année <input name="depart_an_" size="4" class="an"/><span id="error_depart_"></span>
			</div>
			<div class="w3-container w3-margin-bottom">
				<label  class="w3-text-blue">Date de retour : </label>
				jour <input name="retour_jour_" size="4" class="jour"/>
				mois <input name="retour_mois_" size="4" class="mois"/>
				année <input name="retour_an_" size="4" class="an"/><span id="error_retour_"></span>
			</div>
			<div class="w3-container w3-margin-bottom">
				<label  class="w3-text-blue">Tarif : </label>
				<input name="prix_" value="1000" size="8"/>
				<label  class="w3-text-blue">Nb places : </label>
				<input name="places_" value="10" size="8"/><span id="error_prixouplaces_"></span>
			</div>
		</div>
	</div>
