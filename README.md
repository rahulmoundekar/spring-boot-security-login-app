# spring-boot-security-login-app
spring boot security login application

Spring Boot application automatically requires the Basic Authentication for all HTTP Endpoints. The Endpoint “/” and “/home” does not require any authentication.

## Spring security Overview

Spring security is the highly customizable authentication and access-control framework. This is the security module for securing spring applications. But, this can also be used for non-spring based application with few extra configurations to enable the security features. Spring Security is a framework that focuses on providing both authentication and authorization to Java applications.
  
  ### “Authentication” is the process of establishing a principal is who they claim to be (a “principal” generally means a user, device or some other system which can perform an action in your application).
  
  ### “Authorization” refers to the process of deciding whether a principal is allowed to perform an action within your application. To arrive at the point where an authorization decision is needed, the identity of the principal has already been established by the authentication process. These concepts are common, and not at all specific to Spring Security.
  
## Authentication

    Let’s consider a standard authentication scenario that everyone is familiar with.

    A user is prompted to log in with a username and password.
    The system verifies that the password is correct for the username.
    The context information for that user is obtained their list of roles and so on.
    A security context is established for the user
    The user proceeds, potentially to perform some operation which is potentially protected by an access control mechanism which checks the required permissions for the operation against the current security context information.
   ### The following are the steps to achieve the authentication:
   
    1}Authentication is an interface which has several implementations for different authentication models. For a simple user name and password authentication, spring security would use UsernamePasswordAuthenticationToken. When user enters username and password, system creates a new instance of UsernamePasswordAuthenticationToken.
    2} The token is passed to an instance of AuthenticationManager for validation. Internally what AuthenticationManager will do is to iterate the list of configured AuthenticationProvider to validate the request. There should be at least one provider to be configured for the valid authentication.
    3} The AuthenticationManager returns a fully populated Authentication instance on successful authentication.
    4} The final step is to establish a security context by invoking SecurityContextHolder.getContext().setAuthentication(), passing in the returned authentication object.
    
## Dependencies pom.xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
## UserDetailsService
   It represents a principal, but in an extensible and application-specific way. Think of UserDetails as the adapter between your own user database and what Spring Security needs inside the SecurityContextHolder. UserDetailsService is a core interface in spring security to load user specific data. This interface is considered as user DAO and will be implemented by specific DAO implementations.
  
    
    
    
