<%-- 
    Document   : rolesRegister
    Created on : Oct 9, 2024, 7:37:31 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body, html {
                height: 100%;
                margin: 0;
                font-family: Arial, sans-serif;
                background: url('img/lc-thumb-web.jpg') no-repeat center center fixed;
                background-size: cover;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .container {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                background: rgba(255, 255, 255, 0.8);
                padding: 20px;
                border-radius: 10px;
            }

            .role-link {
                display: block;
                width: 200px;
                padding: 15px;
                margin: 10px 0;
                text-align: center;
                text-decoration: none;
                color: #28a745;
                font-size: 20px;
                border: 2px solid #007bff;
                border-radius: 5px;
                background: white;
                transition: background-color 0.3s, color 0.3s;
            }

            .role-link:hover {
                background-color: #28a745;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <a href="login?role=customer" class="role-link">Customer</a>
            <a href="login?role=doctor" class="role-link">Doctor</a>
            <a href="login?role=admin" class="role-link">Admin</a>
        </div>
    </body>
</html>
