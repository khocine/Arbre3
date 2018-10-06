<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale  value="en_EN"  />

<fmt:bundle basename="messages.MessagesBundle">
    <html>
        <head>
            <title>Home</title>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="description" content="Sublime project">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
            <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
            <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
            <link rel="stylesheet" type="text/css" href="styles/responsive.css">
            <link href="styles/App.css" rel="stylesheet" type="text/css"/>
            <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"/>

        </head>
        <body>

            <div class="super_container">

                <!-- Header -->



                <!-- Menu -->


                <div class="home">
                    <div class="home_slider_container">

                        <!-- Home Slider -->
                        <div class="owl-carousel owl-theme home_slider">

                            <!-- Slider Item -->
                            <div class="owl-item home_slider_item">
                                <div class="home_slider_background" style="background-image:url(Images/CarrouselImg_3.jpg)"></div>
                                <div class="home_slider_content_container">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col">
                                                <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                    <div class="home_slider_title"><fmt:message key="index.SliderItem_1.Title" /></div>
                                                    <div class="home_slider_subtitle"><fmt:message key="index.SliderItem_1.Subtitle" /></div>
                                                    <div class="button button_light home_button"><a href="Catalog.jsp"><fmt:message key="index.Catalog" /></a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Slider Item -->
                            <div class="owl-item home_slider_item">
                                <div class="home_slider_background" style="background-image:url(Images/CarrouselImg_2.jpg)"></div>
                                <div class="home_slider_content_container">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col">
                                                <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                    <div class="home_slider_title"><fmt:message key="index.SliderItem_2.Title" /></div>
                                                    <div class="home_slider_subtitle"><fmt:message key="index.SliderItem_2.Subtitle" /></div>
                                                    <div class="button button_light home_button"><a href="Catalog.jsp"><fmt:message key="index.Catalog" /></a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Slider Item -->
                            <div class="owl-item home_slider_item">
                                <div class="home_slider_background" style="background-image:url(Images/CarrouselImg_1.jpg)"></div>
                                <div class="home_slider_content_container">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col">
                                                <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                    <div class="home_slider_title"><fmt:message key="index.SliderItem_3.Title" /></div>
                                                    <div class="home_slider_subtitle"><fmt:message key="index.SliderItem_3.Subtitle" /></div>
                                                    <div class="button button_light home_button"><a href="Contact.jsp">Contact</a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <!-- Home Slider Dots -->

                        <div class="home_slider_dots_container">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        <div class="home_slider_dots">
                                            <ul id="home_slider_custom_dots" class="home_slider_custom_dots">
                                                <li class="home_slider_custom_dot active">01.</li>
                                                <li class="home_slider_custom_dot">02.</li>
                                                <li class="home_slider_custom_dot">03.</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>	
                        </div>

                    </div>
                </div>

                <!-- Ads -->

                <div class="avds">
                    <div class="avds_container d-flex flex-lg-row flex-column align-items-start justify-content-between">
                        <div class="avds_small">
                            <div class="avds_background" style="background-image:url(Images/bio.jpg)"></div>
                            <div class="avds_small_inner">
                                <div class="avds_discount_container">
                                    <img src="Images/discount.png" alt="">
                                    <div>
                                        <div class="avds_discount">
                                            <div>100<span>%</span></div>
                                            <div><fmt:message key="index.Ads.Organic" /></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="avds_small_content">
                                    <div class="avds_title"><fmt:message key="index.Ads.OurIngredients" /></div>
                                    <div class="avds_link"><a href="Ingredients.jsp"><fmt:message key="index.Ads.SeeAll" /></a></div>
                                </div>
                            </div>
                        </div>
                        <div class="avds_large">
                            <div class="avds_background" style="background-image:url(Images/Shop.jpg)"></div>
                            <div class="avds_large_container">
                                <div class="avds_large_content">
                                    <div class="avds_title"><fmt:message key="index.Ads.VisitShop_Title" /></div>
                                    <div class="avds_text"><fmt:message key="index.Ads.VisitShop_Text" /></div>
                                    <div class="avds_link avds_link_large"><a href="Contact.jsp"><fmt:message key="index.Ads.ContactUs" /></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Products -->

                <div class="products">
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="product_grid">



                                    <c:forEach varStatus="loop" items="${lastProducts}" var="produit">                 
                                        <form action="Display" name="${produit.codeProduit}" method="post">   

                                            <div class="product"  onClick="document.forms['${produit.codeProduit}'].submit();">
                                                <div class="product_image"><img src="${produit.photoProduit}" alt="xx"></div>
                                                <div class="product_content">
                                                    <input type="hidden" name= "index" value="${produit.codeProduit}">
                                                    <div class="product_title catalog" ><p>${produit.name}</p></div>
                                                    <div class="product_price catalog">$${produit.prixProduit}</div>

                                                </div>
                                            </div>
                                        </form>
                                    </c:forEach>



                                </div>

                            </div>
                        </div>
                    </div>
                </div>


                <!-- Icon Boxes -->
                <div class="icon_boxes">
                    <div class="container">
                        <div class="row icon_box_row">

                            <!-- Icon Box -->
                            <div class="col-lg-4 icon_box_col">
                                <div class="icon_box">
                                    <div class="icon_box_image"><img src="Images/icon_1.svg" alt=""></div>
                                    <div class="icon_box_title"><fmt:message key="index.IconBox_1.Title" /></div>
                                    <div class="icon_box_text">
                                        <p><fmt:message key="index.IconBox_1.Text" /></p>
                                    </div>
                                </div>
                            </div>

                            <!-- Icon Box -->
                            <div class="col-lg-4 icon_box_col">
                                <div class="icon_box">
                                    <div class="icon_box_image"><img src="Images/icon_2.svg" alt=""></div>
                                    <div class="icon_box_title"><fmt:message key="index.IconBox_2.Title" /></div>
                                    <div class="icon_box_text">
                                        <p><fmt:message key="index.IconBox_2.Text" /></p>
                                    </div>
                                </div>
                            </div>

                            <!-- Icon Box -->
                            <div class="col-lg-4 icon_box_col">
                                <div class="icon_box">
                                    <div class="icon_box_image"><img src="Images/icon_3.svg" alt=""></div>
                                    <div class="icon_box_title"><fmt:message key="index.IconBox_3.Title" /></div>
                                    <div class="icon_box_text">
                                        <p><fmt:message key="index.IconBox_3.Text" /></p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>                
                <!-- Newsletter -->

                <div class="newsletter">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="newsletter_border"></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 offset-lg-2">
                                <div class="newsletter_content text-center">
                                    <div class="newsletter_title"><fmt:message key="index.Newsletter.Title" /></div>
                                    <div class="newsletter_text"><p><fmt:message key="index.Newsletter.Text" /></p></div>
                                    <div class="newsletter_form_container">
                                        <form action="#" id="newsletter_form" class="newsletter_form">
                                            <input type="email" class="newsletter_input" required="required">
                                            <button class="newsletter_button trans_200"><span><fmt:message key="index.Newsletter.Subscribe" /></span></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Footer -->

                <jsp:include page="WEB-INF/Footer.jspf"></jsp:include>
                </div>
                <script src="js/jquery-3.2.1.min.js"></script>        
                <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
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

                <script src="js/custom.js"></script>



            </body>
        </html>
</fmt:bundle>