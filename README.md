# Spring-Security-Static-Key-Auth-Filter

This project provides a custom Spring Security filter that performs authentication based on a static authorization key.
The filter checks if the `Authorization` header matches a pre-configured key, and if not, returns a `401 Unauthorized`
status.

## Key Features

- Performs authentication using a static `Authorization` key.
- Responds with a `401 Unauthorized` status if the header does not match the expected key.

## Usage

Integrate this filter into your Spring Security filter chain to authenticate requests using a static authorization key.

## Testing

- **Valid Request (200 OK)**:  
  To see a successful request, after starting the application, use the following curl command with the
  correct `Authorization` header:
  ```bash
  curl -vH "Authorization:Yk2hUtqJ2/0n/xosBxLQTzpaPrQe7Ir9YkMdQnJhIl8=" http://localhost:8080/hello
  ```

- **Invalid Request (401 Unauthorized)**:  
  To simulate an invalid request, use the following curl command (without the Authorization header or with an incorrect
  key):
  ```bash
  curl -v http://localhost:8080/hello
  ```