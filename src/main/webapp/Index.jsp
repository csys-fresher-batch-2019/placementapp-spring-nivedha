<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="scss/main.css">
    <link rel="stylesheet" href="scss/skin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="./script/index.js"></script>
</head>

<body id="wrapper">
    <section id="top-header">
        <div class="container">
            <div class="row">
                <div class="col-md-7 col-sm-7 col-xs-7 top-header-links">
                    <ul class="contact_links">
                        <li><i class="fa fa-phone"></i><a href="#">+91 847 594 5080</a></li>
                        <li><i class="fa fa-envelope"></i><a href="#">passionsoftware.in</a></li>
                    </ul>
                </div>
                <div class="col-md-5 col-sm-5 col-xs-5 social">
                    <ul class="social_links">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#"><i class="fa fa-skype"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        </div>

    </section>

    <header>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
                        <a class="navbar-brand" href="#">
                            <h1>Passion</h1><span>Software Solutions</span></a>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse navbar-right">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">HOME</a></li>
                            <li><a href="HomeCourse.jsp">COURSE</a></li>
                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">CAREER <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="CompanyDetailsServ">COMPANY DETAILS</a></li>
          <li><a href="InterviewScheduleServ">INTERVIEW SCHEDULE</a></li>
          <li><a href="ViewInterviewStatusServ">INTERVIEW STATUS</a></li>
        </ul>
      </li>
                            <li><a href="TrainerDetailsServ">TRAINER</a></li>
                            <li><a href="Login.jsp">SIGN IN</a></li>
                            <li><a href="Register.jsp">SIGN UP</a></li>
                            <li><a href="Logout.jsp">SIGN OUT</a></li>
                            <li><a href="AdminLogin.html">ADMIN</a></li>
                            
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </nav>
    </header>
    <!--/.nav-ends -->

    <div id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('img/banner-slide-1.jpg');"></div>
                <div class="carousel-caption slide-up">
                    <h1 class="banner_heading">PROVIDING THE <span>BEST & MOST </span>PRACTICAL TRAINING SESSIONS</h1>
                    <h3 p class="banner_txt">Real Life Examples and Live Project Along with Practical Session</p></h3>
                    <div class="slider_btn">
                        <button type="button" class="btn btn-default slide">Learn More <i class="fa fa-caret-right"></i></button>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="fill" style="background-image:url('img/banner-slide-2.jpg');"></div>
                <div class="carousel-caption slide-up">
                    <h1 class="banner_heading">POST-COURSE SUPPORT FOR <span>LIFE TIME </span></h1>
                    <h3 p class="banner_txt">18/7 WhatsApp support for students, even after course completion.</p></h3>
                    <div class="slider_btn">
                        <button type="button" class="btn btn-default slide">Learn More <i class="fa fa-caret-right"></i></button>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="fill" style="background-image:url('img/banner-slide-3.jpg');"></div>
                <div class="carousel-caption slide-up">
                    <h1 class="banner_heading"><span>Placement Assistance</span> and<span> Mock Interviews</span></h1>
                    <h3 p class="banner_txt">Personalized placement assistance and one-on-one mock interview sessions.</p></h3>
                    <div class="slider_btn">
                        <button type="button" class="btn btn-default slide">Learn More <i class="fa fa-caret-right"></i></button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Left and right controls -->

        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> <i class="fa fa-angle-left" aria-hidden="true"></i>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> <i class="fa fa-angle-right" aria-hidden="true"></i>
            <span class="sr-only">Next</span>
        </a>

    </div>

    <section id="features">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-12 block">
                    <div class="col-md-2 col-xs-2"><i class="fa fa-laptop feature_icon"></i></div>
                    <div class="col-md-10 col-xs-10">
                        <h4>100% Responsive</h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                        
                        <a href="#" class="readmore">Read More <i class="fa fa-caret-right"></i></a>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12 block">
                    <div class="col-md-2 col-xs-2"><i class="fa fa-bullhorn feature_icon"></i></div>
                    <div class="col-md-10 col-xs-10">
                        <h4>Powerful Features</h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                        <a href="#" class="readmore">Read More <i class="fa fa-caret-right"></i></a>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12 block">
                    <div class="col-md-2 col-xs-2"><i class="fa fa-support feature_icon"></i></div>
                    <div class="col-md-10 col-xs-10">
                        <h4>Customer Support</h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                        <a href="#" class="readmore">Read More <i class="fa fa-caret-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section id="about">
        <div class="image-holder col-lg-6 col-md-6 col-sm-6 col-xs-12 pull-left">
            <div class="background-imgholder">
                <img src="img/1.jpg" alt="about" class="img-responsive" style="display:none;" />
            </div>
        </div>

        <div class="container-fluid">

            <div class="col-md-7 col-md-offset-5 col-sm-8 col-sm-offset-2 col-xs-12 text-inner ">
                <div class="text-block">
                    <div class="section-heading">
                        <h1>ABOUT <span>US</span></h1>
                        <p class="subheading">Real Life Examples and Live Project Along with Practical Session</p>

                    </div>

                   

                    <button type="button" class="btn btn-primary slide">Learn More  <i class="fa fa-caret-right"></i> </button>


                </div>
            </div>
        </div>
    </section>


    <section id="process">
        <div class="container">
            <div class="section-heading text-center">
                <div class="col-md-12 col-xs-12">
                    <h1>What <span>We Do</span></h1>
                    <p class="subheading">Real Life Examples and Live Project Along with Practical Session</p>

                </div>
            </div>

            <div class="row">
                <div class="col-md-3 col-sm-6 block process-block">
                    <div class="process-icon-holder">
                        <div class="process-border">
                            <span class="process-icon"><a href="#"><i class="fa fa-lightbulb-o feature_icon"></i></a></span></div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="process-text-block">
                        <h4><a href="#">Idea</a></h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 block process-block">
                    <div class="process-icon-holder">
                        <div class="process-border">
                            <span class="process-icon"><a href="#"><i class="fa fa-cloud-download feature_icon"></i></a></span></div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="process-text-block">
                        <h4><a href="#">Concept</a></h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 block process-block">
                    <div class="process-icon-holder">
                        <div class="process-border">
                            <span class="process-icon"><a href="#"><i class="fa fa-magic feature_icon"></i></a></span></div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="process-text-block">
                        <h4><a href="#">Design</a></h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 block process-block lastchild">
                    <div class="process-icon-holder">
                        <div class="process-border">
                            <span class="process-icon"><a href="#"><i class="fa fa-cog feature_icon"></i></a></span></div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="process-text-block">
                        <h4><a href="#">Develop</a></h4>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                </div>
            </div>

        </div>
    </section>


    <section id="testimonial">
        <div class="container">
            <div class="section-heading text-center">
                <div class="col-md-12 col-xs-12">
                    <h1>What Our <span>Client Says</span></h1>
                    <p class="subheading">Real Life Examples and Live Project Along with Practical Session</p>

                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-sm-12 block ">
                    <div class="testimonial_box">
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                    <div class="arrow-down"></div>
                    <div class="testimonial_user">
                        <div class="user-image"><img src="img/user1.png" alt="user" class="img-responsive" /></div>
                        <div class="user-info">
                           
                            <p>Manager</p>
                        </div>
                    </div>
                </div>


                <div class="col-md-4 col-sm-12 block">
                    <div class="testimonial_box">
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                    <div class="arrow-down"></div>
                    <div class="testimonial_user">
                        <div class="user-image"><img src="img/user1.png" alt="user" class="img-responsive" /></div>
                        <div class="user-info">
                            <p>Manager</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-12 block">
                    <div class="testimonial_box">
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                    </div>
                    <div class="arrow-down"></div>
                    <div class="testimonial_user">
                        <div class="user-image"><img src="img/user1.png" alt="user" class="img-responsive" /></div>
                        <div class="user-info">
                            <p>Manager</p>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </section>





    <section id="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-3 col-xs-12 block">
                    <div class="footer-block">
                        <h4>Address</h4>
                        <hr/>
                                            <p>Real Life Examples and Live Project Along with Practical Session</p>
                        </p>
                        <a href="#" class="learnmore">Learn More <i class="fa fa-caret-right"></i></a>
                    </div>
                </div>

                <div class="col-md-3 col-sm-3 col-xs-12 block">
                    <div class="footer-block">
                        <h4>Useful Links</h4>
                        <hr/>
                        <ul class="footer-links">
                            <li><a href="#">HOME</a></li>
                            <li><a href="#">COURSE</a></li>
                            <li><a href="#">CAREER</a></li>
                            <li><a href="#">TRAINER</a></li>
                            <li><a href="#">SIGN IN</a></li>
                            <li><a href="#">SIGN UP</a></li>
                        </ul>
                    </div>
                </div>

                

                <div class="col-md-3 col-sm-3 col-xs-12 <block></block>">
                    <div class="footer-block">
                        <h4>Recent Posts</h4>
                        <hr/>
                        <ul class="footer-links">
                            <li>
                                <a href="#" class="post">Real Life Examples and Live Project Along with Practical Session</a>
                                <p class="post-date">Feb 25, 2020</p>
                            </li>
                            <li>
                                <a href="#" class="post">Real Life Examples and Live Project Along with Practical Session
                                </a>
                                <p class="post-date">Feb 25, 2020</p>
                            </li>
                            <li>
                                <a href="#" class="post">Real Life Examples and Live Project Along with Practical Session</p>
</a>
                                <p class="post-date">Feb 25, 2020</p>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>


    </section>

    <section id="bottom-footer">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12 btm-footer-links">
                    <a href="#">Privacy Policy</a>
                    <a href="#">Terms of Use</a>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 copyright">
                    Developed by <a href="#">Passion Software Solutions</a> designed by <a href="#">Designing Team</a>
                </div>
            </div>
        </div>
    </section>

    <div id="panel">
        <div id="panel-admin">
            <div class="panel-admin-box">
                <div id="tootlbar_colors">
                    <button class="color" style="background-color:#1abac8;" onclick="mytheme(0)"></button>
                    <button class="color" style="background-color:#ff8a00;" onclick="mytheme(1)"> </button>
                    <button class="color" style="background-color:#b4de50;" onclick="mytheme(2)"> </button>
                    <button class="color" style="background-color:#e54e53;" onclick="mytheme(3)"> </button>
                    <button class="color" style="background-color:#1abc9c;" onclick="mytheme(4)"> </button>
                    <button class="color" style="background-color:#159eee;" onclick="mytheme(5)"> </button>
                </div>
            </div>

        </div>
        <a class="open" href="#"><span><i class="fa fa-gear fa-spin"></i></span></a>
    </div>

</html>