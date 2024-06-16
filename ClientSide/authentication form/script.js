// script.js
document.addEventListener('DOMContentLoaded', function () { // Event listener to continuously monitor input in username field
    var usernameInput = document.getElementById('username');
    var usernameError = document.getElementById('usernameError');

    usernameInput.addEventListener('keyup', function () { //triggered when user key is released
        var usernameValue = usernameInput.value;
        var regex = /^[a-zA-Z0-9_]*$/; // Validation - Regular expression to allow only letters, numbers, and underscore

        if (!regex.test(usernameValue)) {
            usernameError.textContent = 'Username can only contain letters, numbers, and underscore (_).';
        } else {
            usernameError.textContent = '';
        }
    });

    //Functionality to ensure the entered password and confirmed password are the same
    var password = document.getElementById('password');
    var confirmPassword = document.getElementById('confirmPassword');
    var passwordMatchError = document.getElementById('passwordMatchError');

    password.addEventListener('keyup', function () {
        passwordMatch(password, confirmPassword);
    });
    confirmPassword.addEventListener('keyup', function () {
        passwordMatch(password, confirmPassword);
    });
    var passwordMatch = (password, confirmPassword) => {
        if (password.value != confirmPassword.value) {
            passwordMatchError.textContent = 'Passwords do not match';
        } else {
            passwordMatchError.textContent = '';
        }

    }
    //Functionality to ensure the entered password is at least 6 characters long
    var passwordLengthError = document.getElementById('passwordLengthError');
    password.addEventListener('keyup', function () {
        if (password.value.length < 6) {
            passwordLengthError.textContent = "Password should be at least 6 characters long"
        } else {
            passwordLengthError.textContent = ""
        }
    });



});
function submitForm() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    var errorMessage = '';

    //alert based validation - if the user submit without ensuring the necessary conditions on username and password
    var regex = /^[a-zA-Z0-9_]*$/;
    if (username.trim() === '') {
        errorMessage += 'Username is required.\n';
    } else if (!regex.test(username)) {
        errorMessage += 'Username can only contain letters, numbers, and underscore (_).\n';
    }

    // Validate password (can add more validation if needed)
    if (password.trim() === '') {
        errorMessage += 'Password is required.\n';
    }

    // Validate confirm password
    if (confirmPassword.trim() === '') {
        errorMessage += 'Confirm Password is required.\n';
    } else if (password !== confirmPassword) {
        errorMessage += 'Passwords do not match.\n';
    }

    // Display error message if there are validation errors
    if (errorMessage !== '') {
        alert(errorMessage);
        return false; // Prevent form submission
    }

    // Form is valid, allow submission
    console.log("Username is" + username);
    console.log("Password is" + password);
    return true;
}
