# 📦 API Comida

Este projeto foi desenvolvido como parte das atividades da FIAP.

## 🛠️ Tecnologias Utilizadas

*   **Java 17+**
*   **Spring Boot** (Web, Data JPA)
*   **MySQL** (Banco de Dados)
*   **Docker** (Infraestrutura)
*   **Lombok** (Produtividade)

---

## 🐳 Infraestrutura: Como subir o Banco de Dados

Para que a API funcione corretamente, é necessário ter um banco de dados MySQL rodando. Utilizamos o **Docker** para garantir que qualquer pessoa possa rodar a aplicação do zero de forma rápida e padronizada.

Siga os passos abaixo para subir o banco de dados:

1. Certifique-se de que o [Docker Desktop](https://www.docker.com/products/docker-desktop/) (ou o serviço do Docker na sua máquina) está instalado e rodando.
2. Abra o seu terminal e execute o seguinte comando:

```bash
docker run -d \
    --name mysql-fiap \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -e MYSQL_DATABASE=db_comidas \
    -p 3306:3306 \
    mysql:8.0
