package com.jikim.controller;

import com.jikim.AlbumRepository;
import com.jikim.model.Album;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {
    private final AlbumRepository repository;

    public AlbumController (AlbumRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Album> listAlbums() {
        return this.repository.findAll();
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        this.repository.save(album);
    }

}
