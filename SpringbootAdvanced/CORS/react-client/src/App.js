import { useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  const fetchApi = async () => {
    console.log("You have clicked the button!");
    setMessage("Chiamata in corso...");

    try {
      const response = await fetch("http://localhost:8080/custom");
      const text = await response.text();

      console.log("Response:", text);
      setMessage(text);
    } catch (error) {
      console.error("Errore:", error);
      setMessage("Errore: " + error.message);
    }
  };

  return (
      <div className="App">
        <button id="clickMe" onClick={fetchApi}>
          8080
        </button>

        <p>{message}</p>
      </div>
  );
}

export default App;