
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Registration</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Sublime project">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="styles/checkout.css">
        <link rel="stylesheet" type="text/css" href="styles/checkout_responsive.css">
        <link href="styles/App.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="super_container">



            <!-- Home -->

            <div class="home">
                <div class="home_container">
                    <div class="home_background" style="background-image:url(Images/Head2.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>Register</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Registration -->

            <form action="User" name="registration_form" id="registration_form" class="checkout_form">    
                <div class="checkout">
                    <div class="container">
                        <div class="row">

            <!--Billing Info -->
                            <div class="col-lg-6">
                                <div class="billing checkout_section">
                                    <div class="section_title">Register Information</div>
                                    <p class="message_error">${requestScope.errorRegistration}</p>
                                    <div class="section_subtitle">Enter your register info</div>
                                    <div class="checkout_form_container">
                                        <div class="col-xl-6 title_left">
                                                 Title 
                                                <label>Title</label>
                                                <select name="title" id="checkout_country" class="dropdown_item_select checkout_input">
                                                    <option></option>
                                                    <option>Mme</option>
                                                    <option>Miss</option>
                                                    <option>Mr.</option>
                                                </select>
                                        </div>                                   
                                            <div >
                                                 Name 
                                                <label>First Name*</label>
                                                <input type="text" name="name" class="checkout_input" required="required">
                                            </div>
                                            <div >
                                                 Last Name 
                                                <label>Last Name*</label>
                                                <input type="text" name="last_name" class="checkout_input" required="required">
                                            </div>

                                        <div>
                                             Email 
                                            <label>Email Address*</label>
                                            <input type="email" name="email" class="checkout_input" required="required">
                                        </div>
                                        <div>
                                             Password 
                                            <label>Create Password</label>
                                            <input type="password" name="password" class="checkout_input" required="required">
                                        </div>
                                       
                                        <div class="checkout_extra">
                                            <div>
                                                <input type="checkbox" id="checkbox_terms" name="regular_checkbox" class="regular_checkbox" checked="checked">
                                                <label><img src="images/check.png" alt=""></label>
                                                <span class="checkbox_title">Terms and conditions</span>
                                            </div>                                            
                                           


                                        </div>

                                    </div>
                                </div>
                            </div>

                        <!--Picture Lavande1 -->

                            <div class="col-lg-6">
                                <div class="billing checkout_section">
                                    <div class="section_title register_img">
                                        <div>
                                            <img src="Images/register.jpg">
                                          
                                            <div class=" order_button button register" onclick="document.forms['registration_form'].submit();"><a href="" onclick="return false;">Register</a></div>
                                        </div>

                                    </div>
                                </div>   
                            </div>
                        </div>
                    </div>
                </div>

                       <input type="hidden" name="registration" value="registration">               
            </form>  
        </div>

        <script src="js/jquery-3.2.1.min.js"></script>
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

