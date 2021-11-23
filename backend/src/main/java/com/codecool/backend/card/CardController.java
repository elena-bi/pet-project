package com.codecool.backend.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("http://localhost:3000/")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getCardProducts() {
        return cardService.getCards();
    }

    @PostMapping(
            path = "{cardId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadCardsImage(@PathVariable("cardId")UUID cardId,
                                 @RequestParam("file") MultipartFile file) {
        cardService.uploadCardsImage(cardId, file);
    }

    @GetMapping(value = "{id}/image/download")
    public byte[] downloadTodoImage(@PathVariable("id") UUID id) {
        return cardService.download(id);
    }


}
