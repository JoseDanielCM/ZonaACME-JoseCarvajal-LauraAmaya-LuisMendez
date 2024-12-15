# 🌆 Zona ACME
<p align="center">
  <img src="src/Img/logoZona.png" alt="Imagen referencial" width="500" />
</p>

Bienvenido a **Zona ACME**, un sistema desarrollado en Java con una interfaz visual amigable y diseñado para gestionar de manera sencilla las entradas y salidas de trabajadores e invitados de la zona empresarial, permitiendo almacenar toda la trazabilidad en una base de datos.

---

## 🔧 Requisitos de Instalación

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

1. 📁 **Software necesario**:
   - Java Development Kit (JDK) 17 o superior.
   - Un IDE como IntelliJ IDEA, Eclipse o NetBeans (opcional pero recomendado).

2. 📊 **Base de datos**:
   - Un servidor MySQL funcionando.
   - Un usuario de **superusuario** creado en la base de datos para garantizar los permisos necesarios.

---

## 🚀 Instalación y Configuración

Sigue estos pasos para instalar y ejecutar el programa:

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/JoseDanielCM/ZonaACME-JoseCarvajal-LauraAmaya-LuisMendez
   ```

2. **Importa el proyecto a tu IDE favorito**:
   - Si estás usando IntelliJ IDEA, selecciona `File > Open` y elige la carpeta del proyecto.

3. **Configura la base de datos:**
   - Crea una base de datos en MySQL ejecutando el archivo [`src/Sql/ddl.sql`](src/Sql/ddl.sql).
     ```bash
     mysql -u tu_usuario -p tu_contraseña < src/Sql/ddl.sql
     ```
   - Asegúrate de tener un usuario con los permisos necesarios.

4. **Ejecuta la aplicación:**
   - Corre el archivo `Main.java`.

---

## 🔍 Uso del Programa

1. Al ejecutar el programa, se abrirá una interfaz gráfica para interactuar.
2. Accede como superusuario para realizar configuraciones iniciales.
3. Explora las funcionalidades disponibles para gestionar los datos de tu base.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 🚀
- **Base de Datos**: MySQL 🏢
- **Interfaz Gráfica**: Swing 🎨

---

## 📔 Documentación Adicional

Consulta el archivo [`Documentación del Sistema Gestor de Acceso - Zona Acme.pdf`](Documentación del Sistema Gestor de Acceso - Zona Acme.pdf) para obtener instrucciones detalladas y guías de uso.

---

## 📢 Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar, por favor abre un issue o envía un pull request.

---

## 🌍 Autor

Proyecto desarrollado por
- **Jose Carvajal:** jodacarmon@gmail.com
- **Laura Amaya:** laurasofiaamayacasado@gmail.com
- **Nicolás Méndez:** nicolas-mendez@hotmail.com
---


> 💡 Si encuentras problemas o tienes dudas, no dudes en crear un issue en el repositorio o contactar al autor.
