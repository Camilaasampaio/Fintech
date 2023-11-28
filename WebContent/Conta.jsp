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
			<img src="resources/imagens/imagembanco.jpg"
				class="d-block mx-auto mb-4" alt="" width="400" height="300">
			<h2>Conta</h2>
			<p class="lead">Aqui você irá cadastrar suas contas de outros bancos para cadastrar os gastos e ganhos delas.</p>
		</div>
		<!-- Formulário -->
		<div class="col-md-12 col-lg-12">
			<h4 class="mb-3">Cadastre sua conta</h4>
			<form class="needs-validation">
				<div class="row g-3">
					<!-- Campo Banco -->
					<div class="col-sm-6">
						<label for="banco" class="form-label">Banco </label> <input
							type="text" class="form-control" id="banco" required="">
					</div>
					<!-- Campo Agência -->
					<div class="col-sm-3">
						<label for="agencia" class="form-label">Número da Agência </label> 
						<input type="number" class="form-control" id="agencia" required="">
					</div>
					<!-- Campo Número Conta -->
					<div class="col-sm-3">
						<label for="numeroConta" class="form-label">Número da Conta </label>
						<input id="numeroConta" class="form-control" type="number" required="">						
					</div>
					<!-- Campo Data -->
					<div class="col-sm-6">
						<label for="data" class="form-label">Data de Abertura</label> <input
							type="date" class="form-control" id="data" required="">
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