package com.cmdgames.rpg.service;

import com.cmdgames.rpg.repository.BannerRepository;

import java.io.IOException;
import java.net.URISyntaxException;

public class BannerService {

    private BannerRepository bannerRepository;

    public BannerService(){
        this.bannerRepository = new BannerRepository();
    }

    public String getTitle() {
        try {
           return this.bannerRepository.getFileContent("banners/title.txt");
        } catch (URISyntaxException | IOException e) {
            return "";
        }
    }

    public String getMountains() {
        try {
            return this.bannerRepository.getFileContent("banners/places/mountains.txt");
        } catch (URISyntaxException | IOException e) {
            return "";
        }
    }

    public String getRoad() {
        try {
            return this.bannerRepository.getFileContent("banners/places/road.txt");
        } catch (URISyntaxException | IOException e) {
            return "";
        }
    }

    public String getBase() {
        try {
            return this.bannerRepository.getFileContent("banners/places/base.txt");
        } catch (URISyntaxException | IOException e) {
            return "";
        }
    }

    public String getOldTemple() {
        try {
            return this.bannerRepository.getFileContent("banners/places/oldTemple.txt");
        } catch (URISyntaxException | IOException e) {
            return  "";
        }
    }
}
