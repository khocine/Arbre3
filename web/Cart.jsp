<%-- 
    Document   : Cart
    Created on : Sep 9, 2018, 4:04:29 PM
    Author     : pc
--%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/app.js" type="text/javascript"></script>
</head>
<body>

<div class="super_container">

	<!-- Header -->

	
	
	<!-- Home -->

	<div class="home">
		<div class="home_container">
			<div class="home_background" style="background-image:url(Images/Head.jpg)"></div>
			<div class="home_content_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content">
								<div class="breadcrumbs">
									<ul>
										<li><a href="index.html">Home</a></li>
									
										<li>Shopping Cart</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Cart Info -->

	<div class="cart_info">
		<div class="container">
			<div class="row">
				<div class="col">
					<!-- Column Titles -->
					<div class="cart_info_columns clearfix">
						<div class="cart_info_col cart_info_col_product">Produit</div>
						<div class="cart_info_col cart_info_col_price">Prix</div>
						<div class="cart_info_col cart_info_col_quantity">Quantité</div>
						<div class="cart_info_col cart_info_col_total">Total</div>
					</div>
				</div>
			</div>
                     <form action="Commande" id="Cart" method="post"> 
			<div class="row cart_items_row">
                           
				<div class="col">

					<!-- Cart Item -->
                                        <c:forEach varStatus="loop" items="${gs.cart.myCart}" var="ligne">  
                                            
					<div class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
						<!-- Name -->
						<div class="cart_item_product d-flex flex-row align-items-center justify-content-start">
							<div class="cart_item_image">
								<div><img src="${ligne.produits.photoProduit}" alt=""></div>
							</div>
							<div class="cart_item_name_container">
								<div class="cart_item_name"><a href="#">${ligne.produits.name}</a></div>
								<div class="cart_item_edit"><a href="#">${ligne.produits.artisans.nomArtisan}</a></div>
							</div>
						</div>
						<!-- Price -->
						<div class="cart_item_price">$ ${ligne.produits.prixProduit}</div>
						<!-- Quantity -->
                                               
						<div class="cart_item_quantity">
							<div class="product_quantity_container">
								<div class="product_quantity clearfix">
									<span>Qty</span>
									<input id="quantity_input" class="quantity_input" name="${ligne.produits.codeProduit}" type="text" pattern="[0-9]*" value="${ligne.quantite}">
									<div class="quantity_buttons">
										<div id="quantity_inc_button" class="quantity_inc quantity_control quantity_inc_button"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
										<div id="quantity_dec_button" class="quantity_dec quantity_control quantity_dec_button"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
									</div>
								</div>
							</div>
						</div>
						<!-- Total -->
						<div class="cart_item_total">$ ${ligne.totalLigne}</div>
					</div>
                                            </c:forEach>
				</div>
			</div>
			<div class="row row_cart_buttons">
				<div class="col">
					<div class="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
						<div class="button continue_shopping_button"><a href="Catalog.jsp">Continue shopping</a></div>
						<div class="cart_buttons_right ml-lg-auto">
                                                    <div class="button clear_cart_button" onclick="clearCart()"><a href="" onclick="return false;">Clear cart</a></div>
                                                    <div class="button update_cart_button" onclick="updateCart()"><a href="#" onclick="return false;">Update cart</a></div>
                                                    <input type="hidden" id = "action" name ="action" value=""/>
						</div>
					</div>
				</div>
			</div>
                    
			<div class="row row_extra">
				<div class="col-lg-4">
					
					<!-- Delivery -->
					<div class="delivery">
						<div class="section_title">Shipping method</div>
						<div class="section_subtitle">Select the one you want</div>
						<div class="delivery_options">
                                                    <label class="delivery_option clearfix" >Next day delivery
								<input type="radio" name="radio" value="${nextDayDelivery}" onclick="calculTotal()">
								<span class="checkmark" id ="nextDayDelivery"  ></span>
								<span class="delivery_price">$ ${nextDayDelivery}</span>
							</label>
							<label class="delivery_option clearfix">Standard delivery
								<input type="radio" name="radio" value="${standardDelivery}" onclick="calculTotal()">
								<span class="checkmark" id="standardDelivery"  ></span>
								<span class="delivery_price">$ ${standardDelivery}</span>
							</label>
							<label class="delivery_option clearfix" >Personal pickup
								<input type="radio" checked="checked" name="radio" onclick="calculTotal()" value="0">
								<span class="checkmark"></span>
								<span class="delivery_price">Free</span>
							</label>
						</div>
					</div>

					
				</div>

				<div class="col-lg-6 offset-lg-2">
					<div class="cart_total">
						<div class="section_title">Cart total</div>
						<div class="section_subtitle">Final info</div>
						<div class="cart_total_container">
							<ul>
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="cart_total_title">Subtotal</div>
									<div class="cart_total_value ml-auto" id="subTotal">${total}</div>
								</li>
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="cart_total_title">Livraison</div>
									<div class="cart_total_value ml-auto" id="Delivery">Free</div>
								</li>
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="cart_total_title">Total TTC</div>
                                                                        <div class="cart_total_value ml-auto" id="totalTTC">${totalTTC}</div>
                                                                        <input type="hidden" id="initialTTC" value="${totalTTC}">
								</li>
							</ul>
						</div>
						<div class="button checkout_button" onclick="checkout()"><a href="#" onclick="return false;">Proceed to checkout</a></div>
                                                <input type="hidden" id="delivery_price" name="delivery_price" value="0"/>
					</div>
				</div>
			</div>
                                                                </form>
		</div>		
	</div>

	<!-- Footer -->
	<jsp:include page="WEB-INF/Footer.jspf"></jsp:include>
	


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
<script src="js/cart.js"></script>
</body>
</html>