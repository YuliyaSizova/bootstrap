package wtf.small.bootstrap;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Api(value = "sample-controller", description = "Controller with a couple of examples. For testing purposes only")
@RestController
public class EchoController {
    private static Logger log = LoggerFactory.getLogger(EchoController.class);

    @ApiOperation(
            value = "time",
            notes = "Returns current time as a string",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Current time as a string", response = String.class)
    })
    @GetMapping("/time")
    public String time() {
        String now = LocalDateTime.now().toString();
        log.debug("Passing time {}", now);
        return now;
    }

    @ApiOperation(
            value = "echo",
            notes = "Returns an echo of a posted JSON",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Parsed and returned JSON from a POST body"),
            @ApiResponse(code = 500, message = "Error if request was incorrect")
    })
    @PostMapping(value = "/echo")
    public Map<String, Object> echo(
            @ApiParam(name = "body", value = "POST body as a JSON", required = true, example = "{\n" +
                    "\t\"answer\": 42,\n" +
                    "\t\"question\": \"unknown\",\n" +
                    "\t\"composite\": {\n" +
                    "\t\t\"something\": \"something\"\n" +
                    "\t}\n" +
                    "}")
            @RequestBody Map<String, Object> body) {
        log.debug("Echoing data: {}", body);
        return body;
    }
}
