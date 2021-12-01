<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Normalize CSS -->
    <link
      rel="stylesheet"
      href="https://necolas.github.io/normalize.css/8.0.1/normalize.css"
    />
    <!-- Estilos personalizados -->
    <link rel="stylesheet" href="../webapp/assets/styles/desktop.css" />
    <!-- JAM icons -->
    <link rel="stylesheet" href="https://unpkg.com/jam-icons/css/jam.min.css" />
    <title>Tierra Media - Login</title>
  </head>
  <body>
    <div class="content-wrapper main">
      <div class="header">
        <h1>tierra media</h1>
      </div>
      <div class="login">
        <div class="image-container">
          <img src="../webapp/assets/images/Login.png" alt="Imagen login" />
        </div>
        <div class="login-container">
          <div class="login-buttons-top">
            <a class="button-left" href="#">Sign in</a>
            <a class="button-right" href="#">Sign up</a>
          </div>
          <div class="login-content">
            <div class="login-input">
              <h2>username</h2>
              <input type="text" placeholder="Enter your username" />
            </div>
            <div class="login-checkbox">
              <a href="#" class="jam jam-check"></a>
              <p>I agree all statements in <a href="#">terms of service</a></p>
            </div>
            <div class="login-buttons-bottom">
              <a class="button" href="#">Sign Up</a>
              <a class="member" href="#">I'm already member</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>