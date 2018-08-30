
package student.management.app;

public class Session {
    private int sessionId;
    private String type;
    private int duration;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Session(int sessionId, String type, int duration) {
        this.sessionId = sessionId;
        this.type = type;
        this.duration = duration;
    }
    
}
