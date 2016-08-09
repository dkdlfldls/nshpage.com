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
<link rel="import" href="/resources/elements/test-element.html">

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

<button type="button" id="send">send</button>

<!--
	<nshpage-top-nev></nshpage-top-nev>
	<nshpage-left-nev></nshpage-left-nev>
	-->
	<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
<nshpage-join-modal></nshpage-join-modal>

</body>
</html>
