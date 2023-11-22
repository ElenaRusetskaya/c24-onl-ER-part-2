package by.teachmeskills.lesson30.Factory;

public class MyAlbumCollection {
    public static void main(String[] args) {
        MusicalGroupFactory factory = new MusicalGroupFactory();

        MusicalGroup musicalGroup = factory.getMusicalGroup("FirstAlbum");
        musicalGroup.purchase();
        musicalGroup = factory.getMusicalGroup("SecondAlbum");
        musicalGroup.purchase();
        musicalGroup = factory.getMusicalGroup("ThirdAlbum");
        musicalGroup.purchase();
    }
}
