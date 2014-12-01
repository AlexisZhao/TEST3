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
                        <h2>Sign In</h2>
                        
                        <form name="signinform" action="./OrderProcess?service=signin" method="post">
                            <label for="name">Account Name</label>
                            <input type="text" id="name" name="name">

                            <label for="password">Password</label>
                            <input type="text" id="password" name="password">
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

        var frmvalidator = new Validator("signinform");
        frmvalidator.EnableMsgsTogether();
        frmvalidator.addValidation("name", "req", "Please provide your account name!");
        frmvalidator.addValidation("password", "req", "Please provide your password!");
        // ]]>
    </script>
</html>