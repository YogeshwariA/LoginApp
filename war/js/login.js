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
	}
	else{
		return false;
	}

}

function submitLogin() {
	if (isValidLogin()) {
		var form = document.forms[0];
		form.submit();
	}
}

function validationLogin()
{
	// asynchronous-call back function

	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "/login", true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// Typical action to be performed when the document is ready:
			document.getElementById("messageDiv").innerHTML ='<strong>'+ xhttp.responseText+'</strong>';
		}
	};
	
	xhttp.setRequestHeader('content-type','application/x-www-form-urlencoded');
	var name=document.getElementById('emailId').value;
	var password=document.getElementById('password').value;
	var params = "emailId=" + name
			+ "&password=" + password;
	
	xhttp.send(params);
	}
