package com.jikim;

import com.jikim.controller.AlbumInventoryController;
import com.jikim.database.AlbumRepository;
import com.jikim.model.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumInventoryController.class)
public class AlbumControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    AlbumRepository repository;

    @Test
    public void CanCreateAlbum() throws Exception {
        String albumJSON = getJSON("/albumdata.json");

        MockHttpServletRequestBuilder postRequest = post("/album")
                .contentType(MediaType.APPLICATION_JSON)
                .content(albumJSON);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Merriweather Post Pavilion")))
                .andExpect(jsonPath("$.artist", equalTo("Animal Collective")));

        verify(this.repository).save(any(Album.class));

    }

    @Test
    public void CanGetAlbum() throws Exception {
        Long id = new Random().nextLong();
        Album album = new Album();
        album.setId(id);
        album.setTitle("Biophilia");
        album.setArtist("Björk");

        when(this.repository.findAll()).thenReturn(Collections.singletonList(album));

        MockHttpServletRequestBuilder getRequest = get("/album")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(id)))
                .andExpect(jsonPath("$[0].title", equalTo("Biophilia")))
                .andExpect(jsonPath("$[0].artist", equalTo("Björk")));

    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.toURI())));
    }

}