<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="/resources/js/bower_components/webcomponentsjs/webcomponents-lite.js"></script>
<script src="/resources/js/bower_components/angular/angular.js"></script>


<link rel="import" href="/resources/include/base_include.html">

<link rel="import" href="/resources/elements/nshpage-left-nev.html">
<link rel="import" href="/resources/elements/nshpage-top-nev.html">
<link rel="import" href="/resources/elements/nshpage-login-modal.html">
<link rel="import" href="/resources/elements/nshpage-join-modal.html">
<link rel="import" href="/resources/elements/nshpage-basic-board.jsp">

<script type="text/javascript">

var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope) {
    $scope.sub_menu_arr = [{data : "data1"}, {data : "data3"}, {data : "data5"}];
}); 


 $(function(){
	 $("#send").click(function(){
		 $.post("/ajax/login",
			{
			 email: "aaa@aaa.com",
			 password: "1234"
			},
			 function(data, status){
				console.log(data.password);
			});
	 });
 })

</script> 

<title>Home</title>
</head>
<body>

	<nshpage-top-nev></nshpage-top-nev>
	
	<div class="row">
		<div class="col-sm-2">
			<nshpage-left-nev></nshpage-left-nev>
		</div>
		<div class="col-sm-8"></div>
		<div class="col-sm-2"></div>
		</div>
	</div>
	
	
	<!-- Trigger the modal with a button -->




	<!--  modal -->
	<nshpage-login-modal></nshpage-login-modal>
	<nshpage-join-modal></nshpage-join-modal>

</body>
</html>
		