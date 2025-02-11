package me.dio.claro_java_spring_boot.adapter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.claro_java_spring_boot.usecase.*;
import me.dio.claro_java_spring_boot.usecase.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(
        name = "Users Controller",
        description = "RESTful API for managing users."
)
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private FindAllUserUseCase findAllUserUseCase;

    @Autowired
    private FindByIdUserUseCase findByIdUserUseCase;

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private DeleteUserUseCase deleteUserUseCase;

    @GetMapping
    @Operation(
        summary = "Get all users",
        description = "Retrieve a list of all registered users"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operation successful"
        )
    })
    public ResponseEntity<List<UserOutputDto>> findAll() {
        return ResponseEntity.ok(this.findAllUserUseCase.execute());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID", description = "Retrieve a specific user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserOutputDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.findByIdUserUseCase.execute(id));
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user and return the created user's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<UserOutputDto> create(@RequestBody UserCreateDto userCreateDtoo) {
        UserOutputDto user = createUserUseCase.execute(userCreateDtoo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/")
    @Operation(summary = "Update a user", description = "Update the data of an existing user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<UserOutputDto> update(@RequestBody UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(updateUserUseCase.execute(userUpdateDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Delete an existing user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
