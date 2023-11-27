package by.teachmeskills.lesson30.Factory;

public class MusicalGroupFactory {
    public MusicalGroup getMusicalGroup(String musicalGroupName) {
        switch (musicalGroupName.toLowerCase()) {
            case "first album":
                return new FirstAlbum();
            case "second album":
                return new SecondAlbum();
            case "third album":
                return new ThirdAlbum();
            default:
                return null;
        }
    }
}
