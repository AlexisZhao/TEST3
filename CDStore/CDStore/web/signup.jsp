<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Accelerated CD Store</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
         <script type="text/javascript" src="js/gen_validatorv4.js"></script>
    </head>
    <body>
        <div class="border">
            <div id="bg">
                background
            </div>
            <div class="page">
                <div class="sidebar">
                    <a href="index.html" id="logo"><img src="images/logo.png" alt="logo"></a>
                    <ul>
                        <li class="selected">
                            <a href="./ProductCatalog">CD Store</a>
                        </li>
                        <li>
                            <a href="./OrderProcess?service=getAccountInfo">Account Info</a>
                        </li>
                        <li>
                            <a href="./OrderProcess?service=getOrders">My Orders</a>
                        </li>

                    </ul>

                    <div class="connect">
                        <a href="#" id="facebook">facebook</a> <a href="#" id="twitter">twitter</a> <a href="#" id="googleplus">youtube</a>
                    </div>
                    <p>
                        Copyright 2013
                    </p>
                    <p>
                        Accelerated CD Store
                    </p>
                </div>
                <div class="body">
                    <div class="contact">
                        <h2>Sign Up</h2>
                        <div class="portfolio">
                            <ul class="navigation">
                                <li>
                                    <a href="signin.jsp">Already Have An Account?</a>
                                </li>
                            </ul>
                        </div> 
                        <p>
                            You must have an account to proceed!
                        </p>
                        <form name="signupform" action="./OrderProcess?service=signup" method="post">
                            <label for="name">Account Name</label>
                            <input type="text" id="name" name="name">
                            <label for="fname">First Name</label>
                            <input type="text" id="fname" name="fname">
                            <label for="lanme">Last Name</label>
                            <input type="text" id="lname" name="lname">
                            <label for="password">Password</label>
                            <input type="text" id="password" name="password">
                            <label for="payment">Credit Card</label>
                            <input type="text" id="payment" name="payment">
                            <label for="street">Street</label>
                            <input type="text" id="street" name="street">
                            <label for="city">City</label>
                            <input type="text" id="city" name="city">
                            <label for="province">Province</label>
                            <input type="text" id="province" name="province">
                            <label for="zip">Zip</label>
                            <input type="text" id="zip" name="zip">
                            <label for="phone">Phone</label>
                            <input type="text" id="phone" name="phone">
                            <input type="submit" id="submit2" value="">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <!-- ####################################################################################################### -->
    <script type='text/javascript'>
        // <![CDATA[

        var frmvalidator = new Validator("signupform");
        frmvalidator.EnableMsgsTogether();
        frmvalidator.addValidation("name", "req", "Please provide your account name!");
        frmvalidator.addValidation("password", "req", "Please provide your password!");
        frmvalidator.addValidation("payment", "req", "Please provide your payment!");
        frmvalidator.addValidation("street", "req", "Please provide your street!");
        frmvalidator.addValidation("city", "req", "Please provide your city!");
        frmvalidator.addValidation("province", "req", "Please provide your province!")
        
        // ]]>
    </script>
</html>