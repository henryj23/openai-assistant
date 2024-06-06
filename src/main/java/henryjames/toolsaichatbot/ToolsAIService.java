package henryjames.toolsaichatbot;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.Generation;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolsAIService {

	@Autowired
	AiClient aiClient;
	
	
	public String getPopularTouristPlaces(String city, String nation) {
		
		String query = String.format("You are a cool AI assistant. Please get me "
				+ "a list of must visit places in {city}, {nation}", city, nation);
		
		PromptTemplate template = new PromptTemplate(query);
		
		template.add("city", city);
		
		template.add("nation", nation);
		
		System.out.println(query);
		
		Prompt prompt = template.create();
		
		Generation generation = aiClient.generate(prompt).getGeneration();
		
		String response = generation.getText();
		
		return response;
	}
	
	public String getVarieties(String topic, String location) {
		
		String query = String.format("You are a cool AI assistant. Please get me "
				+ "a list of {topic} in {location} in list format", topic, location);
		
		PromptTemplate template = new PromptTemplate(query);
		
		template.add("topic", topic);
		
		template.add("location", location);
		
		
		
		System.out.println(query);
		
		Prompt prompt = template.create();
		
		Generation generation = aiClient.generate(prompt).getGeneration();
		
		String response = generation.getText();
		
		return response;
		
	}
	
	public String compareProducts(String prod1, String prod2) {
		
		String query = String.format("You are a cool AI assistant. Please compare "
				+ "product {prod1} and product {prod2}", prod1, prod2);
		
		PromptTemplate template = new PromptTemplate(query);
		
		template.add("prod1", prod1);
		
		template.add("prod2", prod2);
		
		System.out.println(query);
		
		Prompt prompt = template.create();
		
		Generation generation = aiClient.generate(prompt).getGeneration();
		
		String response = generation.getText();
		
		return response;
		
	}
	
	public String getRecipe(String recipe) {
		
		String query = String.format("You are a cool AI assistant. Please give me a recipe for {recipe}", recipe);
		
		PromptTemplate template = new PromptTemplate(query);
		
		template.add("recipe", recipe);
		
		System.out.println(query);
		
		Prompt prompt = template.create();
		
		Generation generation = aiClient.generate(prompt).getGeneration();
		
		String response = generation.getText();
		
		return response;
		
	}
}
