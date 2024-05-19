function actualizarLista() {
  const lista = document.getElementById("tipoEvento");
  lista.innerHTML = "";

  fetch("/api/tipoEventos")
    .then(response => response.json())
    .then(json => {
      json.forEach(elemento => {
        const li = `<p>${elemento.categoria}</p>`;
        lista.innerHTML += li;
        console.log(elemento.categoria);
      });
    })
    .catch(error => console.log(error));
}

// Llama a la función para actualizar la lista
actualizarLista();
