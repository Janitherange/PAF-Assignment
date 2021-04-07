<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        
        <link rel="stylesheet" href="../../css/dashboard.css">
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
                    		<div class="row px-3 justify-content-center mt-4 mb-5 border-line"> <img src="../../images/undraw_coming_home_52ir.svg" class="image"> </div>
                		</div>
            		</div>
            		<div class="col-lg-6">
                		<div class="card2 card border-0 px-4 py-10">
                				<div class="row mb-5 px-3">
                					<div class="col-lg-10">
                							<h1 class="mb-0 mr-4 mt-2">Dashboard</h1>
                					</div>
           							<div class="col-lg-1 align-items-end">
           								<button type="button" class="btn btn-profile text-center mt-2" onClick="location.href ='./customer-update.jsp'">
                    						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  												<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  												<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
											</svg> 								
										</button> 
           							</div>
                						
									<div class="col-lg-1 align-items-end">
										<button type="button" class="btn btn-logout text-center mt-2" onClick="location.href ='<%= request.getContextPath() %>/logoutCustomer'">
                    						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-power" viewBox="0 0 16 16">
  												<path d="M7.5 1v7h1V1h-1z"/>
  												<path d="M3 8.812a4.999 4.999 0 0 1 2.578-4.375l-.485-.874A6 6 0 1 0 11 3.616l-.501.865A5 5 0 1 1 3 8.812z"/>
											</svg> 								
										</button> 
									</div>
                				</div>
                    		<div class="row mb-4 px-3">
                    			<div class="twitter text-center mr-3">
                            		<button type="submit" class="btn btn-blue " onclick="location.href ='/gadgetBadget/OrderManagement/order-list.jsp'">Order Management</button>
                        		</div>
                    		</div>
                    		<div class="row mb-4 px-3">
                    			<div class="facebook text-center mr-3 ml-3">
                            		<button type="submit" class="btn btn-blue " onclick="location.href ='/gadgetBadget/FeedbackManagement/feedback-list.jsp'">Feedback Management</button>
                        		</div>
                    		</div>
                  		</div>
                	</div>
            	</div>
        	</div>
        </div>
    </body>
</html>