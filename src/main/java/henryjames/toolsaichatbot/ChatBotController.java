package henryjames.toolsaichatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {
	
	
	@Autowired
	private ToolsAIService aiService;
	
	@GetMapping("/tourist-places")
	public String fetchPopularTouristDestination(@RequestParam String city, @RequestParam String nation) {
		
		String openAiResponse = aiService.getPopularTouristPlaces(city, nation);
		
		return openAiResponse;
	}
	
	@GetMapping("/list-varieties")
	public String listAvailiables(@RequestParam String topic, @RequestParam String location) {
		
		String openAiResponse = aiService.getVarieties(topic, location);
		
		return openAiResponse;
	}
	@GetMapping("/compare-products")
	public String compareProducts(@RequestParam String prod1, @RequestParam String prod2) {
		
		String openAiResponse = aiService.getVarieties(prod1, prod2);
		
		return openAiResponse;
	}
	@GetMapping("/getRecipe")
	public String getRecipe(@RequestParam String recipe) {
		
		String openAiResponse = aiService.getRecipe(recipe);
		
		return openAiResponse;
		
	}
	
	

}
