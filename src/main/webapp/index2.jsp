<%@page import="model.bean.catagory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.bean.product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/index.css">
    <title>Document</title>
</head>
<body>
	<% 
	 String yourAttribute = (String) session.getAttribute("username");

			
	%>
    <div id="notice">
        <div class="container">
            <div id="logo">
                <img src="css/img/logo1.png" alt="">
            </div>
            <div id="search" style="min-width: 400px;">
                <form action="SearchProduct" method="POST">
              	  <input type="text" id="inputsearch" name = "inputsearch" placeholder="Mời Nhập Tên Tài Liệu ">
                	<input type="submit" name="btnsearch" value="Search" id="btnsearch">
              </form>
            </div>
            <div id="catalog">
                <ul style="display: flex;">
                   
                    
                    <% if(session.getAttribute("username")!=null)
                    	{%>
                    	<li><a href="" style="white-space: nowrap;"><%= (String)session.getAttribute("username")%></a></li>
                    	
                    	<% }
                    else{ %>
                    	<li><a href="login.jsp">Login</a></li>
                   <% }
                    	%>
                    
                 
                </ul>
            </div>

        </div>

    </div>
    <div id="header">

        <div class="container">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100 slide"
                            src="https://freenice.net/wp-content/uploads/2021/03/Hinh-anh-sach-dep-3.jpg"
                            alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100 slide" src="webcontent/css/img/hinh-anh-cuon-sach-dep-3.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item it1">
                        <img class="d-block w-100 slide" src="webcontent/css/img/sach2.jpg" alt="Second slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    	
    	
    
 		

   
     <div id="content">
		  <div class="row">
                <div class="col-md-12">
                    <div id="content_item" style="color:red; font-size: 25px; background-color: aquamarine; text-align: center;">
                        <h1>Chào mừng ban đến với vua tài liệu !</h1>
                        <a href="LoadTrangchu?opt=1">Bam vao day</a>
                    </div>
                 
                </div>
            
      
        
            
        </div>
    
        
	</div>
    	
    
  
    <div id="footer">
      <div id="contain">
        <div id="item_Footer">
            <ul id="list_footer">
                <li><a href=""><strong>Open Library</strong></a></li>
                <li><a href="">Vision</a></li>
                <li><a href="">Volunteer</a></li>
              
            </ul>
        </div>
        <div id="item_Footer">
            <ul id="list_footer">
                <li><a href=""><strong>Về Chúng Tôi</strong></a></li>
                <li><a href="">TRương Ngọc Sơn <i class="fa-brands fa-square-instagram"></i></a></li>
                <li><a href="">Võ Văn Đức </a></li>
                <li><a href="">Nguyễn Văn Nhàn </a></li>
            </ul>
        </div>
        <div id="item_Footer">
            <ul id="list_footer">
                <li><a href=""><strong>Liên Hệ</strong></a></li>
                <li><a href="">Facebook</a></li>
                <li><a href="">Zalo</a><i class="fa-brands fa-twitter"></i></li>
                <li><a href="">Instagram</a><i class="fa-brands fa-instagram"></i></li>
              
            </ul>
        </div>
        <div id="item_Footer">
            <ul id="list_footer">
                <li><a href=""><strong>Cam kết</strong></a></li>
                <li><a href="">An Toàn</a></li>
                <li><a href="">Nhanh Chóng</a></li>
              
            </ul>
        </div>
      </div>
      
    </div>
    <div id="footer_2">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </div>

</body>
</html>