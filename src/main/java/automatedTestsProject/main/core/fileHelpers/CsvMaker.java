package automatedTestsProject.main.core.fileHelpers;

import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvMaker {

    /**
     * Generating csv file
     *
     * @param listOfCsvRows - list of Objects arrays where every list element will create new csv row
     * @param csvFileName - name of creating csv file
     * @param headersOfCsvFile - name of header columns in creating csv file
     * @throws IOException
     */
    public void csvWithObjects(
            List<Object[]> listOfCsvRows,
            String csvFileName,
            String[] headersOfCsvFile
    ) throws IOException {

        File directory = new File(ResourcesPathFactory.CSV_TARGET);

        if (!directory.exists()){
            directory.mkdir();
        }

        String pathToCsvFile = ResourcesPathFactory.CSV_TARGET
                .concat(csvFileName);

        FileWriter csvFile = new FileWriter(pathToCsvFile);

        try (CSVPrinter printer = new CSVPrinter(
                csvFile,
                CSVFormat
                        .DEFAULT
                        .withHeader(headersOfCsvFile))) {

            for (Object[] row : listOfCsvRows) {
                printer.printRecord(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
