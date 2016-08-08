function viewBookingHistory(customerId){
	var url = 'viewBookingHistory.view?customerId=' + customerId;
	window.open(url, "viewBookingHistory", "width=500,height=300");
}