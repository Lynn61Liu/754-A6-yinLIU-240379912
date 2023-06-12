<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>SE754 Dev Web App</title>
<link rel="stylesheet" href="css/search.css">
<link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

 <body>
    <section class="keyText">
      <label id="message">Search Key:  ${keyword} </label>
    </section>

    <!-- products -->
    <section class="products">
      <!-- filters -->
      <div class="filters-container">
        <!-- search -->

        <!-- categories -->
        <h5>Category</h5>
        <article class="companies">
          <button class="company-btn" id="CategoryP">Programming</button>
          <button class="company-btn"  id="CategoryS">Systems</button>
          <button class="company-btn"  id="CategoryR">Robotics</button>
           <button class="company-btn"  id="Category">BootCamp</button>
        </article>


      </div>

      <!-- products -->
      <div class="products-container">
         <c:forEach items="${lists}" var="entry">
        <!-- single product -->
          <article class="product">
          <div id="imgWrap">
            <img
              src="https://www.classcentral.com/report/wp-content/uploads/2022/05/Java-BCG-Banner.png"
              alt=""
            />
          </div>

          <div class="courseItem">
            <h5 class="courseName">${entry.getName()}</h5>
            <div class="courseDescription">${entry.getDescription()}</div>
            <div class="courseCategory">Category:${entry.getCategory()}</div>
            <div class="courseFormat">Format:${entry.getFormat()}</div>
            <div class="courseTopic">Topic:${entry.getTopic()}</div>
          </div>
          </article>
        <!-- end  single product -->
        <!-- single product -->
        </c:forEach>
      </div>
    </section>


</body>
<script>

  var buttons = document.getElementsByClassName("company-btn");

  for (var i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", function() {
      var buttonValue = this.textContent;
      alert(buttonValue);
      var form = new FormData();
          form.append("category", buttonValue);
          var http = new XMLHttpRequest();
              http.open("POST", "/category", true);
              http.send(form);
               http.onreadystatechange = function() {
                                  if (http.readyState === XMLHttpRequest.DONE && http.status === 200) {
                                    alert("/category");
                                    window.location.href = "/category";
                                  }
               };
    });
  }



</script>
</html>