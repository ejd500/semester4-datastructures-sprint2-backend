package com.keyin.trees.BinaryNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BinaryNodeConverter implements AttributeConverter<BinaryNode, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BinaryNode attribute) {
        // Convert BinaryNode to String representation for database storage
        // Implement your logic here, e.g., serialize BinaryNode to JSON
        if (attribute == null) {
            return null;
        }
        // Example: Convert BinaryNode to JSON string
        try {
            return serializeBinaryNodeToString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BinaryNode convertToEntityAttribute(String dbData) {
        // Convert database String representation back to BinaryNode
        // Implement your logic here, e.g., deserialize JSON to BinaryNode
        if (dbData == null) {
            return null;
        }
        // Example: Convert JSON string to BinaryNode
        try {
            return deserializeStringToBinaryNode(dbData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // Implement serialization and deserialization methods based on your requirements
    private String serializeBinaryNodeToString (BinaryNode binaryNode) throws JsonProcessingException {
        return objectMapper.writeValueAsString(binaryNode);
    }

    private BinaryNode deserializeStringToBinaryNode(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, BinaryNode.class);
    }
}
