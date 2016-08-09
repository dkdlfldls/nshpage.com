<link rel="import" href="../js/bower_components/polymer/polymer.html"></link>
<dom-module id="nshpage-basic-board">

<style>
 paper-radio-button.nshpage-basic-board-radio-green {
    --paper-radio-button-checked-color: var(--paper-green-500);
    --paper-radio-button-checked-ink-color: var(--paper-green-500);
    --paper-radio-button-unchecked-color: var(--paper-green-900);
    --paper-radio-button-unchecked-ink-color: var(--paper-green-900);
    --paper-radio-button-label-color: var(--paper-green-500);
  }
  
  .nshpage-basic-board-align-center{
  	text-align: center;
  }
  
  .nshpage-basic-board-table-margin-top {
  	margin-top: 100px;
  }
  
  .nshpage-basic-board-search-margin {
  	margin-top : -20px;
  }
  
  .nshpage-basic-board-polymer-btn-margin {
  	margin-top : -10px;
  }

</style>

<template>

<div class="container nshpage-basic-board-table-margin-top">
	<div class="row">
		<div class="col-sm-10">
			
		
			<div class="row">
				<div class="col-sm-1">
					<div class="dropdown">
   						<button class="btn btn-default dropdown-toggle" 
   								type="button" data-toggle="dropdown" id="nshpage-basic-board-search-dropdown-btn">제목
    						<span class="caret"></span>
    					</button>
    					<ul class="dropdown-menu">
    						<li class="dropdown-header">검색조건</li>
      						<li name="nshpage-basic-board-searchType"><a href="#">제목</a></li>
      						<li name="nshpage-basic-board-searchType"><a href="#">내용</a></li>
      						<li name="nshpage-basic-board-searchType"><a href="#">제목 + 내용</a></li>
    					</ul>
  					</div>
				</div>
				<div class="col-sm-2">
					<paper-input class="nshpage-basic-board-search-margin" label="검색어 입력"></paper-input>
				</div>
				<div class="col-sm-2">
					<paper-button raised class="nshpage-basic-board-polymer-btn-margin"><iron-icon icon="search"></iron-icon>검색</paper-button>
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<paper-button raised class="nshpage-basic-board-polymer-btn-margin" id="nshpage-basic-board-move-writepage-btn">
						<iron-icon icon="create"></iron-icon>글쓰기
					</paper-button>
				</div>
			
			
			</div>
			
  			
			
		
		
			<table class="table" >
   			<thead>
      			<tr>
        			<th><paper-radio-button class="nshpage-basic-board-radio-green"></paper-radio-button></th>
        			<th>글번호</th>
        			<th>제목</th>
        			<th>작성자</th>
        			<th>작성일</th>
     			</tr>
    			</thead>
    			<tbody>
    	
    				<template is="dom-repeat" items="{{board}}">
    					<tr>
    						<td><paper-radio-button name="nshpage-basic-board-radio" class="nshpage-basic-board-radio-green"></paper-radio-button></td>
    						<td>{{item.board_id}}</td>
    						<td>{{item.title}}</td>
    						<td>{{item.writer}}</td>
    						<td>{{item.regist_time}}</td>
    					</tr>
    				</template>
    	 
    			</tbody>
  			</table>
		</div>
		<div class="col-sm-2"></div>
	</div>
  
</div>

</template>


<script>
Polymer({
	is : "nshpage-basic-board",
	properties : {
		board : {
			type : Object,
			notify : true
		},
		category_id : {
			type : Number,
			notify : true
		}
	},
	
	ready : function(){
		var polymerObject = this;
		$.post(
			"/ajax/board/getAllList?category_id=" + this.category_id,
			{},
			function(data, status){
				polymerObject.board = data;
		});
	},
	
	move_write_page : function(){
		location.href = "/board/write";
	}
	
	
});

$(function(){
	
	var nshpage_basic_board = document.createElement("nshpage-basic-board");
	
	var select_search_type = function(){
		var caret_span = $(document.createElement("span")).addClass("caret");
		$("#nshpage-basic-board-search-dropdown-btn").text($(this).text()).append(caret_span);
	}
	
	for (i = 0; i < $("li[name=nshpage-basic-board-searchType]").length; i++) {
		$($("li[name=nshpage-basic-board-searchType]")[i]).click(select_search_type);
	}
	
	$("#nshpage-basic-board-move-writepage-btn").click(function(){
		
		nshpage_basic_board.move_write_page();
	});
})

</script>



</dom-module>