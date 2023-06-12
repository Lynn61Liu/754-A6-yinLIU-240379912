<html>

<head>
<title>SE754 Dev Web App</title>
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
   <nav class="navbar ">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <h1>SE754 Web App A6</h1>

            <div calss="searchBar">
              <input type="text" name="search" id="search" />
              <button id="searchBtn">Search </button>
            </div>

        </div>
        <!-- /.container-fluid -->
    </nav>
<main>
	<font color="red">${errorMessage}</font>

	<h2>Insert username and password</h2>
	<form method="post">
		Name : <input type="text" name="name" id="name" />
		Password : <input type="password" name="password" id="password"/>
		<input type="submit" id="submitbtn" />
	</form>
</main>

 <footer class="footer">
     <div class="container">
      <div class="row">
        <div class="footer-col">
          <h4>company</h4>
          <ul>
            <li>about us</li>
            <li>our services</li>
            <li>privacy policy</li>
            <li>affiliate program</li>
          </ul>
        </div>
        <div class="footer-col">
          <h4>get help</h4>
          <ul>
            <li><a id="FAQLink" href="/FQA"> Help/FAQ </a></li>
            <li>Get the app</li>
            <li>Privacy Policy</li>
            <li>Cookie Preferences</li>
          </ul>
        </div>
        <div class="footer-col">
          <h4>HOT Topic</h4>
          <ul>
            <li>Python</li>
            <li>Amazon AWS</li>
            <li>Data Science</li>
            <li>Java bootcamp</li>
          </ul>
        </div>

      </div>
     </div>
  </footer>



</body>
<script>
  document.getElementById("searchBtn").addEventListener("click", function() {
    var searchTerm = document.getElementById("search").value;
    var url = "/search"
    window.location.href = url;
    alert(url);
  });
</script>

</html>