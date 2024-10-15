<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng Nhập - Nhà Thuốc Long Châu</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <style>
            body {
                font-family: 'Roboto', sans-serif;
                background: linear-gradient(to right, #00c6ff, #0072ff);
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
                color: #fff;
            }

            .login-container {
                background-color: rgba(255, 255, 255, 0.9);
                padding: 40px;
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
                border-radius: 15px;
                width: 400px;
                text-align: center;
                position: relative;
            }

            .login-container h1 {
                color: #0c64dc;
                margin-bottom: 20px;
                font-size: 32px;
                font-weight: bold;
            }

            .login-container form {
                margin-top: 20px;
            }

            .login-container .input-group {
                position: relative;
                margin-bottom: 20px;
            }

            .login-container .input-group input {
                width: 100%;
                padding: 15px 15px 15px 45px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
                box-sizing: border-box;
            }

            .login-container .input-group i {
                position: absolute;
                left: 15px;
                top: 50%;
                transform: translateY(-50%);
                color: #aaa;
                font-size: 18px; /* Điều chỉnh kích thước icon */
            }

            .login-container input[type="submit"] {
                background-color: #0c64dc;
                color: #fff;
                border: none;
                padding: 15px 0;
                border-radius: 5px;
                width: 100%;
                font-size: 18px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .login-container input[type="submit"]:hover {
                background-color: #094ea1;
            }

            .login-container a {
                display: block;
                margin-top: 10px;
                color: #0c64dc;
                text-decoration: none;
                transition: color 0.3s ease;
            }

            .login-container a:hover {
                color: #0072ff;
            }

            .login-container img {
                width: 120px;
                height: auto;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>

        <div class="login-container">

            <img src="https://vectorseek.com/wp-content/uploads/2023/10/FPT-Retail-Nha-thuoc-Long-Chau-Logo-Vector.svg-.png" alt="Nhà Thuốc Long Châu Logo">
            <h1>Đăng Nhập</h1>
            <form action="login" method="post">
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="text" name="username" placeholder="Tên đăng nhập"
                           value="${username != null ? username : ''}" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="password" placeholder="Mật khẩu" required>
                </div>
                <c:if test="${not empty error}">
                    <div class="error" style="color: #F44336; padding-bottom: 10px">${error}</div>
                </c:if>
                <input type="submit" value="Đăng Nhập">
            </form>
            <a href="ResetPassword.jsp">Quên mật khẩu?</a>
            <a href="Register.jsp">Tạo tài khoản mới</a>
        </div>
    </body>
</html>
