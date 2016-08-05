function releaseCar() {
	var carId = $('#car').val();
	if(carId == "" || carId == null) {
		alert("Please select Car");
	} else {
		$.ajax({
			type: "GET",
			url: 'releaseCar.view?carId=' + carId,
			dataType: "json",
			success : function(message) {
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