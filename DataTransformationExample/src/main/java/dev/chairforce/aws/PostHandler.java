package dev.chairforce.aws;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Handler for requests to Lambda function.
 */
public class PostHandler implements RequestHandler<Map<String,String>, Map<String,String>> {

    public Map<String, String> handleRequest(final Map<String,String> input, final Context context) {

        String firstName = input.get("firstName");
        String lastName = input.get("lastName");
        String age = input.get("age");
        String email = input.get("email");
        String password = input.get("password");
        String repeatPassword = input.get("repeatPassword");
        String secretKey = input.get("secretKey");

        LambdaLogger logger = context.getLogger();
        logger.log("\n firstName = " + firstName);
        logger.log("\n lastName = " + lastName);
        logger.log("\n email = " + email);
        logger.log("\n age = " + age);
        logger.log("\n secretKey = " + secretKey);

        Map<String, String> response = new HashMap<>();
        response.put("id", UUID.randomUUID().toString());
        response.put("firstName", firstName);
        response.put("lastName", lastName);
        response.put("age", age);
        response.put("email", email);

        return response;
    }

}
