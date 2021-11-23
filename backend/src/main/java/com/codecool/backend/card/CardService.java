package com.codecool.backend.card;

import com.codecool.backend.buckets.BucketName;
import com.codecool.backend.filestore.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@ComponentScan(basePackages = "com.codecool.backend.card")

public class CardService {
    private final CardRepository cardRepository;
    private final FileStore fileStore;

    @Autowired
    public CardService(CardRepository cardRepository, FileStore fileStore) {
        this.cardRepository = cardRepository;
        this.fileStore = fileStore;
    }



    List<Card> getCards(){
        System.out.println("Data found: " + cardRepository.findAll());
        return cardRepository.findAll();
    }

    public void uploadCardsImage(UUID cardId, MultipartFile file) {
        //1. Check if image is not empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [" + file.getSize() + "]");
        }

        //2. If file is an image
        if (!Arrays.asList(IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image");
        }

        //3. The user exists in the database
        Card cardInfo = cardRepository
                .findAll()
                .stream()
                .filter(card -> card.getCardId().equals(cardId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Card info %s not found", cardId)));

        //4. Grab metadata from the file if any
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //5.Store the image in s3 and update database (userProfileImageLink) with s3 image link
        String path = String.format("%s/%s", BucketName.PRODUCT_IMAGE.getBucketName(), cardInfo.getCardId());
        String fileName = String.format("%s-%s", file.getName(), UUID.randomUUID());

        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    public byte[] download(UUID id) {
        Card card = cardRepository.getById(id);
        return fileStore.download(card.getCardImagePath(), card.getImageFileName());
//        return fileStore.download("petprojectstorage", "serbia/1.jpg");
    }


}
