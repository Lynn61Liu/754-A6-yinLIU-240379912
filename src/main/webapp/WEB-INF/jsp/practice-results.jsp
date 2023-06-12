<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>SE754 Dev Web App</title>
</head>

<body>
<h1> Practice Results</h1>
<h2> Module: ${practiceName}</h2>
<h2> Overall Results <span id="overallResult">${overallResult}</span> </h2>
<h2> Percentage: <span id="percentageResult">${percentageResult}%</span></h2>
<h2> Incorrect Questions: </h2>
<c:forEach items="${questionList}" var="entry" varStatus="status">
    <div> Question: <span name="incorrectQuestion"> ${entry}</span></div>
    <div> Answer: <span name="questionAnswer"> ${answerList[status.index]}</span></div>
    <br>
</c:forEach>
<form method="post">
    <button type="submit" id="retryButton"> Retry Practice </button>
</form>

</body>

</html>