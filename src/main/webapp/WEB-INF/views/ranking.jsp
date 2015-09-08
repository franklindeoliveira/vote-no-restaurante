<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
	    
		<title>Vote No Restaurante</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css" rel="stylesheet">
	
	    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	    <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body>
		<div class="container">
			<div class="header clearfix">
		        <nav>
		          <ul class="nav nav-pills pull-right">
		            <li role="presentation" class="active"><a href="./">Home</a></li>
		          </ul>
		        </nav>
		        <h3 class="text-muted">Bem vindo ao Vote No Restaurante!</h3>
	      	</div>
			<div class="container-fluid">
				<div class="row">
		  			<div class="col-md-12">
		  				<p>Confira abaixo o ranking pessoal e geral dos restaurantes mais votados.</p>
		  			</div>
		  		</div>
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-default">
						  <!-- Default panel contents -->
						  <div class="panel-heading">Ranking Pessoal</div>
						
						  <!-- Table -->
						  <table class="table">
						  	<tr>
						  		<th>Posição</th>
						  		<th>Restaurante</th>
						  	</tr>
						  	<c:forEach var="restaurante" items="${restaurantesRankingPessoal}" varStatus="posicao">
						  		<tr>
						  			<th>${posicao.count}&deg;</th>
						  			<th>${restaurante.nome}</th>
								</tr>
							</c:forEach>
						    
						  </table>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-default">
						  <!-- Default panel contents -->
						  <div class="panel-heading">Ranking Geral</div>
						
						  <!-- Table -->
						  <table class="table">
						  	<tr>
						  		<th>Posição</th>
						  		<th>Restaurante</th>
						  	</tr>
						  	<c:forEach var="restaurante" items="${restaurantesRankingGeral}" varStatus="posicao">
						  		<tr>
						  			<th>${posicao.count}º</th>
						  			<th>${restaurante.nome}</th>
								</tr>
							</c:forEach>
						    
						  </table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>