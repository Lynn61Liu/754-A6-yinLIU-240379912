<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>${name}</title>
</head>

<body>
<h1>${name}</h1>
<ul>
    <c:forEach var="item" items="${learningText}" varStatus="status">
        <li id="text_${status.index + 1}">${item}</li>
    </c:forEach>
    <c:forEach var="item" items="${learningImages}" varStatus="status">
        <li ><img id="image_${status.index + 1}" src="${item}"></li>
    </c:forEach>
    <c:forEach var="item" items="${learningVideos}" varStatus="status">
        <li>
            <iframe width="420" height="315" src="${item}" id="video_${status.index + 1}"></iframe>
        </li>
    </c:forEach>
</ul>

</body>
</html>