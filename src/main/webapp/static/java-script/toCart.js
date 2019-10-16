function plus(id) {
	var elem = document.getElementById('q' + id);
	elem.innerHTML = +elem.innerHTML + 1;
}
function minus(id) {
	var elem = document.getElementById('q' + id);
	if (+elem.innerHTML > 1) {
		elem.innerHTML = +elem.innerHTML - 1;
	}
}
function addToCart(id){
	var qnt = document.getElementById('q' + id).innerHTML;
	$.ajax({
		type : "GET",
		url : "./cart",
		data : "productID=" + (id + ":" + qnt),
		success : function(response) {
			alert('Product added to cart');
			var cartSize = +document.getElementById('cart').innerHTML.substr(6) + +qnt;
			document.getElementById('cart').innerHTML = " Cart: " + cartSize;
		}
	});
}