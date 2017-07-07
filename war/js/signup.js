function sumbitSignup() {
	if (isValidSignup()) {
		var signupForm = document.forms["signupFrom"];
		signupForm.submit();
	} else {
		alert("Please give valid inputs");
	}
}

function isValidSignup() {

	var firstName = document.getElementById("firstName").value;
	if (!firstName) {
		document.getElementById("firstNameErrorMessage").style.display = "block";
	} else {
		document.getElementById("firstNameErrorMessage").style.display = "none";
	}
	
	var lastName = document.getElementById("lastName").value;
	if (!lastName) {
		document.getElementById("lastNameErrorMessage").style.display = "block";
	} else {
		document.getElementById("lastNameErrorMessage").style.display = "none";
	}
	
	var emailId = document.getElementById("emailId").value;
	if (!emailId) {
		document.getElementById("emailIdErrorMessage").style.display = "block";

	} else {
		document.getElementById("emailIdErrorMessage").style.display = "none";
	}
	
	var password = document.getElementById("password").value;
	if (!password) {
		document.getElementById("passwordErrorMessage").style.display = "block";
	} else {
		document.getElementById("passwordErrorMessage").style.display = "none";
	}
	var radios = document.getElementsByName("gender");

	var gender = "";
	for (var i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			gender = radios[i].value;
			break;
		}
	}

	var dateOfBirth = document.getElementById("birthDay").value;

	if (!firstName || !lastName || !emailId || !password || !gender
			|| !dateOfBirth) {
		return false;

	} else {
		return true;
	}

}