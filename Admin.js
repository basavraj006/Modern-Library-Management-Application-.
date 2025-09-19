const API_URL = 'http://localhost:8080/admin';  // Change to your backend URL

// Check if already logged in on page load (based on token)
window.onload = function() {
    if (localStorage.getItem('token')) {
        document.getElementById('forms').style.display = 'none';
        document.getElementById('logged-in').style.display = 'block';
    }
};

// Toggle between login and register forms with animation
function toggleForm(form) {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');

    if (form === 'register') {
        loginForm.classList.add('hidden');
        setTimeout(() => {
            loginForm.style.display = 'none';
            registerForm.style.display = 'block';
            registerForm.classList.remove('hidden');
        }, 300);
    } else {
        registerForm.classList.add('hidden');
        setTimeout(() => {
            registerForm.style.display = 'none';
            loginForm.style.display = 'block';
            loginForm.classList.remove('hidden');
        }, 300);
    }
}

// Registration function
async function register(event) {
    event.preventDefault();
    const adminName = document.getElementById('register-Adminname').value;
    const mailId = document.getElementById('register-email').value;
    const password = document.getElementById('register-password').value;

    try {
        const response = await fetch(`${API_URL}/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ adminName, mailId, password })
        });

        if (!response.ok) {
            const error = await response.text();
            alert(error || 'Registration failed. Email may already exist.');
            toggleForm('login');  // Toggle to login if already registered
            return;
        }

        alert('Registration successful! Please login.');
        toggleForm('login');
    } catch (error) {
        alert('Error connecting to backend during registration.');
    }
}

// Login function
document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector("form"); // adjust if you have a different selector
    if (!loginForm) return;

    loginForm.addEventListener("submit", async (e) => {
        e.preventDefault();

        const mailId = document.querySelector("#email").value;   // make sure your email input has id="email"
        const password = document.querySelector("#password").value; // make sure password input has id="password"

        try {
            const response = await fetch("http://localhost:8080/admin/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ mailId, password })
            });

            if (!response.ok) {
                throw new Error("Network response was not ok");
            }

            const data = await response.json();

            if (data.success) {
                alert(data.message); // "Login successful"
                // You can store user info in localStorage if you want
                localStorage.setItem("userId", data.userId);
                localStorage.setItem("mailId", data.mailId);

                // Redirect to dashboard or home page
                window.location.href = 'index.html';
            } else {
                alert(data.message); // "Invalid password" or "User not found"
            }
        } catch (error) {
            console.error("Error during login:", error);
            alert("Something went wrong. Please try again.");
        }
    });
});

// Logout function
function logout() {
    localStorage.removeItem('token');
    document.getElementById('logged-in').style.display = 'none';
    document.getElementById('forms').style.display = 'block';
    toggleForm('login');
}
