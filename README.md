# Java Servlet Lifecycle and Configuration

## 📌 Project Overview

This project demonstrates the creation, configuration, and lifecycle of Java Servlets. It also includes how to use core servlet-related classes, handle request forwarding and redirection, and access request and response headers.

---

## 🎯 Learning Objectives

- Understand the **creation and configuration** of a Java Servlet using annotations (`@WebServlet`) and `web.xml`.
- Explore the **lifecycle of a Servlet**:
  - `init()` – Called once when the servlet is initialized (e.g., reads parameters from `web.xml`).
  - `service()` – Called for each request, runs in a separate thread.
  - `destroy()` – Called once when the servlet is taken out of service.
- Use core classes:
  - `ServletContext`
  - `HttpServletRequest`
  - `HttpServletResponse`
- Learn **request forwarding** (same request) and **redirection** (new request):
  - `RequestDispatcher.forward()` – forwards within the same domain.
  - `HttpServletResponse.sendRedirect()` – redirects to a different resource or domain.
- Read **headers** from requests and external responses:
  - `request.getHeaderNames()`
  - Using `URLConnection` to read response headers from another site.

---

## 🛠️ Technologies Used

- Jakarta EE 10 / 11 (Servlet API 6.0)
- Java 21+
- GlassFish / Tomcat 10
- Maven

---

## 📂 Sample Configuration

### `web.xml`

```xml
<web-app version="6.0" xmlns="https://jakarta.ee/xml/ns/jakartaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd">

    <servlet>
        <servlet-name>HelloWorldXML</servlet-name>
        <servlet-class>com.mycompany.firstservlet.HelloWorldXML</servlet-class>
    </servlet>

    <servlet>
        <servlet-name>GuessColor</servlet-name>
        <servlet-class>com.mycompany.firstservlet.GuessColor</servlet-class>
        <init-param>
            <param-name>color</param-name>
            <param-value>green</param-value>
        </init-param>
    </servlet>

</web-app>
