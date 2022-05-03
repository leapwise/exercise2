# Exercise

Implement logical expression evaluator.

## Specification
Your application should expose two HTTP endpoints:

### API Definition: 

```
/expression
```

### API Input:

This API endpoint should take name of the logical expression and its value:

### API Response:

For each request executed against the API endpoint you should return an unique identifier that represents the identifier of logical expression.

### Workflow:

When this API is being called new logical expression should be created and identifier of newly created logical expression is returned.

### Example:

Name: Complex logical expression
Value: customer.name != "JOHN" && customer.salary < 100 AND (customer.type != null || customer.lastName != 'DOE')

### API Definition: 

```
/evaluate
```

### API Input:

This API endpoint takes expression ID and JSON object as input.

### API Output:

Returns the result of evaluation by using the requested expression and provided JSON object.

### Workflow:

When this API is being called requested logical expression should be evaluated using the provied JSON object.

## Additional Information
You should use following frameworks for your work.

Spring JPA
H2 database running in memory (data will not be persistent across application restarts)
You are free to add / change any libraries which you might need to solve this exercise, the only requirement is that we do not have to setup / install any external software to run this application.

Running the exercise with maven

```mvn spring-boot:run```

### Commiting
You will provide your solution by creating a feature branch using your name (i.e. feature/{your name}]) and pushing it to this repository.
