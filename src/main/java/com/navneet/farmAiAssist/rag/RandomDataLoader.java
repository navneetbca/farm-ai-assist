package com.navneet.farmAiAssist.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RandomDataLoader {

    private final VectorStore vectorStore;

    public RandomDataLoader(VectorStore vectorStore){
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadSentencesIntoVectorStore(){
        List<String> sentences = List.of(
            "A tractor is a powerful vehicle used to pull farming machinery and perform heavy agricultural tasks.",
            "Tractors are commonly used for plowing, tilling, planting, and transporting materials on farms.",
            "A plough is a farm implement used to turn and loosen the soil before planting crops.",
            "A cultivator is used to break up soil clumps and remove weeds between crop rows.",
            "A seed drill helps farmers sow seeds evenly at the correct depth in the soil.",
            "A harrow is used to smooth and level the soil after ploughing.",
            "A rotavator is a tractor attachment used to prepare soil quickly for planting.",
            "A trailer attached to a tractor is used to transport crops, fertilizer, and farm tools.",
            "A sprayer is used to apply pesticides, herbicides, and fertilizers to crops.",
            "A thresher separates grain from harvested crop plants like wheat and rice.",
            "Wheat is a major cereal crop grown in many parts of the world.",
            "Rice is a staple food crop that grows well in water-rich fields.",
            "Maize is widely used for food, livestock feed, and industrial products.",
            "Sugarcane is a cash crop used to produce sugar and ethanol.",
            "Cotton is grown for its fiber used in textile production.",
            "Pulses such as lentils and chickpeas are important sources of protein.",
            "Mustard is an oilseed crop used to produce edible oil.",
            "Groundnut is a crop grown for oil and protein-rich seeds.",
            "Millets are drought-resistant crops grown in dry regions.",
            "Vegetables such as tomatoes, onions, and potatoes are commonly grown on farms.",
            "Nitrogen fertilizer helps plants grow strong green leaves.",
            "Phosphorus fertilizer supports root development in plants.",
            "Potassium fertilizer improves crop resistance to disease and drought.",
            "Urea is a widely used nitrogen fertilizer in agriculture.",
            "DAP fertilizer provides both nitrogen and phosphorus for crops.",
            "Organic manure comes from animal waste and improves soil fertility.",
            "Compost is made from decomposed organic matter and enriches the soil.",
            "Farmyard manure is created from cattle dung and crop waste.",
            "Irrigation provides water to crops when rainfall is insufficient.",
            "Drip irrigation delivers water directly to plant roots and reduces water wastage.",
            "Sprinkler irrigation distributes water over crops like rainfall.",
            "Canal irrigation uses water from rivers and dams for farming.",
            "Crop rotation means growing different crops in the same field in different seasons.",
            "Crop rotation helps maintain soil fertility and reduces pests.",
            "Weeds are unwanted plants that compete with crops for nutrients and water.",
            "Herbicides are chemicals used to control weeds in fields.",
            "Pesticides are used to protect crops from harmful insects.",
            "Farmers test soil to understand nutrient levels before applying fertilizers.",
            "Harvesting is the process of collecting mature crops from the field.",
            "Storage of grains in silos or warehouses helps prevent post-harvest losses.",
            "Weather conditions such as rainfall and temperature affect crop growth.",
            "Modern farmers use GPS and technology to improve farming efficiency.",
            "Agricultural drones can monitor crop health and spray fertilizers.",
            "Livestock farming includes raising cows, goats, and poultry for food products.",
            "Dairy farming focuses on producing milk and milk products.",
            "Healthy soil is important for growing high-quality crops.",
            "Farmers often use tractors with different attachments to perform various farming tasks.",
            "Proper fertilizer use increases crop yield and improves soil health.",
            "Good irrigation management helps farmers grow crops even during dry seasons."
        );
        List<Document> documents = sentences.stream().map(Document::new).collect(Collectors.toList());
        vectorStore.add(documents);
    }

}
