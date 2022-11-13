package projects.tempAssignment.Temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

	@GetMapping("/Temp")
	public String GetTemp() {
		return "This is a greeting Eee";
	}
}
