<html>

<head>
    <title>SE754 Dev Web App</title>
</head>

<body>
<h1>CS Ed Profile</h1>
<form method="post">

    <p>
        Profile Section One Visibility: <input type="checkbox" name="checkBox" id="pSectionOne" value="Off"/>
    </p>
    <span>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam pharetra erat vitae venenatis commodo. Nulla vel blandit diam, sit amet malesuada orci. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam at ante massa. Donec eleifend massa eu velit volutpat tempus. Aliquam ut malesuada eros, nec bibendum erat. Cras non risus sed odio convallis eleifend a in sapien. Nulla tempus, magna scelerisque venenatis feugiat, lacus augue semper sem, id vehicula velit sem ut lectus. Praesent lacinia mi eu ligula lacinia malesuada. Cras efficitur pulvinar eros bibendum vehicula. Nam iaculis posuere placerat. In hac habitasse platea dictumst. Suspendisse sodales pellentesque velit ut cursus.
    </span>
    <p>Profile Section Two Visibility: <input type="checkbox" name="checkBox" id="pSectionTwo" value="Off"/></p>
    <span>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam pharetra erat vitae venenatis commodo. Nulla vel blandit diam, sit amet malesuada orci. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam at ante massa. Donec eleifend massa eu velit volutpat tempus. Aliquam ut malesuada eros, nec bibendum erat. Cras non risus sed odio convallis eleifend a in sapien. Nulla tempus, magna scelerisque venenatis feugiat, lacus augue semper sem, id vehicula velit sem ut lectus. Praesent lacinia mi eu ligula lacinia malesuada. Cras efficitur pulvinar eros bibendum vehicula. Nam iaculis posuere placerat. In hac habitasse platea dictumst. Suspendisse sodales pellentesque velit ut cursus.
    </span>
    <p>Set Profile Visibility to Public?: <input type="checkbox" name="checkBox" id="pVisCheck" value="Off"/></p>
    <input type="submit" id="saveBtn"/>

</form>
<font color="green" id="statusMsg">${successMessage}</font>
</body>

</html>