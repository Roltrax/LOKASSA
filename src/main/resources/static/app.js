// Función para renderizar categorías
function renderCategorias(categorias) {
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
}

// Función principal para cargar categorías
async function cargarCategorias() {
  const contenedor = document.getElementById("categorias-container");
  contenedor.innerHTML = "<p>Cargando categorías...</p>";

  try {
    const response = await fetch("http://localhost:8080/categorias");
    if (!response.ok) {
      throw new Error("No se pudo obtener las categorías");
    }

    const categorias = await response.json();
    renderCategorias(categorias);
  } catch (error) {
    console.error("Error al cargar categorías:", error);
    contenedor.innerHTML = `<p style="color:red;">${error.message}</p>`;
  }
}

// Ejecutar al cargar la página
document.addEventListener("DOMContentLoaded", cargarCategorias);
