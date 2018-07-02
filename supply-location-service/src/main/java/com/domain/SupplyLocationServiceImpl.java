package com.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyLocationServiceImpl implements SupplyLocationService {

    private SupplyLocationRepository repository;
    private final String KEYWORD = "908";

    @Autowired
    public SupplyLocationServiceImpl(SupplyLocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SupplyLocation> saveSupplyLocationsZipContainsKeyword(List<SupplyLocation> locations) {
        List<SupplyLocation> save = filterList(locations, KEYWORD);
        return (ArrayList<SupplyLocation>) this.repository.saveAll(save);
    }

    private List<SupplyLocation> filterList(List<SupplyLocation> listToFilter, String keyword) {
        List<SupplyLocation> save = new ArrayList<>();
        for (SupplyLocation supplyLocation : listToFilter) {
            if (supplyLocation.getZip().contains(keyword)) {
                save.add(supplyLocation);
            }
        }
        return save;
    }
}
