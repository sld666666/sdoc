package com.sld.biz;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by diwu.sld on 2017/5/11.
 */

@Service("gitHubMananger")
public class GitHubManager {

    public boolean gitPull(String dir){
        try {
            Process process = Runtime.getRuntime().exec("git -C " + dir + " pull");
            boolean rtn = (0 == process.waitFor());
            ByteArrayOutputStream bytes=new ByteArrayOutputStream();
            process.getInputStream().read(bytes.toByteArray());
            String result = bytes.toString();

            if (false == rtn){

            }
            return  rtn;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }
}
