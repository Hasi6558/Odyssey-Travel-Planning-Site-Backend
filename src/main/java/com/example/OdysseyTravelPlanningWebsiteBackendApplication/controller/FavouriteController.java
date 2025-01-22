package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Favourite;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favourites")
@CrossOrigin(origins = "*")
public class FavouriteController {

    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favourite> getFavouriteById(@PathVariable String id) {
        Optional<Favourite> favourite = favouriteService.getFavouriteById(id);
        return favourite.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/addFavourite")
    public ResponseEntity<Favourite> addFavourite(@RequestBody Favourite favourite) {
        Favourite savedFavourite = favouriteService.addFavourite(favourite);
        return new ResponseEntity<>(savedFavourite, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Favourite>> getFavouritesByUserIdAndItemType(
            @RequestParam String userId,
            @RequestParam String itemType
    ) {
        List<Favourite> favourites = favouriteService.getFavouritesByUserIdAndItemType(userId, itemType);
        return ResponseEntity.ok(favourites);
    }
}
