class Clock {

    private int minutes;

    public Clock(int minutes) {
        this.setMinutes(minutes);
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes % 60;
    }

    public int getMinutes() {
        return minutes;
    }

}

