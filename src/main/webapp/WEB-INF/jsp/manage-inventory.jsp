<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/manageinventory.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/manageinventory.css">
<jsp:include page="headerInv.jsp" />
<h1>All products list</h1>
<fieldset id="fsProdList">
	<legend>Products</legend>
	<c:forEach items="${inventory}" var="item">
		<div id="divProduct${item.product.id}" class="divProduct">
			<p>
				<img src="resources/images/${item.product.imgName}"
					alt="${item.product.imgName}" class="productImg" /> <strong>${item.product.name}</strong><br />
				<label>Price: $<input type="text"
					name="price${item.product.id}" value="${item.product.price}"
					id="price${item.product.id}" class="productPrice" /></label> <label>Quantity:
					<input type="text" name="quantity${item.product.id}"
					value="${item.quantity}" id="quantity${item.product.id}"
					class="productQuantity" />
				</label><br />
				<button type="button" id="${item.product.id}" class="btnUpdate">Save</button>
				<button type="button" id="${item.product.id}" class="btnDelete">Delete</button>
				<a id="a${item.product.id}" class="amsg"></a><br /> <a>${item.product.description}</a>
			</p>
		</div>
	</c:forEach>
</fieldset>
<fieldset id="fsCreateProd">
	<legend>Create product</legend>
	<label>Product Name: <input type="text" name="newName" value=""
		id="newName" class="newProduct" />
	</label> <br /> <label>Price: <input type="text" name="newPrice"
		value="" id="newPrice" class="newProduct" />
	</label> <br /> <label>Quantity: <input type="text" name="newQuantity"
		value="" id="newQuantity" class="newProduct" />
	</label> <br /> <label>Product Description: <textarea rows="4"
			name="newDescription" id="newDescription" class="newProduct"></textarea>
	</label> <br />
	<form id="upload-form" class="upload-box" action="UploadProductImage"
		name="submit" method="post" enctype="multipart/form-data">
		<fieldset id="fsProductImage">
			<legend>Product Image:</legend>
			<input type="file" id="newImage" name="file" />
			<!-- 				<input type="submit" name="uploadImage" value="upload" id="newImageUpload" /> -->
		</fieldset>
	</form>
	<button type="button" id="newBtnCreate" class="newProduct">Create</button>
</fieldset>

<!-- Ending the Index File -->
<jsp:include page="footerInv.jsp" />