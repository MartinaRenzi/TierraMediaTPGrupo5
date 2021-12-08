    <!-- HEADER SECTION -->
    <nav class="nav-container">
      <div class="content-wrapper">
        <div class="nav-title">
          <div class="logo">Tierra Media</div>
        </div>
        <div class="nav-menu">
          <div class="action">
            <div class="profile" onclick="menuToggle();">
              <a class="ri-user-line" href="#"></a>
            </div>
            <div class="menu">
              <h3>User<br /><span>User / Admin</span></h3>
              <ul>
                <li>
                  <img src="/torre/assets/img/user.png" alt="user" /><a href="#"
                    >Mi perfil</a
                  >
                </li>
                <li>
                  <img src="/torre/assets/img/edit.png" alt="edit" /><a href="#"
                    >Itinerario</a
                  >
                </li>
                <li>
                  <img src="/torre/assets/img/log-out.png" alt="log-out" /><a href="/torre/logout"
                    >Cerrar sesion</a
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>
    
        <!-- Menu -->
    <div class="menu-container">
      <div class="wrapper content-wrapper">
        <nav>
          <input type="checkbox" id="show-search" />
          <input type="checkbox" id="show-menu" />
          <label for="show-menu" class="menu-icon"
            ><i class="fas fa-bars"></i
          ></label>
          <div class="content">
            <ul class="links">
              <li><a href="#">Atracciones</a></li>
              <li><a href="#">Promociones</a></li>
              <li><a href="#">Comprar Boletos</a></li>
              <li><a href="#">Itinerario</a></li>
            </ul>
          </div>
          <label for="show-search" class="search-icon"
            ><i class="fas fa-search"></i
          ></label>
          <form action="#" class="search-box">
            <input
              type="text"
              placeholder="Escribe algo para buscar..."
              required
            />
            <button type="submit" class="go-icon">
              <i class="fas fa-long-arrow-alt-right"></i>
            </button>
          </form>
        </nav>
      </div>
    </div>