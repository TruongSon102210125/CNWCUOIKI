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
    <link rel="stylesheet" href="css/mybook.css">
    <title>Document</title>
</head>
<body>
	   <div id="notice">
        <div class="container">
            <div id="logo">
                <img src="css/img/logo1.png" alt="">
            </div>
            <div id="search">
                <input type="text" id="inputsearch">
                <input type="submit" value="search" id="btnsearch">
            </div>
            <div id="catalog">
                <ul style="display: flex;">
                    <li><a href="">MyBook</a></li>
                    <li><a href="">Login</a></li>
                    <li><a href="">Sign up</a></li>
                </ul>
            </div>

        </div>

    </div>
   
    <div id="detail-content">
        <div class="container2">
                <div class="row">
                    <div class="col-md-12">
                        <h1 style="margin-top: 20px;">Danh Sách Tài liệu Yêu Thích</h1>
                        <table class="table">
                            <thead class="thead-dark">
                              <tr>
                                <th scope="col">Image</th>
                                <th scope="col">Tittle</th>
                                <th scope="col">Description</th>
                                <th scope="col">Delete</th>
                              </tr>
                            </thead>
                            <tbody>
                         
                             	<%  ArrayList<product> product =(ArrayList<product>)request.getAttribute("product");
                             		for(int i=0 ; i<product.size();i++)
                             		{%>
                             			     <tr>
                                <td><img src="<%=product.get(i).getImg() %>" alt=""></td>
                                <td><%=product.get(i).getTitle() %></td>
                                <td><%=product.get(i).getDescription() %></td>
                                <td><a href="DeleteMybook?id_product=<%=product.get(i).getId()%>">Delete</a></td>
                              </tr>
                             	<% 	}
                             	%>
                        
                            </tbody>
                          </table>
                    </div>
                </div>
               
            </div>
        </div>
</body>
</html>