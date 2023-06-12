<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>SE754 Dev Web App</title>
</head>
<script>
    function navigateToLearnPage(index) {
        window.location.href = 'http://localhost:8080/learn/' + index;
    }
</script>
<body>
<h1> Course: <span id="courseName">${courseName}</span></h1>
<p> Category: <span id="courseCategory"> ${courseCategory}</span></p>
<p> Format: <span id="courseFormat"> ${courseFormat} </span></p>
<p> Topic: <span id="courseTopic"> ${courseTopic}</span></p>
<p id="courseDescription"> ${courseDescription} </p>
<br>
<p> Course Difficulty Rating: <span id="difficultyRating">${courseDifficulty}</span>/5</p>
<p> Course Time Estimate: <span id="timeEstimate">${courseTime}</span> minutes</p>
<c:if test="${!isEnrolled}">
    <form method="post">
        <button type="submit" id="enrolButton"> Enrol In Course</button>
    </form>
</c:if>
<c:if test="${isEnrolled}">
    <div id="enrolledCourseMessage"> You're Enrolled!</div>
</c:if>
<br>
<p> Course Learning Modules: </p>
<ul id="learningList">
    <c:forEach items="${learnMap}" var="entry" varStatus="status">
        <p name="learningModule">
                ${entry.key}
            <span id="completed_${status.index}">${entry.value ? 'completed' : 'not complete'}</span>
            <button type="button" id="navButton_${status.index}" onclick="navigateToLearnPage(${status.index})">Navigate</button>
        </p>
    </c:forEach>
</ul>
<p> Course Practice Modules: </p>
<ul id="practiceList">
    <c:forEach items="${practiceList}" var="entry">
        <p name="practiceModule"> ${entry} </p>
    </c:forEach>
</ul>
<br>
<p> Course Syllabus </p>
<ol id="courseSyllabus">
    <c:forEach items="${courseSyllabus}" var="entry">
        <p name="courseSyllabus"> ${entry} </p>
    </c:forEach>
</ol>
</body>

</html>