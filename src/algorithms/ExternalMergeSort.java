package algorithms;

import java.io.*;
import java.util.Arrays;

public class ExternalMergeSort {

    public int getSegments(int segmentSize, String file, String sortedSegmentsFile) throws Exception{
        //open the file and store the data into an array call each array as segment
        /*1.create an array/segment of size segmentSize
        2. read the elements from the input file and put them in the array
        3. sort the segment
        4. write the sorted segment to the sortedSegmentFile
        5.repeat step 2-4
        */
         int[] segment = new int[segmentSize];
        /**
         * FileInputStream can read bytes from file
         * BufferedInputStream - uses a buffer to collect the data read from file using FileInputStream, its a collection of bytes
         * InputStreamReader can be used in place of BufferedInputStream but it reads one character at a time so for efficiency we use BufferedInputStream
         * But we need to read the primitve type so we pass the buffered data to DataInputStreamReader which can read int,double etc
         * DataInputStream reads the byte and convert it to appropriate primitive type or strings. It reads/writes in machine independent fashion
         * therefore enable you to write data on one machine and read it on another machine that has a different operating system/ file structure.
         */
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(sortedSegmentsFile)));

        DataInputStream stream = new DataInputStream(new FileInputStream(file));

        int numberOfSegments = 0;

        while(input.available() > 0){
            numberOfSegments++;
            int i=0;
            for(;input.available()>0 && i< segmentSize;i++){
                segment[i] = input.readInt();
            }
            Arrays.parallelSort(segment);
            for(int j=0;j<i;j++){
                output.write(segment[j]);
            }
        }
        input.close();
        output.close();
        return numberOfSegments;
    }
    public void mergeSegments(int[] segment1, int[] segment2){

    }
}

