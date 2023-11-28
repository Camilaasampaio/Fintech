<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="px-3 py-2 text-bg-dark border-bottom">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/FintechWeb/Inicio.jsp" class="d-flex align-items-center me-lg-auto text-white text-decoration-none">
					<img src="resources/imagens/Cabank_logo_2.jpg" class="icone">
					<h2 style="color: #ac7206;">Cabank Brasil</h2>
				</a>

				<ul class="nav col-12 col-lg-auto justify-content-center text-small">
					<li><a href="/FintechWeb/Inicio.jsp" class="nav-link text-secondary"> <i
							class="fa-solid fa-house"></i> Início
					</a></li>
					<c:if test="${not empty user }">
						<li><a href="meusganhos" class="nav-link text-white"> <i
								class="fa-solid fa-dollar-sign"></i> Meus Ganhos
						</a></li>
						<li><a href="meusganhos" class="nav-link text-white"> <i
								class="fa-solid fa-comments-dollar"></i> Meus Gastos
						</a></li>
						<li><a href="meusinvestimentos" class="nav-link text-white"> <i
								class="fa-solid fa-chart-line"></i> Meus Investimentos
						</a></li>
						<li><a href="poupanca" class="nav-link text-white"> <i
								class="fa-solid fa-piggy-bank"></i> Poupança
						</a></li>
					</c:if>
				</ul>
			</div>
			<div class="text-end">
				<c:if test="${empty user }">
					<a class="btn btn-warning text-dark me-2" href="/FintechWeb/Login.jsp">Entrar</a>
					<a class="btn btn-outline-warning" href="usuario">Crie sua conta</a>					
				</c:if>
		    	<c:if test="${not empty user }">
		    		<span class="navbar-text">
			    		${user }
			    		<a href="login" class="btn btn-outline-warning">Sair</a>
			  		</span>	
	    		</c:if>
			</div>
		</div>
	</div>
</header>