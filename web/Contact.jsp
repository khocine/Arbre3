<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale  value="fr_FR"  />

<fmt:bundle basename="messages.MessagesBundle">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/contact.css">
<link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">
</head>
<body>

<div class="super_container">

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
                                                                                <!--Home-->
										<li><a href="index.jsp"><fmt:message key="header.Home" /></a></li>
                                                                                <!--Contact-->
										<li><fmt:message key="header.Contact" /></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
                                                                        
	<!-- Contact -->
	
	<div class="contact">
		<div class="container">
			<div class="row">

				<!-- Get in touch -->
				<div class="col-lg-8 contact_col">
					<div class="get_in_touch">
                                                <!--BIENVENUE-->
						<div class="section_title"><fmt:message key="contact.Contact.Title" /></div>						
						<div class="contact_form_container">
							<form action="#" id="contact_form" class="contact_form">
								<div class="row">
									<div class="col-xl-6">
										<!-- Name -->
										<label for="contact_name"><fmt:message key="contact.Contact.Name" /></label>
										<input type="text" id="contact_name" class="contact_input" required="required">
									</div>
									<div class="col-xl-6 last_name_col">
										<!-- Last Name -->
										<label for="contact_last_name"><fmt:message key="contact.Contact.LastName" /></label>
										<input type="text" id="contact_last_name" class="contact_input" required="required">
									</div>
								</div>
								<div>
									<!-- Subject -->
									<label for="contact_company"><fmt:message key="contact.Contact.Subject" /></label>
									<input type="text" id="contact_company" class="contact_input">
								</div>
								<div>
                                                                        <!--Message-->
									<label for="contact_textarea"><fmt:message key="contact.Contact.Message" /></label>
									<textarea id="contact_textarea" class="contact_input contact_textarea" required="required"></textarea>
								</div>
                                                                 <!--Send message-->
								<button class="button contact_button"><span><fmt:message key="contact.Contact.Send" /></span></button>
							</form>
						</div>
					</div>
				</div>

				<!-- Contact Info -->
				<div class="col-lg-3 offset-xl-1 contact_col">
					<div class="contact_info">
						<div class="contact_info_section">
                                                        <!--Corporate service-->
							<div class="contact_info_title"><fmt:message key="contact.Contact.Corporate" /></div>
							<ul>
                                                                <!--Phone + PhoneNumber-->
								<li><fmt:message key="contact.Contact.Phone" /> <span><fmt:message key="contact.Contact.PhoneNumber" /></span></li>
								<!--Email-->
                                                                <li><fmt:message key="contact.Mail" /> <span><fmt:message key="contact.Mail.B2B" /></span></li>
							</ul>
						</div>
						<div class="contact_info_section">
                                                        <!--Deliveries and returns-->
							<div class="contact_info_title"><fmt:message key="contact.Contact.Delivery" /></div>
							<ul>
                                                                <!--Phone + PhoneNumber-->
								<li><fmt:message key="contact.Contact.Phone" /> <span><fmt:message key="contact.Contact.PhoneNumber" /></span></li>
								<!--Email-->
                                                                <li><fmt:message key="contact.Mail" /> <span><fmt:message key="contact.Mail.Delivery" /></span></li>
							</ul>
						</div>
						<div class="contact_info_section">
                                                        <!--General informations-->
							<div class="contact_info_title"><fmt:message key="contact.Contact.Infos" /></div>
							<ul>
                                                                <!--Phone + PhoneNumber-->
								<li><fmt:message key="contact.Contact.Phone" /> <span><fmt:message key="contact.Contact.PhoneNumber" /></span></li>
								<!--Email-->
                                                                <li><fmt:message key="contact.Mail" /> <span><fmt:message key="contact.Mail.Client" /></span></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row map_row">
				<div class="col">

					<!-- Google Map -->
					<div class="map">
						<div id="google_map" class="google_map">
							<div class="map_container">
								<div id="map"></div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<jsp:include page="WEB-INF/Footer.jspf"></jsp:include>
</div>

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
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>
<script src="js/contact.js"></script>
</body>
</html>
</fmt:bundle>