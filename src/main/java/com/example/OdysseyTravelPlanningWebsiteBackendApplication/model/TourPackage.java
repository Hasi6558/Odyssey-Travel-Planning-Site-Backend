package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "travelPackages")
public class TourPackage {
    @Id
    private String tourPackageId;

    private String title;
    private LocalDate tourStartDate;
    private LocalDate tourEndDate;
    private String description;
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private String tourId;

    // Getters and Setters
    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getTourStartDate() {
        return tourStartDate;
    }

    public void setTourStartDate(LocalDate tourStartDate) {
        this.tourStartDate = tourStartDate;
    }

    public LocalDate getTourEndDate() {
        return tourEndDate;
    }

    public void setTourEndDate(LocalDate tourEndDate) {
        this.tourEndDate = tourEndDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
