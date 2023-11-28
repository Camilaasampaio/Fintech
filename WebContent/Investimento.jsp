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
			<img src="resources/imagens/investimento.jpg"
				class="d-block mx-auto mb-4" alt="" width="400" height="300">
			<h2>Investimento</h2>
			<p class="lead">Aqui você irá cadastrar o seus investimentos como
				por exemplo dinheiro que você está juntando para comprar uma moto ou
				casa.</p>
		</div>
		<!-- Formulário -->
		<div class="col-md-12 col-lg-12">
			<h4 class="mb-3">Cadastre seus investimentos</h4>
			<form class="needs-validation" action="meusinvestimentos" method="post">
				<div class="row g-3">
					<!-- Campo Descrição -->
					<div class="col-sm-6">
						<label for="descricao" class="form-label">Descrição </label> 
						<input
							type="text" class="form-control" name="nome" placeholder=""
							value="" required="">
					</div>
					<!-- Campo Data -->
					<div class="col-sm-6">
						<label for="data" class="form-label">Data </label> 
						<input
							type="date" class="form-control" name="dataInvestimento" placeholder=""
							value="" required="">
					</div>
					<!-- Campo Valor -->
					<div class="col-sm-4">
						<label for="valor" class="form-label">Valor </label>
						<div class="input-group mb-3">
							<span class="input-group-text">R$</span> 
							<input name="valor"
								type="number" class="form-control" required="">
						</div>
					</div>
					<!-- Campo Conta -->
					<div class="col-sm-8">
						<label for="conta" class="form-label">Conta </label>
						<div class="input-group mb-3">		
						<input type="hidden" name="codigoUsuario" id="codigoUsuario">					
							<select class="form-select" name="conta" required="">
								<option selected>Escolha uma conta...</option>
								<c:forEach items="${contas}" var="c">
									<option value="${c.getCodigoConta() }" onclick="codigoUsuario.value=${c.getCodigoUsuario()}">
										${c.getNomeFormatado() }
									</option>
								</c:forEach>	
							</select>
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