<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Analytics</title>
</head>
<body>
<h1>
    This is the Analytics Page
</h1>
<p>hello</p>
<label for= "progressBar">Course Progress</label>
<p id="courseName">Course: ${courseName}</p>
<progress id="progressBar"value="${progress}" max="1"></progress>
<p>Learning Modules</p>
<ul name="learning">
    <c:forEach items="${learningModules}" var="entry">
        <p name="learningModule"> ${entry} </p>
    </c:forEach>
</ul>

<ul name="learningProgress">
    <c:forEach items="${learningModulesProgress}" var="entry">
        <p name="learningModuleProgress"> ${entry} </p>
    </c:forEach>
</ul>
<p>Practice Modules</p>
<ul name="practice">
    <c:forEach items="${practiceModules}" var="entry">
        <p name="practiceModule"> ${entry} </p>
    </c:forEach>
</ul>

<ul name="practiceProgress">
    <c:forEach items="${practiceModulesProgress}" var="entry">
        <p name="practiceModuleProgress"> ${entry} </p>
    </c:forEach>
</ul>

</body>
</html>