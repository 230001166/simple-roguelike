package dpruitt.entities;

public class Enemy extends Entity {
    private String aiLastAction = "none";

    public String getAiLastAction () {
        return aiLastAction;
    }
    public void setAiLastAction (String newAction) { aiLastAction = newAction; }

    public void AI (Entity player) {
    }

    public void awardExperience (Entity target) {
        target.modifyExperience (this.getExperience ());
    }
}
