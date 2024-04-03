document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    console.log("into registrationForm");

    // Perform registration logic here (send data to backend, etc.)
    const registrationData = new FormData(event.target);
    const userLoginInfo = {
        userName: registrationData.get("userName"),
        name: registrationData.get("fullName"),
        password: registrationData.get("password")
    };

    fetch("/register/user", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userLoginInfo) // Use the correct variable name here
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Enter a new User Name");
            }
            // Redirect user to login page after successful registration
            window.location.href = "/LoginPage.html";
        })
        .catch(error => {
            console.error("Error:", error);
            // Handle registration error (display error message, etc.)

            const errorMessage = document.createElement("div");
            errorMessage.textContent = "UserName Exists " + error.message;
            errorMessage.style.color = "red";
            event.target.appendChild(errorMessage);
            document.getElementById("username").value = "";
            document.getElementById("fullName").value = "";
            document.getElementById("password").value = "";
        });
});
