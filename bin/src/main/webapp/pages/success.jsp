<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
    
<html>
 <head>
 <h1 align="center">
Details of all users are:<br> 
</h1>
 </head>
 <body>
 <table width="400" border="2"  align="center">
<colgroup>
 <col ></col>
</colgroup>
<thead>
  <tr>
   <td align="center"><b>Id</b></td>
   <td align="center"><b>Name</b></td>
  <tr>
 </thead>
 <tbody>
<c:forEach items="${userDetails}" var="user">
 <tr onclick="showDialog(${user.id})"  data-toggle="tooltip">
   <td align="center">${user.id}</td>
   <td align="center">${user.name}</td>
   <span class="tooltip">Click here to edit</span>
 </tr>
 <div id="detailsId_${user.id}" align="center" title="Person details of ${user.name}" style="display:none;">
  <input type="text" name="userId" id="userId" value="${user.id}">
  <input type="text" name="usercategory" id="usercategory" value="${user.category}">
  <input type="text" name="usercategoryid" id="usercategoryid" value="${user.categoryid}">
  <input type="text" name="useraddress" id="useraddress" value="${user.address}">
  <input type="text" name="userdescription" id="userdescription" value="${user.description}">
  <input type="text" name="usercontact" id="usercontact" value="${user.contact}">
  <input type="text" name="userempcode" id="userempcode" value="${user.empcode}">
  <input type="text" name="userimage" id="userimage" value="${user.image}">
  </div>
</c:forEach>
</tbody>
</table>

 </body>
 <script type="text/javascript">
	   function showDialog(userId)
	    {
	      $("#detailsId_"+userId).dialog(
	      {
	        width: 500,
	        height: 250,
	        buttons:{
	        	save:function(){
	        		alert("Your data has been successfully saved");
	        		$(this).dialog("close");
	        	},
	        	cancel:	function(){
	        		$(this).dialog("close");
	        	}
	        },
	        open: function(event, ui){
	         // var textarea = $('<textarea style="height: 276px;">');
	        }
	      });
	    }
	   $(document).ready(function(){
		  	
	   });
	   
 </script>
 <style>
  .tooltip:hover .tooltiptext {
		   visibility: visible;
		   opacity: 1;
		 }
 </style>
</html>
 



