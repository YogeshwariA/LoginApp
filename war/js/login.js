function isValidLogin() {
	var emailId = document.getElementById("emailId").value;
	var password = document.getElementById("password").value;

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

function submitLogin() {
	if (isValidLogin()) {
		var form = document.forms[0];
		form.submit();
	}
}
function validationLogin() {
	var xhttp = new XMLHttpRequest();
	var message = "";
	xhttp.onreadystatechange = function() {
		message += "";
		if (this.readyState == 0) {

		}

		if (this.readyState == 1) {

			message = "Open method is called.";
			document.getElementById("messageDiv").innerHTML += '<strong style="color:yellow">'
					+ message + '</strong>';
		}
		if (this.readyState == 2) {
			message = "Server receive the request.";
			document.getElementById("messageDiv").innerHTML += '<strong style="color:skyblue">'
					+ message + '</strong>';
		}
		xhttp.onprogress = function() {
			message = "3.Request is in process.";
			document.getElementById("messageDiv").innerHTML += '<strong style="color:blue">'
					+ message + '</strong>';
		}
		xhttp.onload = function() {
			message = "4.response is ready.";

			// document.getElementById("div").style.visibility = "hidden";
			document.getElementById("messageDiv").innerHTML += '<strong style="color:green">'
					+ message + '</strong>'+'<br>';
			
			document.getElementById("messageDiv").innerHTML += '<strong >'
					+ xhttp.responseText + '</strong>';
		};
	}
	xhttp.open("POST", "/login", true);
	xhttp.timeout = 1000;

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
