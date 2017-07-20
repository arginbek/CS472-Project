$(function() {
	/*$('#home_btn').click(function() {
		$.get("index", {}).done(function(data) {
			
		}).fail(function() {
			
		});
	})
	
	$('#logout_btn').click(function() {
		$.get("login?action=signout");
	})*/
	
	$('#edit_btn')
			.click(
					function() {
						/*
						 * window .open("edit_account.jsp", null);
						 */
						PopupCenter("edit_account.jsp", "Edit Account Info", 400, 300);
					})
	$('#save_btn').click(function() {
		$.post("account", 
		{
			first: $('#firstname').val(),
			last: $('#lastname').val()
		})
		.done(function(data) {
			data = JSON.parse(data);
			window.close();
			$('#fname', opener.document).text("First name: " + data.firstName);
			$('#lname', opener.document).html("Last name: " + data.lastName);
		})
		.fail(function() {
			alert("action failed");
		})
	})
})

function PopupCenter(url, title, w, h) {
    // Fixes dual-screen position Most browsers Firefox
    var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
    var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;

    var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
    var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

    var left = ((width / 2) - (w / 2)) + dualScreenLeft;
    var top = ((height / 2) - (h / 2)) + dualScreenTop;
    var newWindow = window.open(url, title, 'scrollbars=yes, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);

    // Puts focus on the newWindow
    if (window.focus) {
        newWindow.focus();
    }
}