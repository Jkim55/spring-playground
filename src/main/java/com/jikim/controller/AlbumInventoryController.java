package com.jikim.controller;

import com.jikim.database.AlbumRepository;
import com.jikim.model.Album;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/album")
public class AlbumInventoryController {
    private final AlbumRepository repository;

    public AlbumInventoryController (AlbumRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Album> listAlbums() {
        return this.repository.findAll();
    }

    @PostMapping
    public Album createAlbum(@Valid @RequestBody Album album) {
        this.repository.save(album);
        return album;
    }
}