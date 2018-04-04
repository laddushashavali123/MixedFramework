package com.docker.cucumber.merger;

import org.apache.commons.io.FileUtils;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.UUID;
/**
 * 
 * 
 * This merger should be modified due to your project scale. 
 * For now report.json is unparsable by maven-cucumber-reporting 
 * @author yarkh
 *
 */
public class ReportMerger {
    private static final String reportFileName = "report.json";
    private static String reportImageExtension = "png";
    
    public static void main(String[] args) throws Throwable {
        File reportDirectory = new File(args[0]);
        System.out.println(reportDirectory.getAbsolutePath());
        if (reportDirectory.exists()) {
        	File mergedReport = new File (reportDirectory.getAbsolutePath()+"/"+reportFileName);
        	mergedReport.createNewFile();
            ReportMerger munger = new ReportMerger();
            munger.mergeReports(reportDirectory,mergedReport);
        }
    }

    /**
     * Merge all reports together into master report in given reportDirectory
     * @param reportDirectory
     * @throws Exception
     */
    public void mergeReports(File reportDirectory, File mergedReport) throws Throwable {
    	
        Collection<File> existingReports = FileUtils.listFiles(reportDirectory, new String[]{"json"}, true);

       

        for (File report : existingReports) {
        	System.out.println(report.getAbsolutePath());
        	mergeFiles(mergedReport, report);
            //only address report files
    /*    	
          //  if (report.getName().equals(reportFileName)) {
            	System.out.println("Hello uuuu");
                //rename all the image files (to give unique names) in report directory and update report
                renameEmbededImages(report);

                //if we are on the first pass, copy the directory of the file to use as basis for merge
               
                if (mergedReport == null) {
                    FileUtils.copyDirectory(report.getParentFile(), reportDirectory);
                    mergedReport = new File(reportDirectory, reportFileName);
                //otherwise merge this report into existing master report
                } else {
                    mergeFiles(mergedReport, report);
                }
            //}
        * 
        */
    }
    }

    /**
     * merge source file into target
     *
     * @param target
     * @param source
     */
    public void mergeFiles(File target, File source) throws Throwable {
        //copy embeded images
        Collection<File> embeddedImages = FileUtils.listFiles(source.getParentFile(), new String[]{reportImageExtension}, true);
        for (File image : embeddedImages) {
            FileUtils.copyFileToDirectory(image, target.getParentFile());
        }

        //merge report files
        String targetReport = FileUtils.readFileToString(target, Charset.defaultCharset());
        String sourceReport = FileUtils.readFileToString(source, Charset.defaultCharset());

        FileUtils.writeStringToFile(target, targetReport + sourceReport, Charset.defaultCharset());
    }

    /**
     * Give unique names to embedded images to ensure they aren't lost during merge
     * Update report file to reflect new image names
     *
     * @param reportFile
     */
    public void renameEmbededImages(File reportFile) throws Throwable {
        File reportDirectory = reportFile.getParentFile();
        Collection<File> embeddedImages = FileUtils.listFiles(reportDirectory, new String[]{reportImageExtension}, true);

        String fileAsString = FileUtils.readFileToString(reportFile, Charset.defaultCharset());

        for (File image : embeddedImages) {
            String curImageName = image.getName();
            String uniqueImageName = UUID.randomUUID().toString() + "." + reportImageExtension;

            image.renameTo(new File(reportDirectory, uniqueImageName));
            fileAsString = fileAsString.replace(curImageName, uniqueImageName);
        }

        FileUtils.writeStringToFile(reportFile, fileAsString, Charset.defaultCharset());
    }
}