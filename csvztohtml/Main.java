package com.csvztohtml;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String[] columns=new String[6];
        StringBuilder sb = new StringBuilder();
        File file =new File("C:/Users/zhao/Desktop/test.csv");
        BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
        try {
            testOk(bufferedReader,sb,columns);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    private static void testOk(BufferedReader bufferedReader,StringBuilder sb,String[] columns) throws IOException {
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
        sb.append("<head><meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\"/>\n");
        sb.append("<title>CSV2HTML</title>\n");
        sb.append("<style type=\"text/css\">");
        sb.append("body{background-color:#FFF;color:#000;font-family:OpenSans,sans-serif;font-size:10px;}");
        sb.append("table{border:0.2em solid #2F6FAB;border-collapse:collapse;}");
        sb.append("th{border:0.15em solid #2F6FAB;padding:0.5em;background-color:#E9E9E9;}");
        sb.append("td{border:0.1em solid #2F6FAB;padding:0.5em;background-color:#F9F9F9;}</style>");
        sb.append("</head><body><h1>CSV2HTML</h1>\n");
        sb.append("<table>\n");
        String a="";
        while((a=bufferedReader.readLine())!=null){
            columns = a.split(",");
            bulidRow(columns,sb);
        }
        sb.append("</table></body></html>");
    }

    private static void bulidRow(String[] c,StringBuilder sb){
        sb.append("<tr>");
        for(int i=0;i<c.length;i++){
            sb.append("<th>");
            sb.append(c[i]);
            sb.append("</th>\n");
        }
        sb.append("</tr>\n");
    }
}
