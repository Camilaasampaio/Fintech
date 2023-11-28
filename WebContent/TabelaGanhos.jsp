<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<img src="resources/imagens/meusGastos.jpg"
				class="d-block mx-auto mb-4" alt="" width="400" height="300">
			<h2>Tabela Gastos e Ganhos</h2>
			<hr class="featurette-divider">
			<a href="meusganhos?acao=novoganho" class="btn btn-outline-warning">Adicionar
				novo ganho</a> <a href="meusganhos?acao=novogasto"
				class="btn btn-outline-warning">Adicionar novo gasto</a>
		</div>
		<!-- Tabela -->
		<table class="table table-dark table-hover text-center">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">Nome</th>
					<th scope="col">Data</th>
					<th scope="col">Valor</th>
					<th scope="col">Tipo</th>
					<th scope="col">Conta</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transferencia}" var="t" varStatus="contador">
					<c:if test="${t.tipoTransferencia == 'despesa' }">
						<tr class="table-warning">
							<th scope="row">${contador.count}</th>
							<td>${t.nomeTransferencia}</td>
							<td><fmt:formatDate value="${t.dataTransferencia.time}"
									pattern="dd/MM/yyyy" /></td>
							<td>R$ ${t.valorTransferencia}</td>
							<td>${t.tipoTransferencia}</td>
							<td>${t.codigoConta}</td>
						</tr>
					</c:if>
					<c:if test="${t.tipoTransferencia == 'receita' }">
						<tr class="table-info">
							<th scope="row">${contador.count}</th>
							<td>${t.nomeTransferencia}</td>
							<td><fmt:formatDate value="${t.dataTransferencia.time}"
									pattern="dd/MM/yyyy" /></td>
							<td>R$ ${t.valorTransferencia}</td>
							<td>${t.tipoTransferencia}</td>
							<td>${t.codigoConta}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

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