// // Simulate account data (replace with actual data retrieval)
// const accountNumber = 1234567890;
// let balance = 1000;

// // Function to handle login
// function login() {
//   const enteredPin = document.getElementById("pin").value;

//   // Simulate PIN verification (replace with actual logic)
//   if (enteredPin === "1234") { // Replace with actual PIN
//     document.getElementById("login-section").style.display = "none";
//     document.getElementById("main-section").style.display = "block";

//     // Update account details
//     document.getElementById("account-number").textContent = accountNumber;
//     document.getElementById("balance").textContent = balance;
//   } else {
//     alert("Incorrect PIN. Please try again.");
//   }
// }

// // Function to handle deposit
// function deposit() {
//   const amount = parseFloat(prompt("Enter the amount to deposit:"));

//   if (isNaN(amount) || amount <= 0) {
//     alert("Invalid deposit amount.");
//     return;
//   }

//   balance += amount;
//   updateBalance();
//   alert("Deposit successful!");
// }

// // Function to handle withdrawal
// function withdraw() {
//   const amount = parseFloat(prompt("Enter the amount to withdraw:"));

//   if (isNaN(amount) || amount <= 0 || amount > balance) {
//     alert("Invalid withdrawal amount.");
//     return;
//   }

//   balance -= amount;
//   updateBalance();
//   alert("Withdrawal successful!");
// }

// // Function to handle transfer
// function transfer() {
//   const accountNumberToTransfer = prompt("Enter the account number to transfer to:");
//   const amount = parseFloat(prompt("Enter the amount to transfer:"));

//   if (isNaN(amount) || amount <= 0 || amount > balance) {
//     alert("Invalid transfer amount.");
//     return;
//   }

//   // Simulate transfer logic (replace with actual logic)
//   balance -= amount;
//   updateBalance();
//   alert("Transfer successful!");
// }

// // Function to handle printing statement
// function printStatement() {
//   alert("Your statement:\n" +
//     "Account Number: " + accountNumber + "\n" +
//     "Balance: " + balance);
// }

// // Function to handle logout
// function logout() {
//   document.getElementById("main-section").style.display = "none";
//   document.getElementById("login-section").style.display = "block";
//   alert("Logged out successfully.");
// }

// // Function to update the displayed balance
// function updateBalance() {
//   document.getElementById("balance").textContent = balance;
// }




function login() {
    const enteredPin = document.getElementById("pin").value;
  
    // Send a POST request to the backend to verify the PIN
    fetch('/api/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ pin: enteredPin })
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        // Update the UI to show the main section
        document.getElementById("login-section").style.display = "none";
        document.getElementById("main-section").style.display = "block";
      } else {
        alert("Incorrect PIN. Please try again.");
      }
    })
    .catch(error => {
      console.error("Error logging in:", error);
      alert("An error occurred. Please try again later.");
    });
  }
  
  function deposit() {
    const amount = parseFloat(prompt("Enter the amount to deposit:"));
  
    // Send a POST request to the backend to deposit the amount
    fetch('/api/deposit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ amount: amount })
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        alert("Deposit successful!");
        updateBalance();
      } else {
        alert("Deposit failed: " + data.message);
      }
    })
    .catch(error => {
      console.error("Error depositing:", error);
      alert("An error occurred. Please try again later.");
    });
  }
  
  // Implement similar functions for withdraw, transfer, and statement
  
  function updateBalance() {
    fetch('/api/balance')
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        document.getElementById("balance").textContent = data.balance;
      } else {
        alert("Error fetching balance: " + data.message);
      }
    })
    .catch(error => {
      console.error("Error fetching balance:", error);
      alert("An error occurred. Please try again later.");
    });
  }
  
  function logout() {
    fetch('/api/logout')
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        document.getElementById("login-section").style.display = "block";
        document.getElementById("main-section").style.display = "none";
        alert("Logged out successfully.");
      } else {
        alert("Error logging out: " + data.message);
      }
    })
    .catch(error => {
      console.error("Error logging out:", error);
      alert("An error occurred. Please try again later.");
    });
  }