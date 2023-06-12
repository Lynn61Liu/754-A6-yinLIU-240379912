<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>SE754 Dev Web App</title>
</head>

<body>

<h1 id="achievementsPageTitle">Achievements</h1>

<ul name="achievements">
    <c:forEach items="${achievementList}" var="entry">
        <p name="achievement"> ${entry} </p>
    </c:forEach>
</ul>

<ul name="achievementState">
    <c:forEach items="${achievementStateList}" var="entry">
        <p name="achievementStates"> ${entry} </p>
    </c:forEach>
</ul>
<form method="post">
    <button type="submit" id="viewAchievedButton" name="achieved"> View Achieved Achievements </button>
    <button type="submit" id="viewUnachievedButton" name="unachieved"> View Unachieved Achievements </button>
</form>
</body>

</html>