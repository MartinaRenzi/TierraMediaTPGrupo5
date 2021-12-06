<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
  <head>
		<jsp:include page="partials/head.jsp"></jsp:include>
  </head>
<body>
 <!-- HEADER SECTION -->
    <jsp:include page="partials/header.jsp"></jsp:include>

    <!-- MAIN SECTION -->
    <main>
      <!-- Product -->
      <section class="product-section">
        <div class="product-container content-wrapper">
          <div class="product-content">
            <div class="product-image">
              <img src="/torre/assets/img/product.png" alt="imagen-producto" />
            </div>
            <div class="product-info">
              <div class="product-title">
                <h1>attraction title</h1>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Et
                  exercitationem ipsam sint excepturi, voluptate modi fugiat
                  autem ut quos, quam deleniti cum corrupti reprehenderit eius
                  pariatur magni? Porro, molestias voluptates. Officiis culpa
                  unde a vero.
                </p>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Excepturi, doloremque provident esse amet est veritatis totam
                  expedita maxime pariatur doloribus rem unde laborum suscipit
                  id eaque earum nostrum eius ad atque. Minima, nobis nisi
                  quidem culpa repellat sit praesentium! Sunt?
                </p>
              </div>
              <div class="product-box">
                <h2>$999.00</h2>
                <div class="product-buttons">
                  <a href="#" class="button-1">buy now</a>
                  <a href="#" class="ri-heart-line button-2"></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>


    <!-- FOOTER -->
   <jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>