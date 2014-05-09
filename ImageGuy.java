import java.io.File;

public class ImageGuy
{
    //private variable for getting the file path of the incoming image
    private File file;

    // ----------------------------------------------------------
    /**
     * Sets the internal file variable to the incoming new file location
     *
     * @param file  the file path of the new image
     */
    public ImageGuy(File file) {
        this.file = file;
    }

    // ----------------------------------------------------------
    /**
     * The getCurrentImageFile method that returns the current node's
     * file path.
     *
     * @return  returns the file path of the current node's image
     */
    public String getCurrentImageFile() {
        return file.getPath();
    }

}