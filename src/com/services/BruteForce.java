package com.services;

import com.util.FileUtil;

import java.io.File;
import java.io.IOException;

import static com.services.Decryption.decryptData;
import static com.сonstants.Constants.MAX_BRUTE_FORCE_KEY;

public class BruteForce {
    public void runBruteForce (String inputString) throws IOException {
        for (int i = 0; i <= MAX_BRUTE_FORCE_KEY; i++) {
            String result = decryptData(inputString, i);
            String fileName = "result_" + i;
            File file = new File("files/" + fileName);
            file.createNewFile();
            FileUtil currentFile = new FileUtil("files/" + fileName);

           currentFile.writeFile(result);
        }
    }
}
