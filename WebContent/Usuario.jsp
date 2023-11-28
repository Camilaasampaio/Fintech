<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html data-bs-theme="dark">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cabank</title>
<!-- Incluindo Header -->
<%@ include file="links.jsp"%>
</head>
<body>
	<!-- Incluindo Menu -->
	<%@ include file="menu.jsp"%>
	<div class="container">
		<!-- Título -->
		<div class="py-5 text-center">
			<img src="resources/imagens/usuario.jpg" class="d-block mx-auto mb-4"
				alt="" width="400" height="300">
			<h2>Cadastro</h2>
			<p class="lead">Aqui você irá fazer seu cadastrastro para fazer
				parte do banco Cabank</p>
		</div>
		<!-- Formulário -->
		<div class="col-md-12 col-lg-12">
			<h4 class="mb-3">Cadastro</h4>
			<form class="needs-validation" action="usuario" method="post">
				<div class="row g-3">
					<!-- Campo nome -->
					<div class="col-sm-12">
						<label for="nome" class="form-label">Nome Completo </label> 
						<input
							type="text" class="form-control" name="nome" placeholder=""
							value="" required="">
					</div>
					<!-- Campo e-mail -->
					<div class="col-sm-6">
						<label for="email" class="form-label">E-mail </label> 
						<input
							name="email" type="text" class="form-control"
							placeholder="Digite seu e-mail" aria-label="Digite seu e-mail"
							aria-describedby="basic-addon2" required="">
					</div>

					<!-- Campo Senha -->
					<div class="col-sm-6">
						<label for="valor" class="form-label">Senha </label>
						<div class="input-group mb-3">
							<input name="senha" type="password" class="form-control"
								required="">
						</div>
					</div>
					
					<!-- Linha -->
					<hr class="my-4">
					<!-- Botão Salvar -->
					<button class="w-100 btn btn-outline-warning btn-lg" type="submit">Salvar</button>
				</div>
			</form>
		</div>

		<hr class="featurette-divider">

		<footer class="container">
		<p class="float-end">
			<a href="#">Voltar ao topo</a>
		</p>
		<p>© 2017–2023 Cabank.</p>
		</footer>

		<!-- Incluindo Footer -->
		<%@ include file="scripts.jsp"%>
	</div>
</body>

</html>