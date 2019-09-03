<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="model.model_Article"%>

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
    <header class="masthead" style="background-image: url('img/post-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-heading">
              <h1>Portfolios</h1>
              <h2 class="subheading">See how the others built their careers.</h2>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Post Content -->
    <div class="board container">
		<div class="col-lg-12 col-md-10 mx-auto">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col" class="text-center" style="width: 10%">No</th>
						<th scope="col" class="text-center" style="width: 70%">Title</th>
						<th scope="col" class="text-center" style="width: 5%">Author</th>
						<th scope="col" class="text-center" style="width: 15%">Date</th>
					</tr>
				</thead>
				<tbody>
				<%
					@SuppressWarnings("unchecked")
					List<model_Article> list = (List<model_Article>)request.getAttribute("list");
					
					for(model_Article a : list)
					{
				%>
					<tr>
						<th scope="row" class="text-center" style="width: 10%"><%=a.getArticleNumber() %></th>
						<td class="text-center" style="width: 70%">
							<a href="<%=request.getContextPath()%>/controller_View?author=<%=a.getAuthor()%>"><%=a.getArticleName() %></a>
						</td>
						<td class="text-center" style="width: 5%"><%=a.getAuthor() %></td>
						<td class="text-center" style="width: 15%"><%=a.getWriteDate() %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
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

    <!-- Custom scripts for this template -->
    <script src="js/clean-blog.min.js"></script>

  </body>

</html>
