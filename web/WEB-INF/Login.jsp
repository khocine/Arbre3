<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
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


            <!-- Registration -->

            <form action="User" name="login-form" id="login-form" class="checkout_form" >    
                <div class="checkout">
                    <div class="container">
                        <div class="row" >

                            <!-- Login Info -->
                            <div class="col-3"></div>
                            <div class="col-lg-6" >
                                <div class="billing checkout_section">
                                    <div class="section_title">Login Information
                                        <p class="message_error" style="color:red">${requestScope.errorLogin}</p>
                                    </div>                                    
                                    <div class="checkout_form_container">
                                        <div>
                                            <!-- Email -->
                                            <label>Email</label>
                                            <input type="email" name="email" class="checkout_input" required="required">
                                        </div>
                                        <div>
                                            <!-- Password -->
                                            <label>Password</label>
                                            <input type="password" name="password" class="checkout_input" required="required">
                                        </div>
                                        <div class="section_title">
                                        <div>         
                                            <input type="hidden" name="connexion" class="checkout_input" value="toConnect">
                                            <div class=" order_button button register" onclick="document.forms['login-form'].submit();"><a href="" onclick="return false;">Login</a></div>
                                        </div>
                                    </div>
                                        <div class="checkout_form_container section_title">
                                            <p><a href="Registration.jsp">Not a member ? Register here...</a>  </p>                                      
                                        </div> 
                                    </div>
                                </div>
                            </div>  
                            <div class="col-3"></div>
                        </div>
                    </div>
                </div>

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