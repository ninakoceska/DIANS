import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WineryDataProcessor {

    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\Asus\\Desktop\\DOMASNA 1\\main\\winery_data.json";
            JsonNode rootNode = readJsonFile(filePath);

            // Assuming "data" is an array containing your features
            JsonNode dataArray = rootNode.path("data");

            for (JsonNode featureNode : dataArray) {
                JsonNode propertiesNode = featureNode.path("properties");

                // Extract and print elements from the "properties" field
                String id = propertiesNode.path("@id").asText();
                String amenity = propertiesNode.path("amenity").asText();
                String name = propertiesNode.path("name").asText();
                String shop = propertiesNode.path("shop").asText();
                String int_name = propertiesNode.path("int_name").asText();

                // Extract coordinates from the "geometry" field
                JsonNode geometryNode = featureNode.path("geometry");
                JsonNode coordinatesNode = geometryNode.path("coordinates");

                // Check if coordinatesNode is not null and has the expected structure
                if (coordinatesNode.isArray() && coordinatesNode.size() > 0) {
                    JsonNode firstCoordinate = coordinatesNode.get(0).get(0);

                    // Check if firstCoordinate is not null and has the expected structure
                    if (firstCoordinate != null && firstCoordinate.isArray() && firstCoordinate.size() == 2) {
                        double longitude = firstCoordinate.get(0).asDouble();
                        double latitude = firstCoordinate.get(1).asDouble();

                        System.out.println("ID: " + id);
                        System.out.println("Amenity: " + amenity);
                        System.out.println("Name: " + name);
                        System.out.println("Shop: " + shop);
                        System.out.println("International Name: " + int_name);
                        System.out.println("Coordinates: (" + latitude + ", " + longitude + ")");
                        System.out.println("--------------");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonNode readJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(new File(filePath));
    }
    private static boolean isWineryFeature(String jsonFeature) {
        // Add logic to determine if a GeoJSON feature represents a winery
        return jsonFeature.contains("winery") &&
                (jsonFeature.contains("\"email\"") ||
                        jsonFeature.contains("\"name:en\"") ||
                        jsonFeature.contains("\"name:mk\"") ||
                        jsonFeature.contains("\"opening_hours\"") ||
                        jsonFeature.contains("\"phone\"") ||
                        jsonFeature.contains("\"addr:street\"") ||
                        jsonFeature.contains("\"addr:postcode\"") ||
                        jsonFeature.contains("\"addr:housenumber\"") ||
                        jsonFeature.contains("\"website\"") ||
                        jsonFeature.contains("\"tasting\""));
    }

    private static String transformDataForDatabase(String wineryData) {
        // Add logic to transform GeoJSON feature into a format suitable for database insertion
        StringBuilder transformed = new StringBuilder("Transformed:\n");

        appendIfPresent(transformed, wineryData, "Email", "\"email\"");
        appendIfPresent(transformed, wineryData, "English Name", "\"name:en\"");
        appendIfPresent(transformed, wineryData, "Macedonian Name", "\"name:mk\"");
        appendIfPresent(transformed, wineryData, "Opening Hours", "\"opening_hours\"");
        appendIfPresent(transformed, wineryData, "Phone", "\"phone\"");
        appendIfPresent(transformed, wineryData, "Address", "\"addr:street\"");
        appendIfPresent(transformed, wineryData, "Postcode", "\"addr:postcode\"");
        appendIfPresent(transformed, wineryData, "Housenumber", "\"addr:housenumber\"");
        appendIfPresent(transformed, wineryData, "Website", "\"website\"");
        appendIfPresent(transformed, wineryData, "Tasting", "\"tasting\"");

        return transformed.toString();
    }

    private static void appendIfPresent(StringBuilder sb, String wineryData, String label, String property) {
        if (wineryData.contains(property)) {
            sb.append(label).append(": ").append(getPropertyValue(wineryData, property)).append("\n");
        } else {
            sb.append(label).append(": N/A\n");
        }
    }

    private static String getPropertyValue(String wineryData, String property) {
        int start = wineryData.indexOf(property) + property.length() + 3; // Assuming property values are enclosed in double quotes
        int end = wineryData.indexOf("\"", start);
        return wineryData.substring(start, end);
    }

    private static void insertDataIntoDatabase( List<String> data) {
        // Simulated database insertion
        System.out.println("Inserting data into the database:");
        data.forEach(System.out::println);
    }

}
