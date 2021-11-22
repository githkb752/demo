package com.ytt.ytt.htmltopdf.pdf;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WKLin{
    //linux
    public void exec(String cmd){
        InputStream ins = null;
        String[] cmds = new String[] {"/bin/sh","-c",cmd};
        try {
            Process process = Runtime.getRuntime().exec(cmds);
            ins = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitValue = process.waitFor();
            System.out.println(  exitValue);
            process.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
    }

    //window
    public void winExec(String cmd) {
        InputStream ins = null;
        String[] cmds = new String[] { "cmd.exe", "/C", "start "+cmd };  // 创建命令
        try {
            Process process = Runtime.getRuntime().exec(cmds);
            ins = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitValue = process.waitFor();
            process.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}