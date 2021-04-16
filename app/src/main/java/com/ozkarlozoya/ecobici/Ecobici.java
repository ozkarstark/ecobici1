package com.ozkarlozoya.ecobici;

import java.util.ArrayList;
import java.util.List;

public class Ecobici {

    private Network network;

    public void setNetwork(Network network){
        this.network = network;
    }
    public Network getNetwork(){
        return this.network;
    }
}

class Location
{
    private String city;

    private String country;

    private double latitude;

    private double longitude;

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
}



class Stations
{
    private int empty_slots;

    private int free_bikes;

    private String id;

    private double latitude;

    private double longitude;

    private String name;

    private String timestamp;

    public void setEmpty_slots(int empty_slots){
        this.empty_slots = empty_slots;
    }
    public int getEmpty_slots(){
        return this.empty_slots;
    }
    public void setFree_bikes(int free_bikes){
        this.free_bikes = free_bikes;
    }
    public int getFree_bikes(){
        return this.free_bikes;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }
    public String getTimestamp(){
        return this.timestamp;
    }
}

class Network
{
    private List<String> company;

    private String href;

    private String id;

    private Location location;

    private String name;

    private List<Stations> stations;

    public void setCompany(List<String> company){
        this.company = company;
    }
    public List<String> getCompany(){
        return this.company;
    }
    public void setHref(String href){
        this.href = href;
    }
    public String getHref(){
        return this.href;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setStations(List<Stations> stations){
        this.stations = stations;
    }
    public List<Stations> getStations(){
        return this.stations;
    }
}