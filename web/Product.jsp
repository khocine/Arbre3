<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
<title>Product</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/product.css">
<link rel="stylesheet" type="text/css" href="styles/product_responsive.css">
</head>
<body>

<div class="super_container">

	<!-- Header -->

	

	
	
	<!-- Home -->

	<div class="home">
		<div class="home_container">
			<div class="home_background" style="background-image:url(Images/Product.jpg)"></div>
			<div class="home_content_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content">
								<div class="home_title">La douceur en savon<span>.</span></div>
								<div class="home_text"><p>Tout nos produits sont 100% biologique.</p></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Product Details -->

	<div class="product_details">
		<div class="container">
			<div class="row details_row">

				<!-- Product Image -->
				<div class="col-lg-6">
					<div class="details_image">
						<div class="details_image_large"><img src="${currentProduct.photoProduit}" alt=""><div class="product_extra product_new"><a href="categories.html">wow</a></div></div>
						<div class="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
							
						</div>
					</div>
				</div>

				<!-- Product Content -->
				<div class="col-lg-6">
					<div class="details_content">
						<div class="details_name">${currentProduct.name}</div>
						
						<div class="details_price">${currentProduct.prixProduit} $</div>

						<!-- In Stock -->
						<div class="in_stock_container">
							<div class="availability">Disponibilité:</div>
							<span>${currentProduct.qtyProduit>100 ? 'En Stock':'Rupture de stock' }</span>
						</div>
						<div class="details_text">
							<p>${currentProduct.description}</p>
						</div>

						<!-- Product Quantity -->
						
                                                
                                                <form action="Commande" name="addToCart" method="post"> 
                                        <div class="product_quantity_container">
							<div class="product_quantity clearfix">
								<span>Qty</span>
								<input id="quantity_input" name="quantity_input" type="text" pattern="[0-9]*" value="1">
                                                                <input name="codeProduct_input" type="hidden" value="${currentProduct.codeProduit}">
								<div class="quantity_buttons">
									<div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
									<div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
								</div>
							</div>
                                                                <div class="button cart_button" onClick="document.forms['addToCart'].submit();"><a href="#" onclick="return false;">Add to cart</a></div>
						</div>
                                    </form>
                                                
						<!-- Share -->
						<div class="details_share">
							<span>Share:</span>
							<ul>
								<li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="row description_row">
				<div class="col">
					<div class="description_title_container">
						<div class="description_title">Ingrédients</div>
						
					</div>
					<div class="description_text">
                                            <ul>
                                             <c:forEach varStatus="loop" items="${currentProduct.ingredientses}" var="ingredient">  
						<li>    - ${ingredient.nomIngredient}</li>
                                                </c:forEach> 
                                                </ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Products -->

	<div class="products">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<div class="products_title">Produits qui peuvent vous intéresser</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					
					<div class="product_grid">

                                            <c:forEach varStatus="loop" items="${randomProduct}" var="produit">                 
                                    <form action="Display" name="${produit.codeProduit}" method="post">  
						<!-- Product -->
						<div class="product" onClick="document.forms['${produit.codeProduit}'].submit();">
                                                    <div class="product_image"><img src="${produit.photoProduit}" alt="xx"></div>
                                            <div class="product_content">
                                                <input type="hidden" name= "index" value="${produit.codeProduit}">
                                                <div class="product_title catalog" ><p>${produit.name}</p></div>
                                                <div class="product_price catalog">$${produit.prixProduit}</div>
							</div>
						</div>
                                                <input type="hidden" name= "index" value="${produit.codeProduit}">
                                                </form>
                                </c:forEach>

<!--						 Product 
						<div class="product">
							<div class="product_image"><img src="Images/product_2.jpg" alt=""></div>
							
							<div class="product_content">
								<div class="product_title"><a href="product.html">Smart Phone</a></div>
								<div class="product_price">$520</div>
							</div>
						</div>

						 Product 
						<div class="product">
							<div class="product_image"><img src="Images/product_3.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_title"><a href="product.html">Smart Phone</a></div>
								<div class="product_price">$710</div>
							</div>
						</div>

						 Product 
						<div class="product">
							<div class="product_image"><img src="Images/product_4.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_title"><a href="product.html">Smart Phone</a></div>
								<div class="product_price">$330</div>
							</div>
						</div>-->

					</div>
				</div>
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
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/product.js"></script>
</body>
</html>