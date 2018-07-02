package com.service;

import com.model.CurrentPosition;

public interface PositionService {

    void processPositionInfo(long id, CurrentPosition currentPosition, boolean sendPositionToDistributionService);
}
