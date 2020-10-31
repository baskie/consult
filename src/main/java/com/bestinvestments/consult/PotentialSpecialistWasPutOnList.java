package com.bestinvestments.consult;

import com.bestinvestments.prospecting.ProspectListener;

import java.util.ArrayList;
import java.util.List;

public class PotentialSpecialistWasPutOnList {
    private List<ProspectListener> listeners = new ArrayList<ProspectListener>();

    public void addListener(ProspectListener pSpec) {
        listeners.add(pSpec);
    }

    public void sendPotentialSpecialist() {
        System.out.println("Sending Potential Specialist");

        // Notify everybody that may be interested.
        for (ProspectListener hl : listeners)
            hl.prospectWasSent();
    }
}
