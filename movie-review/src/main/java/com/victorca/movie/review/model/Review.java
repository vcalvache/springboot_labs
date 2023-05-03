package com.victorca.movie.review.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {
    @Id
    private ObjectId id;
    private String reviewBody;

    public Review(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
