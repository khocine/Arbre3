<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:bundle basename="messages.MessagesBundle">
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/checkout.css">
<link rel="stylesheet" type="text/css" href="styles/checkout_responsive.css">
<script src="js/app.js" type="text/javascript"></script>
</head>
<body>

<div class="super_container">

	<!-- Header -->

	
	
	<!-- Home -->

	<div class="home">
		<div class="home_container">
			<div class="home_background" style="background-image:url(Images/Head1.jpg)"></div>
			<div class="home_content_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content">
								<div class="breadcrumbs">
									<ul>
                                                                                <!--Home-->
										<li><a href="index.html"><fmt:message key="header.Home" /></a></li>
                                                                                <!--Checkout-->
										<li><fmt:message key="header.Checkout" /></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Checkout -->
	
	<div class="checkout">
		<div class="container">
			<div class="row">
                                <div class="col-lg-6" id = "form"  style="display:none; margin-top: 150px">
				<!-- Billing Info --><form action="User" name="login-form" id="login-form" class="checkout_form" >   
				
                                <div class="billing checkout_section">
                                    <!--Login Information-->
                                    <div class="section_title"><fmt:message key="checkout.Title" />
                                        <p class="message_error" style="color:red">${requestScope.errorLogin}</p>
                                    </div>                                    
                                    <div class="checkout_form_container">
                                        <div>
                                            <!-- Email -->
                                            <label><fmt:message key="login.Email" /></label>
                                            <input type="email" name="email" class="checkout_input" required="required">
                                        </div>
                                        <div>
                                            <!-- Password -->
                                            <label><fmt:message key="login.Password" /></label>
                                            <input type="password" name="password" class="checkout_input" required="required">
                                        </div>
                                        <div class="section_title">
                                        <div>         
                                            <input type="hidden" name="connexion" class="checkout_input" value="toConnect">
                                            <div class=" order_button button register" onclick="document.forms['login-form'].submit();"><a href="" onclick="return false;"><fmt:message key="header.Login" /></a></div>
                                        </div>
                                    </div>
                                        <div class="checkout_form_container section_title">
                                            <p><a href="Registration.jsp"><fmt:message key="login.NotMemeber" /></a>  </p>                                      
                                        </div> 
                                    </div>
                                </div>
                             
                                </form>
                                    </div> 
				<!-- Order Info -->

				<div class="col-lg-6" id ="resume">
					<div class="order checkout_section">
                                                <!--Your order-->
						<div class="section_title"><fmt:message key="checkout.Order.Title" /></div>
                                                <!--Order details-->
						<div class="section_subtitle"><fmt:message key="checkout.Order.Subtitle" /></div>

						<!-- Order details -->
						<div class="order_list_container">
							<div class="order_list_bar d-flex flex-row align-items-center justify-content-start">
                                                            <!--Product-->
								<div class="order_list_title"><fmt:message key="checkout.Order.Product" /></div>
                                                                <!--Total-->
								<div class="order_list_value ml-auto"><fmt:message key="checkout.Order.Total" /></div>
							</div>
                                                    
							<ul class="order_list">
                                                            <c:forEach varStatus="loop" items="${gs.cart.myCart}" var="ligne">  
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="order_list_title">${ligne.produits.name} X ${ligne.quantite} </div>
									<div class="order_list_value ml-auto">$  ${ligne.totalLigne}</div>
								</li>
                                                                </c:forEach>
								<li class="d-flex flex-row align-items-center justify-content-start">
                                                                        <!--Subtotal-->
									<div class="order_list_title"><fmt:message key="checkout.Order.Subtotal" /></div>
									<div class="order_list_value ml-auto">$ ${total}</div>
								</li>
								<li class="d-flex flex-row align-items-center justify-content-start">
                                                                        <!--Shipping-->
									<div class="order_list_title"><fmt:message key="checkout.Order.Shipping" /></div>
									<div class="order_list_value ml-auto" >${delivery_price}</div>
								</li>
								<li class="d-flex flex-row align-items-center justify-content-start">
                                                                        <!--Total TTC-->
									<div class="order_list_title"><fmt:message key="cart.Total.TTC" /></div>
									<div class="order_list_value ml-auto">$ ${totalTTC_Shipping}</div>
								</li>
							</ul>
						</div>
                                                             
						<!-- Payment Options -->
						<div class="payment">
							<div class="payment_options">
                                                                <!--Paypal-->
								<label class="payment_option clearfix"><fmt:message key="checkout.PaymentOptions_1" />
									<input type="radio" name="radio">
									<span class="checkmark"></span>
								</label>
                                                                <!--Cach on delivery-->
								<label class="payment_option clearfix"><fmt:message key="checkout.PaymentOptions_2" />
									<input type="radio" name="radio">
									<span class="checkmark"></span>
								</label>
                                                                <!--Credit card-->
								<label class="payment_option clearfix"><fmt:message key="checkout.PaymentOptions_3" />
									<input type="radio" name="radio">
									<span class="checkmark"></span>
								</label>
                                                                <!--Direct bank transfer-->
								<label class="payment_option clearfix"><fmt:message key="checkout.PaymentOptions_4" />
									<input type="radio" checked="checked" name="radio">
									<span class="checkmark"></span>
								</label>
							</div>
						</div>

						<!-- Place Order -->
						<div class="button order_button" onclick="placeOrder()"><a href="#" onclick="return false;"><fmt:message key="checkout.PlaceOrder" /></a></div>
                                                <input type="hidden" id="connected" value="${connected}"/>             
					</div>
				</div>
                                                                
                                                                
                                    <!-- picture order -->                            
                                <div class="col-lg-6" id="imgDelivery" style="display: inline">
					<div class="details_image">
						<div class="details_image_large"><img src="Images/delivery.jpg" alt=""></div>
						
					</div>
				</div>
                                    
                                   
                                                                
                                     <div class="col-3"></div>                           
                                 <div class="col-lg-6 " id ="success" style="display: none;padding-bottom: 200px">
                                        <div class="section_title"><fmt:message key="checkout.Confirmation.Title" /></div>
						<div class="section_subtitle"><fmt:message key="checkout.Confirmation.Subtitle" /></div>
                                                <div class="details_image">
						<div class="details_image"><img src="Images/thanks.jpg" alt=""></div>
						
					</div>
					</div>    
                                    <div class="col-3"></div>
                                                                
			</div>
		</div>
                                        
	</div>
                                         

	<!-- Footer -->
	
	 <jsp:include page="WEB-INF/Footer.jspf"></jsp:include>
	
</div>

<script src="js/jquery-3.2.1.min.js"></script>
 <script src="js/jquery.autocomplete.min.js" type="text/javascript"></script>
        <script src="js/productautocomplete.js" type="text/javascript"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/checkout.js"></script>
</body>
</html>
</fmt:bundle>