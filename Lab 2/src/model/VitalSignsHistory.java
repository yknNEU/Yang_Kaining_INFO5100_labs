package model;

import java.util.ArrayList;
import java.util.List;

public class VitalSignsHistory {

    public List<VitalSigns> history;

    public VitalSignsHistory() {
        this.history = new ArrayList<VitalSigns>();
    }

    public void addVitalSigns(VitalSigns vitalSigns) {
        history.add(vitalSigns);
    }

    public void removeVitalSigns(VitalSigns vitalSigns) {
        history.remove(vitalSigns);
    }

    public List<VitalSigns> getHistory() {
        return this.history;
    }

}
