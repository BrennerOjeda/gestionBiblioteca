function subastar(i) {
	var idProducto = getQueryVariable("id");
	$.ajax({
		type : "POST",
		url : "./Subasta",
		data : {
			id : idProducto,
			accion : "subastar"
		}
	}).done(function(data) {
		var dataarray = data.split(",");
		var precio = parseFloat(dataarray[0]).toFixed(2);
		var datestring = dataarray[1];
		var date = parseDate(datestring);
		$('#precio_' + i).html(precio);
		$('#tiempo_' + i).countdown('option', {
			until : date,
			compact : true
		});
	});
}

function ofertar(i) {
	var idProducto = getQueryVariable("id");
	$.ajax({
		type : "POST",
		url : "./Subasta",
		data : {
			id : idProducto,
			accion : "subastar"
		}
	}).done(function(data) {
		var dataarray = data.split(",");
		var precio = parseFloat(dataarray[0]).toFixed(2);
		var datestring = dataarray[1];
		var date = parseDate(datestring);
		$('#precio_' + i).html(precio);
		$('#tiempo_' + i).countdown('option', {
			until : date,
			compact : true
		});
	});
}

function mostrarProducto() {
	$.ajax({
		type : "POST",
		url : "./Subasta",
		data : {
			productoId : "10",
			accion : "mostrar"
		}
	}).done(function(data) {
		var dataarray = data.split(",");
		var precio = parseFloat(dataarray[0]).toFixed(2);
		var datestring = dataarray[1];
		var date = parseDate(datestring);
		$('#tiempo').countdown('option', {
			until : date,
			compact : true
		});
		$('#precio_1').html(precio);
		$('#tiempo_2').countdown('option', {
			until : date,
			compact : true
		});
		$('#precio_2').html(precio);
		$('#tiempo_3').countdown('option', {
			until : date,
			compact : true
		});
		$('#precio_3').html(precio);
	});
}

function comprarmoneda(i) {
	$.ajax({
		type : "POST",
		url : "./comprarMoneda",
		data : {
			monedaId : i
		}
	}).done(function(data) {
		alert("comprado satisfactoriamente");
		$(location).attr('href', "/PWsubastas/mostrarUsuario");
	});
}

function ObtenerProductos() {
	$.ajax({
		type : "POST",
		url : "./ObtenerProductos",
		data : {
			productoId : "10",
			accion : "obtener"
		}
	}).done(function(data) {
		var dataarray = data.split(",");
		var contenido = dataarray[1];
		document.getElementById('contenido').innerHTML = contenido;
	});
}

function buscarProductos() {
	var word = getElementById("searchWord").value;
	$.ajax({
		type : "POST",
		url : "./ObtenerProductos",
		data : {
			word : word,
			accion : "buscar"
		}
	}).done(function(data) {
		var dataarray = data.split(",");
		var contenido = dataarray[1];
		document.getElementById('contenido').innerHTML = contenido;
	});
}

function producto() {
	var idProducto = getQueryVariable("id");
	$.ajax({
		type : "POST",
		url : "./ObtenerProductos",
		data : {
			id : idProducto,
			accion : "producto"
		}
	}).done(function(data) {
		var dataarray = data.split(",");
		var contenido = dataarray[1];
		document.getElementById('descripcionProducto').innerHTML = contenido;
	});
}

function parseDate(ds) {
	var time = ds.split(" ")[1];
	var hour = time.split(":")[0], minute = time.split(":")[1], second = time
			.split(":")[2];
	var fecha = ds.split(" ")[0];
	day = fecha.split("-")[2], month = fecha.split("-")[1], year = fecha
			.split("-")[0];
	var date = new Date(year, month - 1, day, hour, minute, second);
	return date;
}

function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	alert('variable' + variable + ' no encontrada');
}
