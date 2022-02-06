public abstract class Person implements Locatable {

    private String name;
    private int posX;
    private int posY;


    public Person( String aName, int aPosX, int aPosY ) {
        name = aName;
        posX = aPosX;
        posY = aPosY;
    }

    public Person ( String aName ) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    //overrides from locatable interface
    @Override
    public int getX() {
        return posX;
    }

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }

}

