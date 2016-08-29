<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 마진 바깥여백  패딩 안쪽여백  보더 요소의 테두리 -->

<link rel="stylesheet" href="/resources/css/top_nev.css">

<div>
	<table class="top-table-nev">
		<tbody>
			 <tr>
			 	<td class="top-nev-home"><img class="top-nev-home-image" src="/resources/image/home/home1.png" ></td>
			    <td class="top-nev-left-item">Column 1 HeadingHeadingHeading</td>
			    <td class="top-nev-left-item">Column 2 Heading</td>
			    <c:if test="${sessionScope.isLogin eq true}">
				   	<td class="top-nev-right-item">Logout</td>			    	
			    </c:if>
			    <c:if test="${sessionScope.isLogin ne true}">
			   		<td class="top-nev-right-item" id="join">Join</td>
				   	<td class="top-nev-right-item" id="login">Login</td>			    	
			    </c:if>
			 </tr>
		</tbody>
	</table>

</div>


