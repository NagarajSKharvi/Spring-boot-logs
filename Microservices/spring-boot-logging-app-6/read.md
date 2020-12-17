Using @SLF4J Annotation in Java class

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CallController {
	
	@GetMapping("/rest")
	public String getMessage() {
		log.debug("{} : {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		return "Rest Call working";
	}
	
}
