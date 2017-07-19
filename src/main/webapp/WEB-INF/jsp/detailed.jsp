<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<!-- Starting the Index File -->

	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="${pageContext.request.contextPath}/resources/images/${name}.jpg" /></div>
						  
						</div>
						
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${name}</h3>
						<input type="text" id="productId" value="${id}" hidden/>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">${description }</p>
						<h4 class="price">current price: <span>$${price}</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						<h5 class="sizes">sizes:
							<span class="size" data-toggle="tooltip" title="small">s</span>
							<span class="size" data-toggle="tooltip" title="medium">m</span>
							<span class="size" data-toggle="tooltip" title="large">l</span>
							<span class="size" data-toggle="tooltip" title="xtra large">xl</span>
						</h5>
						<h5 class="colors">colors:
							<span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
							<span class="color green"></span>
							<span class="color blue"></span>
						</h5>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button" id="addToCartBtn">Add to Cart</button>
							<a class="like btn btn-default" href="index" type="button"><span class="fa fa-heart">Continue Shopping</span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- Ending the Index File -->
<jsp:include page="footer.jsp" />