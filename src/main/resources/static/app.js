async function cargarCategorias() {
  try {
    const response = await fetch("http://localhost:8080/categorias");
    if (!response.ok) {
      throw new Error("No se pudo obtener las categorías");
    }

    const categorias = await response.json();
    const contenedor = document.getElementById("categorias-container");
    contenedor.innerHTML = "";

    categorias.forEach((categoria) => {
      const card = document.createElement("div");
      card.className = "categoria-card";
      card.innerHTML = `
        <h3>${categoria.nombre}</h3>
        <p>${categoria.descripcion || "Sin descripción"}</p>
      `;
      contenedor.appendChild(card);
    });
  } catch (error) {
    console.error("Error al cargar categorías:", error);
    const contenedor = document.getElementById("categorias-container");
    contenedor.innerHTML = `<p style="color:red;">Error al cargar categorías</p>`;
  }
}

document.addEventListener("DOMContentLoaded", cargarCategorias);
