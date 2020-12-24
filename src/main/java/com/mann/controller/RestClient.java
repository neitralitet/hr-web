package com.mann.controller;

import com.mann.dto.Department;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.mann.dto.Employee;
import javax.annotation.PostConstruct;

/**
 * @author Vladimir Mann
 */

@SpringBootApplication
@RestController
@RequestMapping("/")
public class RestClient {


    WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080/api/v1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }



    @GetMapping("/employees")
    public Flux<Employee> trackAllEmployees() {
        return  webClient.get().uri("/employees").retrieve().bodyToFlux(Employee.class);
    }

    @GetMapping("/employees/{employeesId}")
    public Mono<Employee> getEmployeesById(@PathVariable int employeesId) {
        return webClient.get().uri("/employees/" + employeesId).retrieve().bodyToMono(Employee.class);
    }

    @DeleteMapping("/employees/{employeesId}")
    public Mono<String> deleteEmployees(@PathVariable int employeesId) {
        return webClient.delete().uri("/employees/" + employeesId).retrieve().bodyToMono(String.class);
    }

    @PutMapping("/employees/{employeesId}")
    public Mono<Employee> updateEmployees(@PathVariable int employeesId, @RequestBody Employee request) {
        return webClient.put().uri("/employeesId/" + employeesId).syncBody(request).retrieve()
                .bodyToMono(Employee.class);
    }


    @GetMapping("/departments")
    public Flux<Department> trackAllDepartment() {
        return  webClient.get().uri("/departments").retrieve().bodyToFlux(Department.class);
    }

    @GetMapping("/departments/{departmentsId}")
    public Mono<Department> getDepartmentById(@PathVariable int departmentsId) {
        return webClient.get().uri("/departments/" + departmentsId).retrieve().bodyToMono(Department.class);
    }

    @DeleteMapping("/departments/{departmentsId}")
    public Mono<String> deleteDepartment(@PathVariable int departmentsId) {
        return webClient.delete().uri("/departments/" + departmentsId).retrieve().bodyToMono(String.class);
    }

    @PutMapping("/departments/{departmentsId}")
    public Mono<Department> updateDepartment(@PathVariable int departmentsId, @RequestBody Department request) {
        return webClient.put().uri("/departmentsId/" + departmentsId).syncBody(request).retrieve()
                .bodyToMono(Department.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestClient.class, args);
    }
}


