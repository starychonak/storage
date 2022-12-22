package controller.impl;

import controller.StorageApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController implements StorageApi {

    @Override
    public ResponseEntity<Object> createStorage(Object body) {
        return ResponseEntity.ok("Success");
    }
}
