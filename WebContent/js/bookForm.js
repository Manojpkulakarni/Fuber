function getAvailableCars() {
	var customerId = $('#customer').val();
	if(customerId == "" || customerId == null) {
		alert("Please select Customer");
	} else {
		$.ajax({
			type: "GET",
			url: 'searchCars.view?customerId=' + customerId,
			dataType: "json",
			success : function(cars) {
				var result = "";
				$.each(cars, function(index, car){
					result += "<tr><td>" + car.name + "</td><td>" + car.color + "</td><td>" + car.longitude + "</td><td>" + car.latitude + "</td></tr>";
				});
				$('#results').html(result);
				$('#searchResults').show();
				$('#message').hide();
			},
			error: function (error) {
				console.log(error);
				window.location = "home.view?message=" + error.responseText;
			}
		});
	}
}

function bookCar() {
	var customerId = $('#customer').val();
	if(customerId == "" || customerId == null) {
		alert("Please select Customer");
	} else {
		$.ajax({
			type: "GET",
			url: 'bookCar.view?customerId=' + customerId,
			dataType: "json",
			success : function(message) {
				$('#searchResults').hide();
				$('#message').html(message);
				$('#message').show();
			},
			error: function (error) {
				console.log(error);
				window.location = "home.view?message=" + error.responseText;
			}
		});
	}
}