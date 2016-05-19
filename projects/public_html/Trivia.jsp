<% request.setAttribute("pageTitle", "Capitals Trivia"); %>
<%@ include file="HomeTop.jsp" %>
<h1><u>A Country Capitals Trivia </u><h1><br/><br/>
<h2 class="question"> What is the capital of :</h2>
<form name="capitals" action="mvc-challenge-servlet" method="get">
<table cellpadding="20"><tr><td>
<h2 class="question">1. Iceland </h2>
<input type="radio" name="Iceland" value="Reykjavik">Reykjavik</input><br/>
<input type="radio" name="Iceland" value="Kopavogur">Kopavogur</input><br/>
<input type="radio" name="Iceland" value="Hafnarfjorour">Hafnarfjorour</input><br/>
<input type="radio" name="Iceland" value="Akureyri">Akureyri</input><br/>
<input type="radio" name="Iceland" value="Garoabaer">Garoaer</input></td>

<td>
<h2 class="question">2. Oman </h2>
<input type="radio" name="Oman" value="Adam">Adam</input><br/>
<input type="radio" name="Oman" value="Muscat">Muscat</input><br/>
<input type="radio" name="Oman" value="Barka">Barka</input><br/>
<input type="radio" name="Oman" value="Sur">Sur</input><br/>
<input type="radio" name="Oman" value="Doha">Doha</input></td>

<td>
<h2 class="question">3. Ukraine </h2>
<input type="radio" name="Ukraine" value="Donetsk">Donetsk</input><br/>
<input type="radio" name="Ukraine" value="Luhansk">Luhansk</input><br/>
<input type="radio" name="Ukraine" value="Makiivka">Makiivka</input><br/>
<input type="radio" name="Ukraine" value="Sevastopol">Sevastopol</input><br/>
<input type="radio" name="Ukraine" value="Kiev">Kiev</input></td></tr>

<tr><td>
<h2 class="question">4. Bosnia </h2>
<input type="radio" name="Bosnia" value="Modrica">Modrica</input><br/>
<input type="radio" name="Bosnia" value="Tuzla">Tuzla</input><br/>
<input type="radio" name="Bosnia" value="Pale">Pale</input><br/>
<input type="radio" name="Bosnia" value="Sarajevo">Sarajevo</input><br/>
<input type="radio" name="Bosnia" value="Konjic">Konjic</input></td>

<td colspan="1">
<h2 class="question">5. Denmark </h2>
<input type="radio" name="Denmark" value="Aarhus">Aarhus</input><br/>
<input type="radio" name="Denmark" value="Copenhagen">Copenhagen</input><br/>
<input type="radio" name="Denmark" value="Viborg">Viborg</input><br/>
<input type="radio" name="Denmark" value="Slagelse">Slagelse</input><br/>
<input type="radio" name="Denmark" value="Ringsted">Ringsted</input>

</td><td><input type="submit" value="Submit"/></td></tr>

</table>


</form>



<%@ include file="HomeBottom.jsp" %>
