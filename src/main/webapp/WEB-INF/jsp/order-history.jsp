<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="resources/css/manageinventory.css">
<h1>All orders list</h1>
<fieldset id="fsOrderList">
	<legend>Orders</legend>
	<c:forEach items="${orders}" var="order">
		<div class="col-sm-6 col-xs-6">
			<a class="col-xs-12"><strong>Shipping Address:</strong> ${order.shippingAddress}</a>
			<a class="col-xs-12"><strong>Billing Address:</strong> ${order.billingAddress}</a>
			<a class="col-xs-12"><strong>Payment Type:</strong> ${order.paymentType}</a>
			<div class="col-xs-12">
				<small>Item count:<span>${order.cart.getAllCartItems().size()}</span></small>
			</div>
		</div>
		<div id="divOrder" class="divOrder">
			<div class="panel panel-info">
				<div class="panel-heading">
					Order Items
					<div class="pull-right"></div>
				</div>
				<div class="panel-body">
					<c:forEach items="${order.cart.getAllCartItems()}" var="item">
						<div id="divProduct${item.product.id}" class="divProduct">
							<p>
								<a href="detailedPage?id=${item.product.id}"><img src="resources/images/${item.product.imgName}"
									alt="${item.product.imgName}" class="productImg" /></a> <strong>${item.product.name}</strong><br />
								<a>Price: ${item.product.price}</a> <a>Quantity:
									${item.quantity} </a><br />
									<a>Description: ${item.product.description}</a>
							</p>
						</div>
					</c:forEach>

					<!--End of for Each -->
					<div class="form-group">
						<div class="col-xs-12">
							<strong>Order Total</strong>


							<c:set var="totalPrice" value="${0}" />
							<c:forEach var="item" items="${order.cart.getAllCartItems()}">

								<c:set var="totalPrice"
									value="${totalPrice + item.product.price*item.quantity}" />

							</c:forEach>

							<div class="pull-right">
								<span>$</span><span>${totalPrice}</span>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</c:forEach>
</fieldset>
<!-- Ending the Index File -->
<jsp:include page="footer.jsp" />