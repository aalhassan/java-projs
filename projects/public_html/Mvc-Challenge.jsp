<% request.setAttribute("pageTitle", "Your Result");%>
<%@ include file="HomeTop.jsp" %>

<h2>Your Result</h2>
<div style="float:left">
<table cellspacing="10" cellpadding="5">
    <tr class="table_header"><td>Country</td><td>Capital</td>
         <td>Answered</td><td></td>
    </tr>
    <tr><td>Iceland</td><td>${results.gradeMap['Iceland'][0]}</td>
         <td>${results.gradeMap['Iceland'][1]}</td>
         <td><img src="${results.gradeMap['Iceland'][2]}" class="marker" alt="marker"/></td>
    </tr>
    <tr><td>Oman</td><td>${results.gradeMap['Oman'][0]}</td>
         <td>${results.gradeMap['Oman'][1]}</td>
          <td><img src="${results.gradeMap['Oman'][2]}" class="marker" alt="marker"/></td>
    </tr>
    <tr><td>Ukraine</td><td>${results.gradeMap['Ukraine'][0]}</td>
         <td>${results.gradeMap['Ukraine'][1]}</td>
         <td><img src="${results.gradeMap['Ukraine'][2]}" class="marker" alt="marker"/></td>
    </tr>
    <tr><td>Bosnia</td><td>${results.gradeMap['Bosnia'][0]}</td>
         <td>${results.gradeMap['Bosnia'][1]}</td>
         <td><img src="${results.gradeMap['Bosnia'][2]}" class="marker" alt="marker"/></td>
    </tr>
    <tr><td>Denmark</td><td>${results.gradeMap['Denmark'][0]}</td>
         <td>${results.gradeMap['Denmark'][1]}</td>
        <td><img src="${results.gradeMap['Denmark'][2]}" class="marker" alt="marker"/></td>
    </tr><br/>
    <tr><td>Correct Answers:</td><td><font color="red">${results.score}</font></td>
         <td>Score Percent (%):</td><td><font color="green">${results.scorePercent}</font></td>
    </tr>

</table>
</div>
<div style="float:right">
<img class="appImg" src="${appDiagram}" alt="appDiagram"/>
</div>


<%@ include file="HomeBottom.jsp" %>

