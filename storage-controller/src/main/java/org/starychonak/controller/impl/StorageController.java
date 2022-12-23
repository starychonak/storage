package org.starychonak.controller.impl;

import org.starychonak.TestModel;
import org.starychonak.controller.StorageApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController implements StorageApi {

    @Override
    public ResponseEntity<Object> createStorage(Object body) {
        TestModel model = new TestModel();
        model.setId(1);
        return ResponseEntity.ok("Success");
    }
}
