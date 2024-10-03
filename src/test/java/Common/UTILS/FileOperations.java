package Common.UTILS;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * This class includes all the required methods for folder manipulation
 *
 */
public class FileOperations {

    private final String projectDir = System.getProperty("user.dir");
    private final String testdata = projectDir + "//src//test//resources//TestData//";
    private final String testResources = projectDir + "//src//test//resources//";
    private final String targetPath = projectDir + "//target//";
    private String FS = System.getProperty("file.separator");
    private Path TESTDATA_FILEPATH = Paths.get(testdata);
    private Path TARGET_FILEPATH = Paths.get(targetPath);
    private final String BaseImage_SNAPSHOTS = "\\..\\..\\VisualTestBaseImages\\";
	private final String Compare_RESULTS = "\\VisualTestResults\\";

    String TEST_DATA_FOR_ENVIRONMENT =
        TESTDATA_FILEPATH + FS + System.getProperty("env").toUpperCase() + FS;

    /**
     * Creates a folder in the required location
     */
    public void createOutputFolder() throws Exception {
        String StoreTextPath =
            System.getProperty("user.dir") + "//src//test//resources//";
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //Results folder path
        String storeTextResultsPatStoreTextPath =
            StoreTextPath +
            "\\StoreTextKeys" +
            "_" +
            (sdf.format(date)).replaceAll("[/: ]", "-");

        //Assigning the path to constants
        ContextStore.storeTextResultsPatStoreTextPath = storeTextResultsPatStoreTextPath;
        new File(storeTextResultsPatStoreTextPath).mkdir();
    }

    /**
     * Get path for punchoutAPIData folder
     * @return
     */
    public String getPunchoutAPIDataPath() {
        String filePath = TEST_DATA_FOR_ENVIRONMENT + "PunchoutAPIData" + FS;
        return filePath;
    }

    /**
     * Get punchout store level path under PunchoutAPIData folder
     * @return
     */
    public String getPunchoutAPIDataStoreLevelPath() {
        String filePath =
            TEST_DATA_FOR_ENVIRONMENT +
            "PunchoutAPIData" +
            FS +
            System.getProperty("store") +
            FS;
        return filePath;
    }

    /**
     * Get test-output folder path under target
     * @return
     */
    public String getTestOutputPath() {
        String outputPath = TARGET_FILEPATH + FS + "test-output" + FS;
        return outputPath;
    }

    /**
     * Get environment folder path under Test data
     * @return
     */
    public String getEnvFolderPath() {
        String outputPath = TEST_DATA_FOR_ENVIRONMENT;
        return outputPath;
    }

    /**
     * Get test/resources path
     * @return
     */
    public String getTestResourcesPath() {
        return testResources;
    }

    public String getBaseImagePath() {
    	return projectDir + BaseImage_SNAPSHOTS;
    }

    public String getCompareImageResultsPath() {
    	return TARGET_FILEPATH + Compare_RESULTS;
    }

    public int getCountOfFilesInDirectory(String strPathOfDirectory) {
    	int iCountOfFiles;
        try {
        	File directory=new File(strPathOfDirectory);
        	iCountOfFiles = directory.list().length;
        }catch(Exception e) {
        	iCountOfFiles = 0;
        }
    	return iCountOfFiles;
    }
    
    public String getDownloadFolderPath() {
    	String strHomeDirectory = System.getProperty("user.home");
    	return strHomeDirectory + FS + "Downloads";
    }
}
