package com.codecool.backend.card;

import com.codecool.backend.database.CardInfoDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@ComponentScan(basePackages = "com.codecool.backend.card")
public interface CardRepository extends JpaRepository<Card, UUID> {
//    private final CardInfoDataStore cardInfoDataStore;
//
//    @Autowired
//    public CardDataAccessService(CardInfoDataStore cardInfoDataStore) {
//        this.cardInfoDataStore = cardInfoDataStore;
//    }
//
//    List<Card> getCard() {
//        return cardInfoDataStore.getCard();
//    }
//    Card findById (UUID id);

}
