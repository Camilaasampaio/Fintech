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
		<main>
		<div id="myCarousel" class="carousel slide mb-6"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="0" class="active" aria-label="Slide 1"
					aria-current="true"></button>
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="resources/imagens/investimento.jpg"
						style="width: 100%; height: 500px;" />
					<div class="container">
						<div class="carousel-caption text-start">
							<h2 class="text-center bg-dark" style="color: #FFFFFF">Investimento</h2>
							<h4 class="text-center bg-dark" style="color: #FFFFFF">
								Busque melhoria para sua vida, invista naquilo que te faz bem</h4>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img src="resources/imagens/poupanca.jpg"
						style="width: 100%; height: 500px;" />
					<div class="container">
						<div class="carousel-caption">
							<h2 class="text-center bg-dark" style="color: #FFFFFF">Poupança</h2>
							<h4 class="text-center bg-dark" style="color: #FFFFFF">Aqui
								você pode guardar valores para os seus projetos futuros</h4>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img src="resources/imagens/gastos.jpg"
						style="width: 100%; height: 500px;" />
					<div class="container">
						<div class="carousel-caption text-end">
							<h2 class="text-center bg-dark" style="color: #FFFFFF">Gastos</h2>
							<h4 class="text-center bg-dark" style="color: #FFFFFF">
								Organize seus gastos com o Cabank</h4>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#myCarousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Anterior</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#myCarousel" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Próximo</span>
			</button>
		</div>

		<div class="container marketing">
			<div class="row">
				<div class="col-lg-4">
					<img src="resources/imagens/imagemganhos.jpg"
						class="bd-placeholder-img rounded-circle" width="140" height="140" />
					<h2 class="fw-normal">Meus Ganhos</h2>
					<p>Verifique aqui seus ganhos ou registre-os</p>
					<p>
						<c:if test="${not empty user }">
							<a class="btn btn-secondary" href="meusganhos">Verificar »</a>
						</c:if>
					</p>
				</div>
				<div class="col-lg-4">
					<img src="resources/imagens/imageminvestimento.jpg"
						class="bd-placeholder-img rounded-circle" width="140" height="140" />
					<h2 class="fw-normal">Meus Investimentos</h2>
					<p>Verifique seus investimentos e organize-os</p>
					<p>
						<c:if test="${not empty user }">
							<a class="btn btn-secondary" href="meusinvestimentos">Verificar
								»</a>
						</c:if>
					</p>
				</div>
				<div class="col-lg-4">
					<img src="resources/imagens/imagemgastos.jpg"
						class="bd-placeholder-img rounded-circle" width="140" height="140" />
					<h2 class="fw-normal">Meus Gastos</h2>
					<p>Verifique aqui seus gastos e organize-os</p>
					<p>
						<c:if test="${not empty user }">
							<a class="btn btn-secondary" href="meusganhos">Verificar »</a>
						</c:if>
					</p>
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7">
					<h2 class="featurette-heading fw-normal lh-1">Conheça nossos
						cartões</h2>
					<p class="lead">Temos cartões de crédito e débito, onde
						possuímos juros baixos e parcelamento de até 10x, com a anuidade
						totalmente gratuita</p>
				</div>
				<div class="col-md-5">
					<img src="resources/imagens/Cartão.jpg"
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" />
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<h2 class="featurette-heading fw-normal lh-1">Em breve..</h2>
					<p class="lead">Não perca novos lançamentos feitos pela equipe,
						estamos trabalhando para o melhor do Cabank. Aqui trazemos novos
						projetos para melhoria e satisfação do cliente.</p>
					<h3>
						<b>Não perca, gostariamos de você com a gente.</b>
					</h3>
				</div>
				<div class="col-md-5 order-md-1">
					<img src="resources/imagens/construcao.jpg"
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" />
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7">
					<h2 class="featurette-heading fw-normal lh-1">Missão, visão e
						valores</h2>
					<p class="lead">
						A <b>missão</b> é fazer o cliente satisfeito com nosso banco
						Cabank, trazendo bons resultados e buscando sempre melhoria.<br>
						Nossa <b>visão</b> é buscar novos projetos para entregar com base
						no que o cliente deseja, sempre procurando desafios para nossos
						clientes ficarem satisfeitos com os resultados.<br>Em nossos
						<b>valores</b>, buscamos reuniões de como ajudar nossos
						colaboradores em seu horário de trabalho, com assuntos de ética,
						atrações e talentos, para que possamos por em prática.
					</p>
				</div>
				<div class="col-md-5">
					<img src="resources/imagens/missaovi.jpg"
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" />
				</div>
			</div>

			<hr class="featurette-divider">

		</div>
		<footer class="container">
		<p class="float-end">
			<a href="#">Voltar ao topo</a>
		</p>
		<p>© 2017–2023 Cabank.</p>
		</footer> </main>

		<!-- Incluindo Footer -->
		<%@ include file="scripts.jsp"%>
	</div>
</body>

</html>