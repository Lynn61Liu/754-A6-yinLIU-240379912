<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Multiple Choice Questions</title>
    <script>
        function updateProgress() {
            var totalQuestions = ${questionsAndAnswers.size()};
            var answeredQuestions = 0;
            var inputs = document.getElementsByTagName("input");

            for (var i = 0; i < inputs.length; i++) {
                if (inputs[i].checked) {
                    answeredQuestions++;
                }
            }

            var progressElement = document.getElementById("progress");
            progressElement.innerText = "Progress: " + answeredQuestions + " out of " + totalQuestions;
        }

        function deselectRadioButtons(questionId) {
            var labels = document.querySelectorAll("[id^='label_'" + questionId + "]");
            for (var i = 0; i < labels.length; i++) {
                labels[i].classList.remove("selected");
            }
        }

        function submitForm() {
            var radios = document.querySelectorAll("input[type='radio']");
            radios.forEach(function (radio) {
                var label = radio.nextElementSibling;
                var correctness = label.querySelector(".correctness");
                if (radio.checked) {
                    correctness.style.display = "inline";
                } else {
                    correctness.style.display = "none";
                }
            });
        }


        document.addEventListener("DOMContentLoaded", function () {
            var questions = document.querySelectorAll("[id^='question']");
            questions.forEach(function (question) {
                var questionId = question.getAttribute("id");
                var radios = document.querySelectorAll("[id^='answer_" + questionId + "']");
                radios.forEach(function (radio) {
                    radio.addEventListener("click", function () {
                        deselectRadioButtons(questionId);
                        var labelId = "label_" + this.id;
                        var label = document.getElementById(labelId);
                        label.classList.add("selected");
                    });
                });
            });
        });
    </script>
    <style>
        .selected {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Multiple Choice Questions</h1>
<p id="progress">Progress: 0 out of ${questionsAndAnswers.size()}</p>
<form id="myForm" oninput="updateProgress()">
    <c:forEach var="item" items="${questionsAndAnswers}">
        <h3 id="question${item.getId()}">${item.getName()}</h3>
        <p>
            <c:forEach var="option" items="${item.getAnswers()}" varStatus="status">
                <input type="radio" id="answer_${item.getId()}_${status.index}" name="answer_${item.getId()}"
                       value="${option.key}">
                <label id="label_${item.getId()}_${status.index}" for="answer_${item.getId()}_${status.index}">
                        ${option.key}
                    <span class="correctness" style="display: none" id="correctness_${item.getId()}_${status.index}" >${item.getCorrectness(option.key)}</span>
                </label><br>
            </c:forEach>
        </p>
    </c:forEach>
    <br>
    <button id="submit" type="button" onclick="submitForm()">Submit</button>
</form>
</body>
</html>
