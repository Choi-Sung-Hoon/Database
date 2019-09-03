<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>KNU Folio</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">KNU Folio</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.jsp">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<%=request.getContextPath()%>/controller_Portfolio">Portfolios</a>
            </li>
            <%
            	boolean flag = false;
    		
	    		if(!session.isNew())
	    		{
	    			try
	    			{
	    				flag = (boolean)session.getAttribute("flag");
	    			}
	    			catch(Exception e)
	    			{
	    				session = null;
	    			}
	    		}
	    		
	    		if(flag)
	    		{
            %>
            <li class="nav-item">
              <a class="nav-link" href="<%=request.getContextPath()%>/controller_MyPage">${id}</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<%=request.getContextPath()%>/controller_Logout">Logout</a>
            </li>
            <%
	    		}
	            else
	            {
            %>
            <li class="nav-item">
              <a class="nav-link" href="login.jsp">Login</a>
            </li>
            <%
            	}
            %>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('img/contact-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1>Login</h1>
              <span class="subheading">Please login to manage your career!</span>
            </div>
          </div>
        </div>
      </div>
    </header>
    
    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <p>Want to manage your portfolio?	If you don't have any account, please register!</p>
          <form name="loginForm" id="loginForm" action="<%=request.getContextPath()%>/controller_Login" method="post" novalidate>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls">
                <label>ID</label>
                <input type="text" class="form-control" placeholder="ID" id="loginId" name="loginId" required data-validation-required-message="Please enter your ID">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Password" id="loginPassword" name="loginPassword" required data-validation-required-message="Please enter your Password.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <br>
            <div id="success"></div>
            <div class="form-group">
              <button type="submit" class="btn btn-primary" id="sendLoginButton">Login</button>
              <button type="button" class="btn btn-primary" id="openRegisterModal" data-target="#registerPopup" data-toggle="modal">Register</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    
    <div id="registerPopup" class = "modal fade">
	    <div class="modal-dialog">
	        <div class = "modal-content">
	            <div class="modal-header">
	                <h4 class = "modal-title">Registration</h4>
	            </div>
	
	            <div class = "modal-body">
	                <article class="container-fluid" >
	                    <div class="col-lg-12 col-md-10 mx-auto">
	                        <form role="form" id="registrationForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Register" method="post" novalidate>
	                            <div class="form-group">
	                                <label for="id">User ID</label>
	                                <input type="text" class="form-control" id="registerId" name="registerId" placeholder="Enter your ID" required>
	                                <div class="valid-feedback">Looks good!</div>
	                                <div class="invalid-feedback">Please provide a ID</div>
	                            </div>
	                            <div class="form-group">
	                                <label for="password">Password</label>
	                                <input type="password" class="form-control" id="registerPassword" name="registerPassword" placeholder="Enter your password" required>
	                                <div class="valid-feedback">Looks good!</div>
	                                <div class="invalid-feedback">Please provide a password</div>
	                            </div>
	                            <div class="form-group">
	                                <label for="studentName">Name</label>
	                                <input type="text" class="form-control" id="studentName" name="studentName" placeholder="Enter your name" required>
	                                <div class="valid-feedback">Looks good!</div>
	                                <div class="invalid-feedback">Please provide a name</div>
	                            </div>
	                            <div class="form-group">
	                                <label for="studentNumber">Student Number</label>
	                                <input type="number" class="form-control" id="studentNumber" name="studentNumber" placeholder="Enter your student number" required>
	                                <div class="valid-feedback">Looks good!</div>
	                                <div class="invalid-feedback">Please provide a student number</div>
	                            </div>
	                            <div class="form-group">
	                                <label for="majorName">Major</label>
	                                <input type="text" class="form-control" id="majorName" name="majorName" placeholder="Enter your major" required>
	                                <div class="valid-feedback">Looks good!</div>
	                                <div class="invalid-feedback">Please provide a name</div>
	                            </div>
	                            <div class="form-group">
	                                <label for="degree">Degree</label>
	                                <input type="number" class="form-control" id="degree" name="degree" placeholder="Enter your degree" required>
	                                <div class="valid-feedback">Looks good!</div>
	                                <div class="invalid-feedback">Please provide a degree</div>
	                            </div>
	                            <div class="form-group text-center">
	                                <button type="submit" id="submit" name="submit" class="btn btn-primary">
					                   Register<i class="fa fa-check spaceLeft"></i>
	                                </button>
	                                <button type="reset" class="btn btn-default" data-dismiss="modal">
					                   Cancel<i class="fa fa-times spaceLeft"></i>
	                                </button>
	                            </div>
	                        </form>
	                    </div>
	                </article>
	            </div>
	        </div>
	    </div>
  	</div>

    <hr>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; KNU Folio 2018</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Login Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/login.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/clean-blog.min.js"></script>
    
    <!-- validation script for registration -->
    <script src="js/registrationValidation.js"></script>
  </body>

</html>