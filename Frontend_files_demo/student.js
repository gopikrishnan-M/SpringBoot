fetch("http://localhost:8080/students") //API ENDPOINT
.then((Response)=>Response.json())      //json conversion
.then((data) =>console.log(data));      //logging the data