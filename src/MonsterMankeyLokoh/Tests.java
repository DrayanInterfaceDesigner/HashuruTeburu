package MonsterMankeyLokoh;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Tests {
    private long seed;
    public Tests(long seed) {
        this.seed = seed;
    }

    public Tests start(int hashType) {
        int xMax = 5;
        int hashAlgType;
        int[] hashTableSizes = new int[]{10, 100, 1_000, 10_000, 100_000},
        insertAmounts        = new int[]{20_000, 100_000, 500_000, 1_000_000, 5_000_000},
        searchAmounts        = new int[]{5,5,5,5,5};

        long[] insertionTimes  = new long[5],
        searchAVGTimes          = new long[5];

        hashAlgType = hashType;

        HashTable[] tables = new HashTable[5];
        for(int x = 0; x < xMax; x ++) tables[x] = new HashTable(hashType, hashTableSizes[x]);

        for(int x = 0; x < xMax; x ++) {
            long start = System.nanoTime();

            tables[x].Populate(this.seed, insertAmounts[x]);

            long end = System.nanoTime();
            insertionTimes[x] = (end - start);
        };


        int[][] keysToSearch = new int[5][5];
        for(int x = 0; x < xMax; x ++) keysToSearch[x] = tables[x].getKeysToSearch();

        for(int x = 0; x < xMax; x ++) {

            long start = System.nanoTime();

            for(int y = 0; y < 5; y++) {
                tables[x].Search(keysToSearch[x][y]);
            }

            long end = System.nanoTime();
            searchAVGTimes[x] = ((end - start)) / 5;
        }
        
        // writing
        for(int x = 0; x < xMax; x ++) {
            this.writeCSV(
                    hashAlgType,
                    hashTableSizes[x],
                    insertAmounts[x],
                    insertionTimes[x],
                    searchAmounts[x],
                    searchAVGTimes[x]
            );
        };

        return this;
    }

    private void writeCSV(
            int hashAlgType,
            int hashTableSize,
            int insertAmount,
            long insertTime,
            int searchAmount,
            long searchAVGTime
    ) {
        String filePath = "HashType_" + hashAlgType + "_out.csv";

        try (FileWriter fileWriter = new FileWriter(filePath, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {

            writer.printf("%d,%d,%d,%d,%d,%d%n",
                    hashAlgType,
                    hashTableSize,
                    insertAmount,
                    insertTime,
                    searchAmount,
                    searchAVGTime
            );
            // x / 1MI | nano -> sec

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
