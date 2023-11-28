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
<body class="container col-md-4 col-lg-4">
	<div class="d-flex align-items-center py-4">
		<div class="form-signin w-100 m-auto">
			<form action="login" method="post">
				<img src="resources/imagens/Cabank_logo_2.jpg" class="icone">
				<h1 class="h3 mb-3 fw-normal" style="color: #ac7206;">Cabank
					Brasil</h1>
				<c:if test="${empty user }">
					<span class="navbar-text text-danger" style="margin-right: 10px">
						${erro } </span>
				</c:if>
				<!-- Campo E-mail -->
				<div class="form-floating">
					<input type="email" class="form-control" name="email"> <label
						for="email">E-mail</label>
				</div>
				<!-- Campo Senha -->
				<div class="form-floating">
					<input type="password" class="form-control" name="senha"> <label
						for="senha">Senha</label>
				</div>
				<hr class="my-4">
				<button class="btn btn-outline-warning w-100 py-2" type="submit">Entrar</button>
				<p class="mt-5 mb-3 text-body-secondary">© 2017–2023 Cabank.</p>
			</form>
		</div>
		<!-- Incluindo Footer -->
		<%@ include file="scripts.jsp"%>
	</div>
</body>

</html>