<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STUDY ROOM</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
    height: 100%;
    line-height: 1.8;
}
/* Full height image header */
.bgimg-1 {
    background-position: center;
    background-size: cover;
    background-image: url("<%=request.getContextPath()%>/imgs/back.jpg");
    min-height: 100%;
}
.w3-bar .w3-button {
    padding: 16px;
}

/* style="overflow:hidden;" */
</style>

</head>
<body >

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar">
    <a href="main" class="w3-bar-item w3-button w3-wide">HANBOMAL</a>
    <!-- Right-sided navbar links -->
    <div class="w3-right w3-hide-small">
      <a href="about" class="w3-bar-item w3-button">ABOUT</a>
      <a href="javascript:void(0)" class="w3-bar-item w3-button" 
      onclick="document.getElementById('login').style.display='block'"><i class="fa fa-user"></i> MYPAGE</a>
      <div class="w3-dropdown-hover">
    <button class="w3-button"><i class="fa fa-th"></i> WORKSPACE</button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
      <a href="study_making" class="w3-bar-item w3-button">개설하기</a>
      <a href="study_board" class="w3-bar-item w3-button">STUDY 1</a>
      <a href="study_album" class="w3-bar-item w3-button">STUDY 2</a>
    </div>
  </div>

    </div>
    <!-- Hide right-floated links on small screens and replace them with a menu icon -->

    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="w3_open()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
</div>

<!-- Sidebar on small screens when clicking the menu icon -->
<nav class="w3-sidebar w3-bar-block w3-black w3-card w3-animate-left w3-hide-medium w3-hide-large" style="display:none" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a>
  <a href="about" onclick="w3_close()" class="w3-bar-item w3-button">ABOUT</a>
  <a href="#team" onclick="w3_close()" class="w3-bar-item w3-button">MYPAGE</a>
  <a href="study_board" onclick="w3_close()" class="w3-bar-item w3-button">WORKSPACE</a>
</nav>





<!-- login Modal -->


 <div id="login" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom w3-small" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('login').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        
      </div>

      <form class="w3-container" method="post" action="../user/loginPro">
        <div class="w3-section">
          <label><b>ID</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" style="display: block; width: 100%;" placeholder="아이디를 입력하세요." name="tryid" required>
          <label><b>PASSWORD</b></label>
          <input class="w3-input w3-border" style="display: block; width: 100%;" type="password" placeholder="비밀번호를 입력하세요." name="trypwd" required>
          <button class="w3-button w3-block w3-black w3-section w3-padding" type="submit">로그인</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked">로그인 기억하기
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('login').style.display='none'" type="button" class="w3-button w3-black">취소</button>
        <span class="w3-right w3-padding w3-hide-small"><a href="../user/join">회원가입</a>&nbsp;&nbsp;&nbsp; <a href="#">비밀번호</a>를 잊으셨나요?</span>
      </div>

    </div>
  </div>
 </body>
 <script type="text/javascript">

var mySidebar = document.getElementById("mySidebar");

function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
    } else {
        mySidebar.style.display = 'block';
    }
}


function w3_close() {
    mySidebar.style.display = "none";
}

</script>
</html>