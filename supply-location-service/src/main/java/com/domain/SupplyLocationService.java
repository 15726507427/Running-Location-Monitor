package com.domain;

import java.util.List;

public interface SupplyLocationService {
    List<SupplyLocation> saveSupplyLocationsZipContainsKeyword(List<SupplyLocation> locations);
}
