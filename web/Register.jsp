<%-- 
    Document   : Register
    Created on : Sep 25, 2024, 4:58:31 AM
    Author     : Acer
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng Ký - Nhà Thuốc Long Châu</title>
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

            .register-container {
                background-color: rgba(255, 255, 255, 0.9);
                padding: 40px;
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
                border-radius: 15px;
                width: 400px;
                text-align: center;
                position: relative;
            }

            .register-container h1 {
                color: #0c64dc;
                margin-bottom: 20px;
                font-size: 32px;
                font-weight: bold;
            }

            .register-container form {
                margin-top: 0px;
            }

            .register-container .input-group {
                position: relative;
                margin-bottom: 10px;
            }

            .register-container .input-group input {
                width: 100%;
                padding: 15px 15px 15px 45px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
                box-sizing: border-box;
            }

            .register-container .input-group i {
                position: absolute;
                left: 15px;
                top: 50%;
                transform: translateY(-50%);
                color: #aaa;
                font-size: 18px;
            }

            .register-container input[type="submit"] {
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

            .register-container input[type="submit"]:hover {
                background-color: #094ea1;
            }

            .register-container a {
                display: block;
                margin-top: 10px;
                color: #0c64dc;
                text-decoration: none;
                transition: color 0.3s ease;
            }

            .register-container a:hover {
                color: #0072ff;
            }

            .register-container img {
                width: 120px;
                height: auto;
                margin-bottom: 20px;
            }

            .input-group {
                display: flex;
                align-items: center;
                gap: 10px;
            }

            .input-group input {
                flex: 1;
                padding: 8px;
                box-sizing: border-box;
            }

            .input-group i {
                margin-right: 5px;
            }

            .input-group select {
                width: 79.5%;
                padding: 8px;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body>

        <div class="register-container">
            <!-- Logo của nhà thuốc Long Châu -->
            <img src="https://vectorseek.com/wp-content/uploads/2023/10/FPT-Retail-Nha-thuoc-Long-Chau-Logo-Vector.svg-.png" alt="Nhà Thuốc Long Châu Logo">
            <h1>Đăng Ký</h1>
            <form action="register" method="post">
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="firstName" name="firstName" placeholder="Họ khách hàng" required>                
                    <i class="fas fa-user"></i>
                    <input type="lastName" name="lastName" placeholder="Tên khách hàng" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="username" name="username" placeholder="Tên đăng nhập" required>
                </div>
                <label class="label-custom" style="margin-right: 330px; color: #000">Sinh nhật</label>
                <div class="input-group">
                    <i class="fas fa-calendar"></i>
                    <input type="date" name="dob" required>
                </div>
                <div class="input-group">    
                    <label class="label-custom" style="margin-right: 10px; color: #000">Giới tính</label>
                    <select name="gender" style="" required>
                        <option value="1">Male</option>
                        <option value="2">Female</option>
                    </select>
                </div>
                <div class="input-group">
                    <i class="fas fa-phone"></i>
                    <input type="phone" name="phone" placeholder="Phone" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-envelope"></i>
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="password" placeholder="Mật khẩu" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="re_password" placeholder="Xác nhận mật khẩu" required>
                </div>
                <h6 style="padding: 5px 0; color: #F44336">${error}</h6>
                <input type="submit" value="Đăng Ký">
            </form>
            <a href="rolesLogin.jsp">Đã có tài khoản? Đăng nhập</a>
        </div>

    </body>
</html>

