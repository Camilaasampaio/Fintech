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
			<h2>Tabela Conta</h2>
			<hr class="featurette-divider">
			<a href="meusganhos?acao=novoganho" class="btn btn-outline-warning">Adicionar novo ganho</a> 
		</div>
		<!-- Tabela -->
		<table class="table table-dark table-hover text-center">
      <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Nome do Banco</th>
        <th scope="col">Número da agência</th>
      <th scope="col" >Data</th>
       <th scope="col">Número da Conta</th>  
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Santander</td>
      <td>5215451</td>
      <td>05/10/2023</td>
      <td>5234</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Itaú</td>
      <td>21515415</td>
      <td>25/10/2023</td>
      <td>2232</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Itaú</td>
      <td>21515415</td>
      <td>25/10/2023</td>
      <td>22312</td>
    </tr>
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