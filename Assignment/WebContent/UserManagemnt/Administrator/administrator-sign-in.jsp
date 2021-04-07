<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
   <head>
       <meta charset='utf-8'>
       <meta name='viewport' content='width=device-width, initial-scale=1'>
       <title>Sign In</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
       
       <link rel="stylesheet" href="../../css/sign-in.css">
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    	<script type='text/javascript'></script>
   </head>
   <body oncontextmenu='return false' class='snippet-body'>
       <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    	  <div class="card card0 border-0">
        	 <div class="row d-flex">
             	<div class="col-lg-6">
                	<div class="card1 pb-5">
                    	<div class="row px-3 justify-content-center mt-4 mb-5 border-line"> 
                    		<img src="../../images/undraw_Sign_in_re_o58h.svg" class="image"> 
                    	</div>
                	</div>
            	</div>
            	<div class="col-lg-6">
                	<div class="card2 card border-0 px-4 py-5">
                		<div class="row mb-4 px-3">
                			<h1 class=" mr-4 mt-2 left" style="margin-left: -24px;">Sign In Administrator</h1>
                		</div>
                		<div class="row mb-4 px-3">
                			<button type="button" class="btn btn-blue text-center" onClick="location.href ='/gadgetBadget'">
                    			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
  									<path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
								</svg> Back								
							</button> 
						</div>
                		<form  class="row g-3 needs-validation" action="<%= request.getContextPath() %>/loginAdministrator" method="post" novalidate>
                    		<div class="row px-3"> 
	                    		<label class="mb-1">
	                    			<h6 class="mb-0 text-sm">Email Address</h6>
	                    		</label> 
                    			<input class="mb-4 form-control" type="email" name="email" placeholder="Enter a valid email address" required> 
                    		</div>
                    		<div class="row px-3"> 
                    			<label class="mb-1">
                            		<h6 class="mb-0 text-sm">Password</h6>
                        		</label> 
                        		<input class="mb-4 form-control" type="password" name="password" placeholder="Enter password" required> 
                        	</div>
                    		<div class="row px-3 mb-4 ">
                        		<div class="form-check col"> 
                        			<input id="chk1" type="checkbox" name="chk" class="form-check-input mt-1" style="padding: 1px 1px;"> 
                        			<label for="chk1" class="form-check-label" >Remember me</label> 
                        		</div> 
                        		<a href="#" class=" mb-0 text-sm col" style="margin-left:16rem;">Forgot Password?</a>
                    		</div>
                    		<div class="row mb-3 px-3"> 
                    			<button type="submit" class="btn btn-blue text-center">Login</button> 
                    		</div>
                    		<div class="row mb-4 px-3"> 
                    			<small class="font-weight-bold" style="margin-left: -12px;">Don't have an account? 
                    				<a class="text-danger " href ='/gadgetBadget/UserManagemnt/Seller/seller-register.jsp'>Register</a>
                    			</small> 
                    		</div>
                	   </form>
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