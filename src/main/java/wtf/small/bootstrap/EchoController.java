package wtf.small.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class EchoController {
    private static Logger log = LoggerFactory.getLogger(EchoController.class);

    @RequestMapping("/time")
    public String time() {
        String now = LocalDateTime.now().toString();
        log.debug("Passing time {}", now);
        return now;
    }

    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public Map<String, Object> echo(@RequestBody Map<String, Object> body) {
        log.debug("Echoing data: {}", body);
        return body;
    }
}
