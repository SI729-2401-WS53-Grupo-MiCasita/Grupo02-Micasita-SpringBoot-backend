package pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.services.UserCommandService;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.services.UserQueryService;
import pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Resource.CreateUserResource;
import pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Resource.UserResource;
import pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Transform.CreateUserCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Transform.UserResourceFromEntityAssembler;


@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User", description = "User API")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;


    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var userId = userCommandService.handle(createUserCommand);

        if (userId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUser(@PathVariable Long id) {
        var getUserByIdQuery = new GetUserByIdQuery(id);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.OK);
    }


}
