
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<!-- Starting the Index File -->
<hr>
<div class="container">
	<div class="row">


		<c:forEach items="${values}" var="item">


			<div class="col-xs-18 col-sm-4 col-md-3">
				<div class="productbox">
					<div class="imgthumb img-responsive">
<!-- 						<img src="http://lorempixel.com/250/250/business/?a=7"> -->

							<img src="${pageContext.request.contextPath}/resources/images/${item.product.name}.jpg">
					</div>

					<div class="caption">
						<h5>${item.product.name}</h5>
						
						<strong 
							class="finalprice">${item.product.price}</strong> 
							<form action="detailedPage" >
							<input type="text" id="id" name="id" value="${item.product.id}" hidden/>
							
							<input type="submit" value="Show Product"
							class="btn btn-success btn-md btn-block" id="addToCart" />
							</form>
						</p>
					</div>
				</div>
			</div>

		</c:forEach>


	</div>
	<!--/row-->
</div>
<!--/container -->


<!-- Ending the Index File -->
<jsp:include page="footer.jsp" />