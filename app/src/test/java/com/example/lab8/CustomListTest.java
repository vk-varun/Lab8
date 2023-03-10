package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add a city to the list
     * check if the city exists, hasCity gives true
     */
    @Test
    public void testHasCity() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * add a city to the list, check size of list
     * then delete the city, check size of list
     * it should decrease after delete
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
        assertEquals(0, list.getCount());
    }

    /**
     * initially list is empty count = 0
     * new city added, check count  = 1
     * city deleted, check count = 0
     */
    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.countCities());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.countCities());
        list.deleteCity(city);
        assertEquals(0, list.countCities());
    }

}
