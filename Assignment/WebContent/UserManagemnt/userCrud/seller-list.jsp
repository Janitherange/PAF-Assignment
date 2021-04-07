<%@ page import="userManagementService.UserDAO" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
   <head>
       <meta charset='utf-8'>
       <meta name='viewport' content='width=device-width, initial-scale=1'>
       <title>Manage Sellers</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
       
       <link rel="stylesheet" href="../../css/product-list.css">
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    	<script type='text/javascript'></script>
   </head>
   <body oncontextmenu='return false' class='snippet-body'>
       <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    	  <div class="cad card0 border-0">
        	 <div class="row d-flex">
             	<div class="col-lg-2">
                	<div class="card1 pb-5">
                    	<div class="col  justify-content-center mt-4 mb-5 border-line"> 
                    		<a id="home-button" href="/gadgetBadget/UserManagemnt/Administrator/home-administrator.jsp">
                    			<img src="../../images/homepage.svg" class="image">Home
                    		</a>
                    		<img src="../../images/undraw_Marketing_re_7f1g.svg" class="image2 mt-10">
                    	</div>
                	</div>
            	</div>
            	<div class="col-lg-10">
                	<div class="card2 card border-0 px-4 py-5">
                		<div class="row mb-4 px-3">
                			<h1 class="mb-5 mr-4 mt-2 left" style="margin-left: -24px;">Seller Management</h1>
								<div class="row mb-3 px-3"> 
                    				<button type="button" class="btn btn-blue text-center" onClick="location.href ='/gadgetBadget/UserManagemnt/userCrud/seller-add.jsp'">Add Seller</button> 
                    			</div>
<%
								//Delete item----------------------------------
								if (request.getParameter("sellerID") != null)
								{
									UserDAO Obj2 = new UserDAO();
									Obj2.deleteSeller(request.getParameter("sellerID"));
								}
%>
<%                 				UserDAO Obj1 = new UserDAO();
 								out.print(Obj1.readSellers());
%>

								<div class="row mb-3 px-3">
									<label class="mb-1 ">
                						<h6 class="mb-0 text-sm">
                							<%  
                								//out.print(session.getAttribute("statusMsg"));
                							%>
                						</h6>
                					</label>
								</div>
                		</div>
            		</div>
        	 	</div>
      	  	</div>
   	   </div>
   	 </div>
   	   <script type="text/javascript">
   			var forms=document.querySelectorAll(".needs-validation");
			Array.prototype.slice.call(forms).forEach(function(form)
			{
				form.addEventListener("submit", function(event)
				{
					if(!form.checkValidity())
					{
						event.preventDefault();
						event.stopPropagation();
					}
				
				form.classList.add("was-validated");
				}, false);
			});
   	   </script>
   </body>
</html>