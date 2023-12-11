
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bean.product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/detail-product.css">
    <title>Document</title>
</head>
<body>
	<div id="notice">
        <div class="container">
            <div id="logo">
               <a href="index2.jsp"><img src="css/img/logo1.png" alt=""></a> 
            </div>
            <div id="search">
                <input type="text" id="inputsearch">
                <input type="submit" value="search" id="btnsearch">
            </div>
                 <div id="catalog">
                <ul style="display: flex;">
                   
                    
                    <% if(session.getAttribute("username")!=null)
                    	{%>
                    	<li><a href="" style="white-space: nowrap;"><%= (String)session.getAttribute("username")%></a></li>
                    	 <li><a href="MybookController?id=1">MyBook</a></li>
                    	<% }
                    else{ %>
                    	<li><a href="login.jsp">Login</a></li>
                   <% }
                    	%>
                     <% if(session.getAttribute("username")!=null)
                    	{%>
                 	<li><a href="xoaSession.jsp" style=" white-space: nowrap;">Log out</a></li>
                 	  <% }
                    	%>
                </ul>
            </div>

        </div>

    </div>
  
    <div id="detail-content">
        <div class="container2">
        <% ArrayList<product> product =(ArrayList<product>)request.getAttribute("product");
        for(int i =0; i<product.size();i++) { %>
            <div class="row">
               <div class="col-md-6">
                <iframe src="<%= product.get(i).getFile()%>" width="640" height="480" allow="autoplay"></iframe> </div>
                <div class="col-md-6">
                    <div class="right" >
                           <h2><%= product.get(i).getTitle()%></h2>
                           <p id="discription"><%= product.get(i).getDescription()%></p>
   							<div ><a href="AddBookLove?id_product=<%=product.get(i).getId()%>">Bấm vào đây để thêm vào danh mục yêu thích!</a></div>
                    </div>
                </div>
               
            </div>
            <%} %>
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