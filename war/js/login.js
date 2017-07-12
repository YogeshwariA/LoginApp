function isValidLogin() {
	var emailId = document.getElementById("emailId").value;
	var password = document.getElementById("password").value;
	document.getElementById("serverErrorMessage").style.display = "none";
	// Checks whether email id is not null,not empty and not undefined
	if (!emailId) {
		// shows error message span
		document.getElementById("emailIdErrorMessage").style.display = "block";
	} else {
		// hides error message span
		document.getElementById("emailIdErrorMessage").style.display = "none";
	}

	// Checks whether password id is not null,not empty and not undefined
	if (!password) {
		// shows error message span
		document.getElementById("passwordErrorMessage").style.display = "block";
	} else {
		// hides error message span
		document.getElementById("passwordErrorMessage").style.display = "none";
	}

	// If both emailid and password is valid, form submitted
	if (emailId && password) {
		return true;
	} else {
		return false;
	}
}
function goToGoogle() {
	// var redirectUrl =
	// 'http://v1-dot-login-app-171316.appspot.com/login/oauth2callback';
	var clientId = '2a9ac-2baf139b82055cc1e9d6974edf536f2c';
	var redirectUrl = "http://localhost:8888/login/oauth2callback";
	// https://accounts.google.com/o/oauth2/v2/auth
	// https://access.anywhereworks.com/o/oauth2/auth?
	// https://staging-fullcreative-dot-full-auth.appspot.com
	// var redirectUrl = " https://access.anywhereworks.com/o/oauth2/auth";
	window.location.href = 'https://access-dot-staging.anywhereworks.com/?response_type=code &client_id='
			+ clientId
			+ '&scope=awapis.users.read awapis.feeds.write &redirect_uri='
			+ redirectUrl;
}
function submitLogin() {
	if (isValidLogin()) {
		validationLogin();
	}
}
function validationLogin() {
	var xhttp = new XMLHttpRequest();
	var message = "";
	xhttp.onreadystatechange = function() {
		/*
		 * if (this.readyState == 1) {
		 * 
		 * message = "Open method is called.";
		 * document.getElementById("messageDiv").innerHTML += '<strong
		 * style="color:yellow">' + message + '</strong>'; } if
		 * (this.readyState == 2) { message = "Server receive the request.";
		 * document.getElementById("messageDiv").innerHTML += '<strong
		 * style="color:skyblue">' + message + '</strong>'; } xhttp.onprogress =
		 * function() { message = "3.Request is in process.";
		 * document.getElementById("messageDiv").innerHTML += '<strong
		 * style="color:blue">' + message + '</strong>'; }
		 */
		xhttp.onload = function() {
			var userDetail = JSON.parse(xhttp.responseText);
			if (userDetail) {
				if (!userDetail.message) {
					document.getElementById('loginDiv').style.display = "none";
					document.getElementById('welcomeDiv').style.display = "block";

					document.getElementById("usernameSpan").innerHTML = userDetail.given_name;
					document.getElementById("profilePic").src = userDetail.picture;
				} else {
					document.getElementById("serverErrorMessage").style.display = "block";
					document.getElementById("serverErrorMessage").innerHTML = userDetail.message;
				}

			}

			/*
			 * document.getElementById("messageDiv").innerHTML += '<strong >' +
			 * xhttp.responseText + '</strong>';
			 */
		};
	}
	xhttp.open("POST", "/login", true);
	xhttp.timeout = 50000;

	xhttp.ontimeout = function() {
		console.log("Time out!!!");
	}
	xhttp.onerror = function() {
		console.log("some error occurs.");
	}

	xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
	var name = document.getElementById('emailId').value;
	if (!name) {
		xhttp.abort();
		console.log("Request stopped.");
	}
	var password = document.getElementById('password').value;
	var params = "emailId=" + name + "&password=" + password;
	xhttp.send(params);

}
