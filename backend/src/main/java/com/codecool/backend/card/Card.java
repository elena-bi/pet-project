package com.codecool.backend.card;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Card {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID cardId;

    @Column
    @NotEmpty
    private String title;

    @Column
    @NotEmpty
    private String content;

    @Column
    @NotEmpty
    private String cardImagePath; //S3 link/key

    @Column
    @NotEmpty
    private String imageFileName; //for the bucket?

    public Card(UUID cardId, String title, String content, String cardImagePath, String imageFileName) {
        this.cardId = cardId;
        this.title = title;
        this.content = content;
        this.cardImagePath = cardImagePath;
        this.imageFileName = imageFileName;
    }

    public Card() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCardImagePath() {
        return cardImagePath;
    }

    public void setCardImagePath(String cardImagePath) {
        this.cardImagePath = cardImagePath;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(cardId, card.cardId) &&
                Objects.equals(title, card.title) &&
                Objects.equals(cardImagePath, card.cardImagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, title, cardImagePath);
    }
}
