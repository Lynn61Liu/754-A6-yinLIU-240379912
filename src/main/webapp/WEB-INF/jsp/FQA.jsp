<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>SE754 Dev Web App</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
    <!-- extra fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap"
      rel="stylesheet"
    />
<link rel="stylesheet" type="text/css" href="/css/styles.css">

</head>

 <body>
      <section class="questions">
        <!-- title -->
        <div class="title">
          <h2>Help & FAQ</h2>
        </div>
        <!-- questions -->
        <div class="section-center">

 <c:forEach items="${lists}" var="entry">
      <!-- single question -->
          <article class="question">
            <!-- question title -->
            <div class="question-title">
              <p>${entry.title}</p>
              <button type="button" class="question-btn">
                <span class="plus-icon">
                  <i class="far fa-plus-square" id="btn_${entry.id}"></i>
                </span>
                <span class="minus-icon">
                  <i class="far fa-minus-square"></i>
                </span>
              </button>
            </div>
            <!-- question text -->
            <div class="question-text" id="text_${entry.id}">

                 <p>${entry.text}</p>

            </div>
          </article>
          <!-- end of single question -->

    </c:forEach>




      </section>
    </main>

<script src="/js/faq.js"></script>

  </body>

</html>