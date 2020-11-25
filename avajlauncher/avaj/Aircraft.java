package avaj;

class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long __idCounter = 1L;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = __idCounter;
        __idCounter = nextId();
    }

    private static long nextId() {
        return (++__idCounter);
    }

}
