package DynamicPrograming;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class InterfaceMaker {
    private Path pathHelper = Paths.get(".");
    private String inputDirectory;

    // constructors.....................................................................................................
    // empty constructor...
    public InterfaceMaker() {

    }

    // set the input directory initially....
    public InterfaceMaker(String id)  {
        this.inputDirectory = id;
    }

    // methods..........................................................................................................
    /*
     * This function will be responsible for setting new input directory...
     * */
    public void setInputDirectory(String inputDirectory) {
        this.inputDirectory = inputDirectory;
    }

    /*
     * This function will be responsible for getting the file...
     **/
    public FileReader getFile(String fileName) throws FileNotFoundException {
        return new FileReader(pathHelper.toAbsolutePath().toString()+"//src"+"//"+this.inputDirectory+"//"+fileName);
    }

}
