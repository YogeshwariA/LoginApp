function sumbitSignup() {
	if (isValidSignup()) {
		validationSignUp();
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

	var dateOfBirth = document.getElementById("birthday").value;

	if (!firstName || !lastName || !emailId || !password || !gender
			|| !dateOfBirth) {
		return false;

	} else {
		return true;
	}

}
function validationSignUp() {
	var xhttp = new XMLHttpRequest();
	var message = "";
	xhttp.onreadystatechange = function() {
		xhttp.onload = function() {
			try
			{
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
			}
			catch(e)
			{
				document.getElementById('loginDiv').style.display = "none";
				document.getElementById('welcomeMainDiv').display='block';
				document.getElementById('welcomeMainDiv').innerHTML=xhttp.responseText;
				
			}
			
		};
	}
	xhttp.open("POST", "/signup", true);
	xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
	var name = document.getElementById('emailId').value;
	if (!name) {
		xhttp.abort();
		console.log("Request stopped.");
	}
	var password = document.getElementById('password').value;
	var radios = document.getElementsByName("gender");

	var gender = "";
	for (var i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			gender = radios[i].value;
			break;
		}
	}
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var birthday = document.getElementById('birthday').value;
	var params = "emailId=" + name + "&password=" + password+"&firstName=" + firstName+"&lastName=" + lastName+"&birthday=" + birthday+"&gender=" + gender;
	xhttp.send(params);

}
