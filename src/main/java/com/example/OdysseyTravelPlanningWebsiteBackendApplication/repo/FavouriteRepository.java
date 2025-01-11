package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite, String> {
    List<Favourite> findByUserIdAndItemType(String userId, String itemType);
}
