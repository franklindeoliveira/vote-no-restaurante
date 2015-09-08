<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
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
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
<script src="<c:url value="/resources/js/votacao.js" />"></script>
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
					<p>Acompanhe o ranking dos melhores restaurantes da região,
						segundo a preferência dos usuários! Dê sua opinião e contribua,
						que ao final exibiremos o ranking geral dos restaurantes mais
						votados.</p>
				</div>
			</div>
		</div>
		<div class="jumbotron">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<p id="message">Qual sua preferência?</p>
					</div>
					<div class="col-md-6">
						<div id="restauranteA" data-id="" style="float: left;">
							<img id="imgA"></img><br /> <span id="nomeA"></span>
						</div>
					</div>
					<div class="col-md-6">
						<div id="restauranteB" data-id="">
							<img id="imgB"></img><br /> <span id="nomeB"></span> <span
								id="idB"></span>
						</div>
					</div>
				</div>
				<div class="row" id="progress">
					<div class="col-md-12">
						<div class="progress">
							<div class="progress-bar" id="progress-bar" role="progressbar" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100" style="width: 5%;">
								0%
							</div>
						</div>
					</div>
				</div>
				<div class="row" id="cadastra" style="display: none">
					<div class="col-md-12">
						<div class="alert alert-danger" role="alert" id="erroAlert" style="display: none">
						  Os campos <b>nome</b> e <b>email</b> são de preenchimento obrigatório. 
						</div>
					</div>
					<div class="col-md-12">
						<form action="cadastra" id="cadastra">
							<span>Nome:</span>
							<input name="nome" id="nome"></input> 
							<span>Email:</span>
							<input name="email" id="email"></input>
							<input id="ranking" name="ranking" style="display: none"></input>
							<input type="submit" value="Cadastrar"></input>
						</form>
					</div>
				</div>
			</div>
		</div>

	<footer class="footer">
		<p>&copy; Vote No Restaurante 2015</p>
	</footer>

	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>